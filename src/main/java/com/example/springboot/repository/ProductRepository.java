package com.example.springboot.repository;

import com.example.springboot.model.Product;
import com.example.springboot.reponse.ProductReponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "SELECT new com.example.springboot.reponse.ProductReponse(p.id, sc.subCateName, p.productName,p.color," +
            " p.quantity, p.sellPrice, p.originPrice, st.statusName, b.brandName) FROM Product p JOIN ProductBrand  " +
            "pb ON p.id = pb.productId JOIN Brand  b ON b.id = pb.brandId JOIN SubCategory sc ON sc.id = p.subCategory.id" +
            " JOIN Status st ON st.id = p.status.id")
    List<ProductReponse>getListProd(Pageable pageable);
}
