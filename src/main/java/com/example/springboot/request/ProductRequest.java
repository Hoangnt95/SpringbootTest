package com.example.springboot.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    @NotNull(message = "Không được bỏ trống")
    private Long subCateId;

    @NotNull(message = "Không được bỏ trống")
    private String productName;

    @NotNull(message = "Không được bỏ trống")
    private String color;

    @NotNull(message = "Không được bỏ trống")
    @Min(value = 1,message = "Quantity phải là số nguyên dương")
    private int quantity;

    @NotNull(message = "Không được bỏ trống")
    private double sellPrice;

    @NotNull(message = "Không được bỏ trống")
    private double originPrice;

    @NotNull(message = "Không được bỏ trống")
    private String description;

    @NotNull(message = "Không được bỏ trống")
    private String statusName;

    @NotNull(message = "Không được bỏ trống")
    private Long brandId;
}
