package com.inditex.visibility.mappers;

import com.inditex.visibility.data.StockDto;
import com.inditex.visibility.entity.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {SizeMapper.class})
public interface StockMapper {
    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);

    @Mapping(target = "size", source = "size", ignore = true)
    StockDto stockToStockDto(Stock stock);

    @Mapping(target = "size", source = "size", ignore = true)
    Stock stockDtoToStock(StockDto stockDto);

    List<StockDto> stockListToStockDtoList(List<Stock> stockList);

    List<Stock> stockDtoListToStockList(List<StockDto> stockDtoList);
}
