package com.inditex.visibility;

import com.inditex.visibility.data.ProductDto;
import com.inditex.visibility.data.SizeDto;
import com.inditex.visibility.data.StockDto;

import java.util.List;

public class TestObjects {

    public static StockDto getStockDto() {
        return StockDto.builder()
                .id(1L)
                .quantity(1)
                .build();
    }

    public static SizeDto getSizeDto() {
        return SizeDto.builder()
                .id(1L)
                .backSoon(true)
                .special(false)
                .stock(getStockDto())
                .build();
    }

    public static ProductDto getProductDto() {
        return ProductDto.builder()
                .id(1L)
                .sequence(1)
                .sizeList(List.of(getSizeDto()))
                .build();
    }
}
