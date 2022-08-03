package com.example.springboot.model;

import com.example.springboot.productBrandKey.ProductBrandKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_brand")
@IdClass(ProductBrandKey.class)
public class ProductBrand {
    @Id
    @Column(name = "product_id")
    private Long productId;

    @Id
    @Column(name = "brand_id")
    private Long brandId;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product products;

    @ManyToOne
    @MapsId("brandId")
    @JoinColumn(name = "brand_id",referencedColumnName = "id")
    private Brand brands;
}
