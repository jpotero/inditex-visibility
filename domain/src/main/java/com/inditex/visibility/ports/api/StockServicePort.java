package com.inditex.visibility.ports.api;

import com.inditex.visibility.data.StockDto;

import java.util.List;

public interface StockServicePort {

    StockDto addStock(StockDto stockDto);

    void deleteStockById(Long id);

    StockDto updateStock(StockDto stockDto);

    List<StockDto> getAllStocks();

    StockDto getStockById(Long id);
}
