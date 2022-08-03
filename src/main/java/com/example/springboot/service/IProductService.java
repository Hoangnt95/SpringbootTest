package com.example.springboot.service;

import com.example.springboot.model.Brand;
import com.example.springboot.model.Status;
import com.example.springboot.model.SubCategory;
import com.example.springboot.reponse.ProductReponse;
import com.example.springboot.request.ProductRequest;
import com.example.springboot.request.ProductRequestUpdate;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<ProductReponse> getListProd(Pageable pageable);
    String addProd(ProductRequest request);
    String deleteProd(Long id);
    String updateProd(Long id, ProductRequestUpdate requestUpdate);
}
