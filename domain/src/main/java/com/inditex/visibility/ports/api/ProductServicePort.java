package com.inditex.visibility.ports.api;

import com.inditex.visibility.data.ProductDto;

import java.util.List;

public interface ProductServicePort {

    ProductDto addProduct(ProductDto productDto);

    void deleteProductById(Long id);

    ProductDto updateProduct(ProductDto productDto);

    List<ProductDto> getAllProducts();

    String getProductIds();

    ProductDto getProductById(Long id);
}
