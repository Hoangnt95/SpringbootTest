package com.example.springboot.repository;

import com.example.springboot.model.SubCategory;
import com.example.springboot.reponse.SubCategoryReponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {
    @Query("SELECT new com.example.springboot.reponse.SubCategoryReponse(sub.id,sub.subCateCode,c.cateName) " +
            " FROM SubCategory sub JOIN Category c on sub.cateId = c.id")
    List<SubCategoryReponse> getAllSub(Pageable pageable);
}
