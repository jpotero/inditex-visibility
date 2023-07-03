package com.inditex.visibility.service;

import com.inditex.visibility.data.StockDto;
import com.inditex.visibility.ports.api.StockServicePort;
import com.inditex.visibility.ports.spi.StockPersistencePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StockServiceImpl implements StockServicePort {

    private StockPersistencePort stockPersistencePort;

    @Override
    public StockDto addStock(StockDto stockDto) {
        return stockPersistencePort.addStock(stockDto);
    }

    @Override
    public void deleteStockById(Long id) {
        stockPersistencePort.deleteStockById(id);
    }

    @Override
    public StockDto updateStock(StockDto stockDto) {
        return stockPersistencePort.updateStock(stockDto);
    }

    @Override
    public List<StockDto> getAllStocks() {
        return stockPersistencePort.getAllStocks();
    }

    @Override
    public StockDto getStockById(Long id) {
        return stockPersistencePort.getStockById(id);
    }
}
