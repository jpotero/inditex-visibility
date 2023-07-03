package com.inditex.visibility.adapters;

import com.inditex.visibility.data.ProductDto;
import com.inditex.visibility.mappers.ProductMapper;
import com.inditex.visibility.ports.spi.ProductPersistencePort;
import com.inditex.visibility.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductJpaAdapter implements ProductPersistencePort {

    private ProductRepository productRepository;

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        var product = ProductMapper.INSTANCE.productDtoToProduct(productDto);
        var productSaved = productRepository.save(product);
        return ProductMapper.INSTANCE.productToProductDto(productSaved);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return addProduct(productDto);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        var productList = productRepository.findAllByOrderBySequenceAsc();
        return ProductMapper.INSTANCE.productListToProductDtoList(productList);
    }

    @Override
    public ProductDto getProductById(Long id) {
        var product = productRepository.findById(id);
        return product.map(ProductMapper.INSTANCE::productToProductDto).orElse(null);
    }
}
