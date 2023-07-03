package com.inditex.visibility.adapters;

import com.inditex.visibility.data.ProductDto;
import com.inditex.visibility.repository.ProductRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.inditex.visibility.TestObjects.getProduct;
import static com.inditex.visibility.TestObjects.getProductDto;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductJpaAdapterTest {

    @InjectMocks
    private ProductJpaAdapter productJpaAdapter;

    @Mock
    private ProductRepository productRepository;

    @Test
    @SneakyThrows
    @DisplayName("Should create a product")
    void addProduct() {
        // Given
        var productDto = getProductDto();
        var product = getProduct();

        // When
        when(productRepository.save(any())).thenReturn(product);

        // Then
        var result = productJpaAdapter.addProduct(productDto);

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
        assertDoesNotThrow(() -> productJpaAdapter.deleteProductById(1L));
    }

    @Test
    @SneakyThrows
    @DisplayName("Should update a product")
    void updateProduct() {
        // Given
        var productDto = getProductDto();
        var product = getProduct();

        // When
        when(productRepository.save(any())).thenReturn(product);

        // Then
        var result = productJpaAdapter.updateProduct(productDto);

        assertNotNull(result);
        assertProduct(result);
    }

    @Test
    @SneakyThrows
    @DisplayName("Should get all products")
    void getAllProducts() {
        // Given
        var product = getProduct();

        // When
        when(productRepository.findAllByOrderBySequenceAsc()).thenReturn(List.of(product));

        // Then
        var result = productJpaAdapter.getAllProducts();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertProduct(result.get(0));
    }

    @Test
    @SneakyThrows
    @DisplayName("Should get a product by id")
    void getProductById() {
        // Given
        var product = getProduct();

        // When
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));

        // Then
        var result = productJpaAdapter.getProductById(1L);

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