package com.inditex.visibility.service;

import com.inditex.visibility.data.StockDto;
import com.inditex.visibility.ports.spi.StockPersistencePort;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.inditex.visibility.TestObjects.getStockDto;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StockServiceImplTest {

    @InjectMocks
    private StockServiceImpl stockService;

    @Mock
    private StockPersistencePort stockPersistencePort;

    @Test
    @SneakyThrows
    @DisplayName("Should create a Stock")
    void addStock() {
        // Given
        var stockDto = getStockDto();

        // When
        when(stockPersistencePort.addStock(any())).thenReturn(stockDto);

        // Then
        var result = stockService.addStock(stockDto);

        assertNotNull(result);
        assertStock(result);
    }

    @Test
    @SneakyThrows
    @DisplayName("Should delete a Stock by id")
    void deleteStockById() {
        // Given
        // When
        // Then
        assertDoesNotThrow(() -> stockService.deleteStockById(1L));
    }

    @Test
    @SneakyThrows
    @DisplayName("Should update a Stock")
    void updateStock() {
        // Given
        var stockDto = getStockDto();

        // When
        when(stockPersistencePort.updateStock(any())).thenReturn(stockDto);

        // Then
        var result = stockService.updateStock(stockDto);

        assertNotNull(result);
        assertStock(result);
    }

    @Test
    @SneakyThrows
    @DisplayName("Should get all Stocks")
    void getAllStocks() {
        // Given
        var stockDto = getStockDto();

        // When
        when(stockPersistencePort.getAllStocks()).thenReturn(List.of(stockDto));

        // Then
        var result = stockService.getAllStocks();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertStock(result.get(0));
    }

    @Test
    @SneakyThrows
    @DisplayName("Should get a Stock by id")
    void getStockById() {
        // Given
        var stockDto = getStockDto();

        // When
        when(stockPersistencePort.getStockById(anyLong())).thenReturn(stockDto);

        // Then
        var result = stockService.getStockById(1L);

        assertNotNull(result);
        assertStock(result);
    }

    private void assertStock(StockDto stockDto) {
        assertEquals(1L, stockDto.getId());
        assertEquals(1, stockDto.getQuantity());
    }
}