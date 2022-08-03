package com.example.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subcate_id",referencedColumnName = "id")
    private SubCategory subCategory;

    @Column(name = "produce_name")
    private String productName;

    @Column(name = "color")
    private String color;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "sell_price")
    private double sellPrice;

    @Column(name = "origin_price")
    private double originPrice;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "status_id",referencedColumnName = "id")
    private Status status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_brand",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "brand_id")
    )
    private List<Brand> brands;

}
