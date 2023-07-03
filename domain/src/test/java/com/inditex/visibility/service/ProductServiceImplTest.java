package com.inditex.visibility.service;

import com.inditex.visibility.data.ProductDto;
import com.inditex.visibility.ports.spi.ProductPersistencePort;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.inditex.visibility.TestObjects.getProductDto;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductPersistencePort productPersistencePort;

    @Test
    @SneakyThrows
    @DisplayName("Should create a product")
    void addProduct() {
        // Given
        var productDto = getProductDto();

        // When
        when(productPersistencePort.addProduct(any())).thenReturn(productDto);

        // Then
        var result = productService.addProduct(productDto);

        assertNotNull(result);
        assertProduct(result);
    }

    @Test
    @SneakyThrows
    @DisplayName("Should delete a product by id")
    void deleteProductById() {
        // Given
        // When
        // Then
        assertDoesNotThrow(() -> productService.deleteProductById(1L));
    }

    @Test
    @SneakyThrows
    @DisplayName("Should update a product")
    void updateProduct() {
        // Given
        var productDto = getProductDto();

        // When
        when(productPersistencePort.updateProduct(any())).thenReturn(productDto);

        // Then
        var result = productService.updateProduct(productDto);

        assertNotNull(result);
        assertProduct(result);
    }

    @Test
    @SneakyThrows
    @DisplayName("Should get all products")
    void getAllProducts() {
        // Given
        var productDto = getProductDto();

        // When
        when(productPersistencePort.getAllProducts()).thenReturn(List.of(productDto));

        // Then
        var result = productService.getAllProducts();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertProduct(result.get(0));
    }

    @Test
    @SneakyThrows
    @DisplayName("Should get all product ids")
    void getProductIds() {
        // Given
        var productDto = getProductDto();

        // When
        when(productPersistencePort.getAllProducts()).thenReturn(List.of(productDto));

        // Then
        var result = productService.getProductIds();

        assertNotNull(result);
        assertEquals("1", result);
    }

    @Test
    @SneakyThrows
    @DisplayName("Should get a product by id")
    void getProductById() {
        // Given
        var productDto = getProductDto();

        // When
        when(productPersistencePort.getProductById(anyLong())).thenReturn(productDto);

        // Then
        var result = productService.getProductById(1L);

        assertNotNull(result);
        assertProduct(result);
    }

    private void assertProduct(ProductDto productDto) {
        assertEquals(1L, productDto.getId());
        assertEquals(1, productDto.getSequence());
        assertNotNull(productDto.getSizeList());
        assertEquals(1, productDto.getSizeList().size());
        assertEquals(1L, productDto.getSizeList().get(0).getId());
        assertTrue(productDto.getSizeList().get(0).isBackSoon());
        assertFalse(productDto.getSizeList().get(0).isSpecial());
        assertNotNull(productDto.getSizeList().get(0).getStock());
        assertEquals(1L, productDto.getSizeList().get(0).getStock().getId());
        assertEquals(1, productDto.getSizeList().get(0).getStock().getQuantity());
    }
}