package com.inditex.visibility.adapters;

import com.inditex.visibility.data.SizeDto;
import com.inditex.visibility.repository.SizeRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.inditex.visibility.TestObjects.getSize;
import static com.inditex.visibility.TestObjects.getSizeDto;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SizeJpaAdapterTest {

    @InjectMocks
    private SizeJpaAdapter sizeJpaAdapter;

    @Mock
    private SizeRepository sizeRepository;

    @Test
    @SneakyThrows
    @DisplayName("Should create a size")
    void addSize() {
        // Given
        var sizeDto = getSizeDto();
        var size = getSize();

        // When
        when(sizeRepository.save(any())).thenReturn(size);

        // Then
        var result = sizeJpaAdapter.addSize(sizeDto);

        assertNotNull(result);
        assertSize(result);
    }

    @Test
    @SneakyThrows
    @DisplayName("Should delete a size by id")
    void deleteSizeById() {
        // Given
        // When
        // Then
        assertDoesNotThrow(() -> sizeJpaAdapter.deleteSizeById(1L));
    }

    @Test
    @SneakyThrows
    @DisplayName("Should update a size")
    void updateSize() {
        // Given
        var sizeDto = getSizeDto();
        var size = getSize();

        // When
        when(sizeRepository.save(any())).thenReturn(size);

        // Then
        var result = sizeJpaAdapter.updateSize(sizeDto);

        assertNotNull(result);
        assertSize(result);
    }

    @Test
    @SneakyThrows
    @DisplayName("Should get all sizes")
    void getAllSizes() {
        // Given
        var size = getSize();

        // When
        when(sizeRepository.findAll()).thenReturn(List.of(size));

        // Then
        var result = sizeJpaAdapter.getAllSizes();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertSize(result.get(0));
    }

    @Test
    @SneakyThrows
    @DisplayName("Should get a size by id")
    void getSizeById() {
        // Given
        var size = getSize();

        // When
        when(sizeRepository.findById(anyLong())).thenReturn(Optional.of(size));

        // Then
        var result = sizeJpaAdapter.getSizeById(1L);

        assertNotNull(result);
        assertSize(result);
    }

    private void assertSize(SizeDto sizeDto) {
        assertEquals(1L, sizeDto.getId());
        assertTrue(sizeDto.isBackSoon());
        assertFalse(sizeDto.isSpecial());
        assertNotNull(sizeDto.getStock());
        assertEquals(1L, sizeDto.getStock().getId());
        assertEquals(1, sizeDto.getStock().getQuantity());
    }
}