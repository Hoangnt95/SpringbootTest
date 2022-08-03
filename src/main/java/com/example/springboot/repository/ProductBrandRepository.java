package com.example.springboot.repository;

import com.example.springboot.model.Brand;
import com.example.springboot.model.ProductBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ProductBrandRepository extends JpaRepository<ProductBrand,Long> {
    @Modifying
    @Transactional
    @Query("UPDATE ProductBrand sub SET sub.brands = :brands , sub.brandId = :brand_id WHERE sub.productId = :product_id")
    void updateProductBrand(@Param("brands") Brand brands, @Param("brand_id") Long brand_id, @Param("product_id") Long product_id);
}
