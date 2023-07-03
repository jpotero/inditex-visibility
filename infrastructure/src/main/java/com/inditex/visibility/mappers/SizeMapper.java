package com.inditex.visibility.mappers;

import com.inditex.visibility.data.SizeDto;
import com.inditex.visibility.entity.Size;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {ProductMapper.class, StockMapper.class})
public interface SizeMapper {
    SizeMapper INSTANCE = Mappers.getMapper(SizeMapper.class);

    @Mapping(target = "product", source = "product", ignore = true)
    SizeDto sizeToSizeDto(Size size);

    @Mapping(target = "product", source = "product", ignore = true)
    Size sizeDtoToSize(SizeDto sizeDto);

    List<SizeDto> sizeListToSizeDtoList(List<Size> sizeList);

    List<Size> sizeDtoListToSizeList(List<SizeDto> sizeDtoList);
}
