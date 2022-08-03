package com.example.springboot.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestUpdate {

    @NotNull(message = "Không được để trống")
    private String subCateName;

    @NotNull(message = "Không được để trống")
    private String productName;

    @NotNull(message = "Không được để trống")
    private String color;

    @NotNull
    @Min(value = 1,message = "Quantity phải là số nguyên dương")
    private int quantity;

    @NotNull(message = "Không được để trống")
    private double sellPrice;

    @NotNull(message = "Không được để trống")
    private double originPrice;

    @NotNull(message = "Không được để trống")
    private String description;

    @NotNull(message = "Không được để trống")
    private String statusName;

    @NotNull(message = "Không được để trống")
    private String brandName;
}
