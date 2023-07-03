package com.inditex.visibility.mappers;

import com.inditex.visibility.data.ProductDto;
import com.inditex.visibility.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {SizeMapper.class})
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto productToProductDto(Product product);

    Product productDtoToProduct(ProductDto productDto);

    List<ProductDto> productListToProductDtoList(List<Product> productList);

    List<Product> productDtoListToProductList(List<ProductDto> productDtoList);
}
