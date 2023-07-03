package com.inditex.visibility.adapters;

import com.inditex.visibility.data.SizeDto;
import com.inditex.visibility.mappers.SizeMapper;
import com.inditex.visibility.ports.spi.SizePersistencePort;
import com.inditex.visibility.repository.SizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SizeJpaAdapter implements SizePersistencePort {

    private SizeRepository sizeRepository;

    @Override
    public SizeDto addSize(SizeDto sizeDto) {
        var size = SizeMapper.INSTANCE.sizeDtoToSize(sizeDto);
        var sizeSaved = sizeRepository.save(size);
        return SizeMapper.INSTANCE.sizeToSizeDto(sizeSaved);
    }

    @Override
    public void deleteSizeById(Long id) {
        sizeRepository.deleteById(id);
    }

    @Override
    public SizeDto updateSize(SizeDto sizeDto) {
        return addSize(sizeDto);
    }

    @Override
    public List<SizeDto> getAllSizes() {
        var sizeList = sizeRepository.findAll();
        return SizeMapper.INSTANCE.sizeListToSizeDtoList(sizeList);
    }

    @Override
    public SizeDto getSizeById(Long id) {
        var size = sizeRepository.findById(id);
        return size.map(SizeMapper.INSTANCE::sizeToSizeDto).orElse(null);
    }

    @Override
    public List<SizeDto> getAllSizesByProductId(Long id) {
        var sizeList = sizeRepository.findAllByProductId(id);
        return SizeMapper.INSTANCE.sizeListToSizeDtoList(sizeList);
    }
}
