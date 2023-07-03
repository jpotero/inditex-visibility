package com.inditex.visibility.ports.spi;

import com.inditex.visibility.data.SizeDto;

import java.util.List;

public interface SizePersistencePort {

    SizeDto addSize(SizeDto sizeDto);

    void deleteSizeById(Long id);

    SizeDto updateSize(SizeDto sizeDto);

    List<SizeDto> getAllSizes();

    SizeDto getSizeById(Long id);

    List<SizeDto> getAllSizesByProductId(Long id);
}
