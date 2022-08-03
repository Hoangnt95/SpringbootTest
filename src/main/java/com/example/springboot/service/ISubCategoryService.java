package com.example.springboot.service;

import com.example.springboot.model.SubCategory;
import com.example.springboot.reponse.SubCategoryReponse;
import com.example.springboot.request.SubCategoryRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISubCategoryService {
    List<SubCategoryReponse> getList(Pageable pageable);
    String addSubCategory(SubCategoryRequest subCategoryRequest);
    String updateSubCategory(Long id , SubCategoryRequest request);
}
