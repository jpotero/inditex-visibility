package com.inditex.visibility.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockDto {
    private Long id;
    private SizeDto size;
    private int quantity;
}
