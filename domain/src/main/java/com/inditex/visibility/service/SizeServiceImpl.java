package com.inditex.visibility.service;

import com.inditex.visibility.data.SizeDto;
import com.inditex.visibility.ports.api.SizeServicePort;
import com.inditex.visibility.ports.spi.SizePersistencePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SizeServiceImpl implements SizeServicePort {

    private SizePersistencePort sizePersistencePort;

    @Override
    public SizeDto addSize(SizeDto sizeDto) {
        return sizePersistencePort.addSize(sizeDto);
    }

    @Override
    public void deleteSizeById(Long id) {
        sizePersistencePort.deleteSizeById(id);
    }

    @Override
    public SizeDto updateSize(SizeDto sizeDto) {
        return sizePersistencePort.updateSize(sizeDto);
    }

    @Override
    public List<SizeDto> getAllSizes() {
        return sizePersistencePort.getAllSizes();
    }

    @Override
    public SizeDto getSizeById(Long id) {
        return sizePersistencePort.getSizeById(id);
    }

    @Override
    public List<SizeDto> getAllSizesByProductId(Long id) {
        return sizePersistencePort.getAllSizesByProductId(id);
    }
}
