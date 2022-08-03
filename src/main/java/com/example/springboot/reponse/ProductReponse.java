package com.example.springboot.reponse;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductReponse {

    private Long productId;

    private String subCateName;

    private String productName;

    private String color;

    private int quantity;

    private double sellPrice;

    private double originPrice;

    private String statusName;

    private String brandName;
}
