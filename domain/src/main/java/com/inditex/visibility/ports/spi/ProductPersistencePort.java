package com.inditex.visibility.ports.spi;

import com.inditex.visibility.data.ProductDto;

import java.util.List;

public interface ProductPersistencePort {

    ProductDto addProduct(ProductDto productDto);

    void deleteProductById(Long id);

    ProductDto updateProduct(ProductDto productDto);

    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long id);
}
