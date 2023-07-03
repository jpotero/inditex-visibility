package com.inditex.visibility.adapters;

import com.inditex.visibility.data.StockDto;
import com.inditex.visibility.mappers.StockMapper;
import com.inditex.visibility.ports.spi.StockPersistencePort;
import com.inditex.visibility.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StockJpaAdapter implements StockPersistencePort {

    private StockRepository stockRepository;

    @Override
    public StockDto addStock(StockDto stockDto) {
        var stock = StockMapper.INSTANCE.stockDtoToStock(stockDto);
        var stockSaved = stockRepository.save(stock);
        return StockMapper.INSTANCE.stockToStockDto(stockSaved);
    }

    @Override
    public void deleteStockById(Long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public StockDto updateStock(StockDto stockDto) {
        return addStock(stockDto);
    }

    @Override
    public List<StockDto> getAllStocks() {
        var stockList = stockRepository.findAll();
        return StockMapper.INSTANCE.stockListToStockDtoList(stockList);
    }

    @Override
    public StockDto getStockById(Long id) {
        var stock = stockRepository.findById(id);
        return stock.map(StockMapper.INSTANCE::stockToStockDto).orElse(null);
    }
}
