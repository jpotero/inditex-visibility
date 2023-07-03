package com.inditex.visibility.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SizeDto {
    private Long id;
    private ProductDto product;
    private boolean backSoon;
    private boolean special;
    private StockDto stock;
}
