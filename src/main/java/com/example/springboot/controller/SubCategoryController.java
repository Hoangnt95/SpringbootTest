package com.example.springboot.controller;

import com.example.springboot.reponse.SubCategoryReponse;
import com.example.springboot.request.SubCategoryRequest;
import com.example.springboot.service.ISubCategoryService;
import com.example.springboot.service.impl.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Subcategory/")
public class SubCategoryController {

    @Autowired
    private ISubCategoryService subCategoryService;

    @GetMapping(value = "getAllSub/{page}")
    public ResponseEntity<List<SubCategoryReponse>> getAll(@PathVariable int page){
        Pageable pageRequest = PageRequest.of(page - 1, 5);
        return new ResponseEntity<>(subCategoryService.getList(pageRequest), HttpStatus.OK);
    }

    @PostMapping(value = "addSub")
    public ResponseEntity <?> insertSubCategory(@Valid @RequestBody SubCategoryRequest request){
        String mess = subCategoryService.addSubCategory(request);
        return new ResponseEntity<>(mess , HttpStatus.CREATED);
    }

    @PutMapping(value = "updateSub/{id}")
    public ResponseEntity<?> updateSubCategory(@Valid @RequestBody SubCategoryRequest request,@PathVariable Long id){
        String mess = subCategoryService.updateSubCategory(id,request);
        return new ResponseEntity<>(mess,HttpStatus.OK);
    }
}
