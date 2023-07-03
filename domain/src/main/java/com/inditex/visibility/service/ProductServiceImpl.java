package com.inditex.visibility.service;

import com.inditex.visibility.data.ProductDto;
import com.inditex.visibility.ports.api.ProductServicePort;
import com.inditex.visibility.ports.spi.ProductPersistencePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductServicePort {

    private ProductPersistencePort productPersistencePort;

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        return productPersistencePort.addProduct(productDto);
    }

    @Override
    public void deleteProductById(Long id) {
        productPersistencePort.deleteProductById(id);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return productPersistencePort.updateProduct(productDto);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        var allProducts = productPersistencePort.getAllProducts();

        var allProductsBackSoon = allProducts.stream()
                .filter(productDto -> productDto.getSizeList().stream()
                        .anyMatch(sizeDto -> !sizeDto.isSpecial() && sizeDto.isBackSoon()))
                .toList();
        var allFilteredProducts = new HashSet<>(allProductsBackSoon);
        var allProductsSpecial = allProducts.stream()
                .filter(productDto -> productDto.getSizeList().stream().anyMatch(sizeDto -> !sizeDto.isSpecial() && sizeDto.isBackSoon())
                        && productDto.getSizeList().stream().anyMatch(sizeDto -> sizeDto.isBackSoon() && sizeDto.isSpecial()))
                .toList();
        allFilteredProducts.addAll(allProductsSpecial);

        return allFilteredProducts.stream().toList();
    }

    @Override
    public String getProductIds() {
        return getAllProducts().stream()
                .map(productDto -> productDto.getId().toString())
                .collect(Collectors.joining(","));
    }

    @Override
    public ProductDto getProductById(Long id) {
        return productPersistencePort.getProductById(id);
    }
}
