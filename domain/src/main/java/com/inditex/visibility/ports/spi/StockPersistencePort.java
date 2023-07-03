package com.inditex.visibility.ports.spi;

import com.inditex.visibility.data.StockDto;

import java.util.List;

public interface StockPersistencePort {

    StockDto addStock(StockDto stockDto);

    void deleteStockById(Long id);

    StockDto updateStock(StockDto stockDto);

    List<StockDto> getAllStocks();

    StockDto getStockById(Long id);
}
