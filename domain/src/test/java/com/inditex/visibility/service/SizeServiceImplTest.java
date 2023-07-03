package com.inditex.visibility.service;

import com.inditex.visibility.data.SizeDto;
import com.inditex.visibility.ports.spi.SizePersistencePort;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.inditex.visibility.TestObjects.getSizeDto;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SizeServiceImplTest {

    @InjectMocks
    private SizeServiceImpl sizeService;

    @Mock
    private SizePersistencePort sizePersistencePort;

    @Test
    @SneakyThrows
    @DisplayName("Should create a Size")
    void addSize() {
        // Given
        var sizeDto = getSizeDto();

        // When
        when(sizePersistencePort.addSize(any())).thenReturn(sizeDto);

        // Then
        var result = sizeService.addSize(sizeDto);

        assertNotNull(result);
        assertSize(result);
    }

    @Test
    @SneakyThrows
    @DisplayName("Should delete a Size by id")
    void deleteSizeById() {
        // Given
        // When
        // Then
        assertDoesNotThrow(() -> sizeService.deleteSizeById(1L));
    }

    @Test
    @SneakyThrows
    @DisplayName("Should update a Size")
    void updateSize() {
        // Given
        var sizeDto = getSizeDto();

        // When
        when(sizePersistencePort.updateSize(any())).thenReturn(sizeDto);

        // Then
        var result = sizeService.updateSize(sizeDto);

        assertNotNull(result);
        assertSize(result);
    }

    @Test
    @SneakyThrows
    @DisplayName("Should get all Sizes")
    void getAllSizes() {
        // Given
        var sizeDto = getSizeDto();

        // When
        when(sizePersistencePort.getAllSizes()).thenReturn(List.of(sizeDto));

        // Then
        var result = sizeService.getAllSizes();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertSize(result.get(0));
    }

    @Test
    @SneakyThrows
    @DisplayName("Should get a Size by id")
    void getSizeById() {
        // Given
        var sizeDto = getSizeDto();

        // When
        when(sizePersistencePort.getSizeById(anyLong())).thenReturn(sizeDto);

        // Then
        var result = sizeService.getSizeById(1L);

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