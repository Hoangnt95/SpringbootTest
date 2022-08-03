package com.example.springboot.service.impl;

import com.example.springboot.model.Category;
import com.example.springboot.model.SubCategory;
import com.example.springboot.reponse.SubCategoryReponse;
import com.example.springboot.repository.CategoryRepository;
import com.example.springboot.repository.SubCategoryRepository;
import com.example.springboot.request.SubCategoryRequest;
import com.example.springboot.service.ISubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryService implements ISubCategoryService {
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<SubCategoryReponse> getList(Pageable pageable) {
        List<SubCategoryReponse> reponseList = subCategoryRepository.getAllSub(pageable);
        return reponseList;
    }

    @Override
    public String addSubCategory(SubCategoryRequest subCategoryRequest) {
        Optional<Category> checkCategory = categoryRepository.findById(subCategoryRequest.getCateId());
        if (!checkCategory.isPresent()){
            return "Category không tồn tại trong list";
        }
        SubCategory subCategory = new SubCategory();
        subCategory.setSubCateCode(subCategoryRequest.getSubCode());
        subCategory.setSubCateName(subCategoryRequest.getSubName());
        subCategory.setCateId(subCategoryRequest.getCateId());

        subCategoryRepository.save(subCategory);
        return "Thêm thành công";
    }

    @Override
    public String updateSubCategory(Long id, SubCategoryRequest request) {
        Optional<SubCategory> checkSubCate = subCategoryRepository.findById(id);
        if (!checkSubCate.isPresent()){
            return "SubCategory không tồn tại";
        }
        checkSubCate.get().setSubCateCode(request.getSubCode());
        checkSubCate.get().setSubCateName(request.getSubName());
        Optional<Category> checkCategory = categoryRepository.findById(request.getCateId());
        if (!checkCategory.isPresent()){
            return "Category không tồn tại trong list";
        }
        checkSubCate.get().setCateId(request.getCateId());

        subCategoryRepository.save(checkSubCate.get());
        return "Update thành công";
    }
}
