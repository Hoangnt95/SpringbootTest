package com.example.springboot.productBrandKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBrandKey implements Serializable {
    private Long productId;
    private Long brandId;
}
