package com.example.springboot.controller;

import com.example.springboot.reponse.ProductReponse;
import com.example.springboot.request.ProductRequest;
import com.example.springboot.request.ProductRequestUpdate;
import com.example.springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Product/")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping(value = "getAllProd/{page}")
    public ResponseEntity<List<ProductReponse>>getAllProd(@PathVariable int page){
        Pageable pageRequest = PageRequest.of(page - 1, 5);
        return new ResponseEntity<>(productService.getListProd(pageRequest), HttpStatus.OK);
    }

    @PostMapping(value = "insertProd")
    public ResponseEntity<String> insertProduct(@RequestBody ProductRequest request){
        return new ResponseEntity<>(productService.addProd(request),HttpStatus.CREATED);
    }

    @DeleteMapping("deleteProd/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        return new ResponseEntity<>(productService.deleteProd(id),HttpStatus.OK);
    }

    @PutMapping(value = "updateProd/{id}")
    public ResponseEntity<String> updateProduct(@Valid @RequestBody ProductRequestUpdate requestUpdate, @PathVariable Long id){
        return new ResponseEntity<>(productService.updateProd(id,requestUpdate),HttpStatus.OK);
    }
}
