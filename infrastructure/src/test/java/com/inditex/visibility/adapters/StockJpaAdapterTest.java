package com.inditex.visibility.adapters;

import com.inditex.visibility.data.StockDto;
import com.inditex.visibility.repository.StockRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.inditex.visibility.TestObjects.getStock;
import static com.inditex.visibility.TestObjects.getStockDto;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StockJpaAdapterTest {

    @InjectMocks
    private StockJpaAdapter stockJpaAdapter;

    @Mock
    private StockRepository stockRepository;

    @Test
    @SneakyThrows
    @DisplayName("Should create a stock")
    void addStock() {
        // Given
        var stockDto = getStockDto();
        var stock = getStock();

        // When
        when(stockRepository.save(any())).thenReturn(stock);

        // Then
        var result = stockJpaAdapter.addStock(stockDto);

        assertNotNull(result);
        assertStock(result);
    }

    @Test
    @SneakyThrows
    @DisplayName("Should delete a stock by id")
    void deleteStockById() {
        // Given
        // When
        // Then
        assertDoesNotThrow(() -> stockJpaAdapter.deleteStockById(1L));
    }

    @Test
    @SneakyThrows
    @DisplayName("Should update a stock")
    void updateStock() {
        // Given
        var stockDto = getStockDto();
        var stock = getStock();

        // When
        when(stockRepository.save(any())).thenReturn(stock);

        // Then
        var result = stockJpaAdapter.updateStock(stockDto);

        assertNotNull(result);
        assertStock(result);
    }

    @Test
    @SneakyThrows
    @DisplayName("Should get all stocks")
    void getAllStocks() {
        // Given
        var stock = getStock();

        // When
        when(stockRepository.findAll()).thenReturn(List.of(stock));

        // Then
        var result = stockJpaAdapter.getAllStocks();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertStock(result.get(0));
    }

    @Test
    @SneakyThrows
    @DisplayName("Should get a stock by id")
    void getStockById() {
        // Given
        var stock = getStock();

        // When
        when(stockRepository.findById(anyLong())).thenReturn(Optional.of(stock));

        // Then
        var result = stockJpaAdapter.getStockById(1L);

        assertNotNull(result);
        assertStock(result);
    }

    private void assertStock(StockDto stockDto) {
        assertEquals(1L, stockDto.getId());
        assertEquals(1, stockDto.getQuantity());
    }
}