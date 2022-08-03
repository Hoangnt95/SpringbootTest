package com.example.springboot.service.impl;

import com.example.springboot.model.*;
import com.example.springboot.reponse.ProductReponse;
import com.example.springboot.repository.*;
import com.example.springboot.request.ProductRequest;
import com.example.springboot.request.ProductRequestUpdate;
import com.example.springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private ProductBrandRepository productBrandRepository;
    @Override
    public List<ProductReponse> getListProd(Pageable pageable) {
        List<ProductReponse> reponseList = productRepository.getListProd(pageable);
        return reponseList;
    }

    @Override
    public String addProd(ProductRequest request) {
        Optional<Brand> checkBrand = brandRepository.findById(request.getBrandId());
        Optional<SubCategory> checkSubCate = subCategoryRepository.findById(request.getSubCateId());
        if (!checkBrand.isPresent()){
            return "BrandId Không tồn tại trong list Brand";
        }
        if (!checkSubCate.isPresent()){
            return "SubCateId không tồn tại trong list SubCategory";
        }
        if (request.getSellPrice() < request.getOriginPrice()){
            return "SellPrice phải lớn hơn OriginPrice";
        }
        Optional<Status> checkSttName = checkStatusName(request.getStatusName());
        if (checkSttName == null){
            return "Status không tồn tại";
        }
        Product product = new Product();
        product.setSubCategory(checkSubCate.get());
        product.setProductName(request.getProductName());
        product.setColor(request.getColor());
        product.setQuantity(request.getQuantity());
        product.setSellPrice(request.getSellPrice());
        product.setOriginPrice(request.getOriginPrice());
        product.setDescription(request.getDescription());
        product.setStatus(checkSttName.get());

        productRepository.save(product);

        ProductBrand productBrand = new ProductBrand();
        productBrand.setProductId(product.getId());
        productBrand.setBrandId(checkBrand.get().getId());

        productBrandRepository.save(productBrand);


        return "Thêm Product thành công";
    }

    @Override
    public String deleteProd(Long id) {
        Optional<Product> checkProd = productRepository.findById(id);
            if (!checkProd.isPresent()){
                return "Product không tồn tại";
            }
        productRepository.deleteById(id);
        return "Đã xóa thành công Product";
    }

    @Override
    public String updateProd(Long id, ProductRequestUpdate requestUpdate) {
        Optional<Product> checkProduct = productRepository.findById(id);
        Optional<Brand> checkBrand = checkBrandName(requestUpdate.getBrandName());
        Optional<SubCategory> checkSub = checkSubCategoryName(requestUpdate.getSubCateName());
        Optional<Status> checkStatus = checkStatusName(requestUpdate.getStatusName());
        if (!checkProduct.isPresent()){
            return "Product không tồn tại";
        }
        if (checkBrand == null){
            return "Brand name không tồn tại";
        }

        if (checkSub == null){
            return "SubCategory name không tồn tại";
        }
        if (checkStatus == null){
            return "Status name không tồn tại";
        }
        if (requestUpdate.getSellPrice() < requestUpdate.getOriginPrice()){
            return "SellPrice phải lớn hơn OriginPrice";
        }

        checkProduct.get().setSubCategory(checkSub.get());
        checkProduct.get().setProductName(requestUpdate.getProductName());
        checkProduct.get().setColor(requestUpdate.getColor());
        checkProduct.get().setQuantity(requestUpdate.getQuantity());
        checkProduct.get().setSellPrice(requestUpdate.getSellPrice());
        checkProduct.get().setOriginPrice(requestUpdate.getOriginPrice());
        checkProduct.get().setDescription(requestUpdate.getDescription());
        checkProduct.get().setStatus(checkStatus.get());
        productRepository.save(checkProduct.get());
        productBrandRepository.updateProductBrand(checkBrand.get(), checkBrand.get().getId(), id);
        return "Update thành công";
    }

    Optional<Status> checkStatusName(String name){
        for(Status status : statusRepository.findAll()){
            if (name.equals(status.getStatusName())){
                return Optional.of(status);
            }
        }
        return null;
    }
    Optional<SubCategory> checkSubCategoryName(String name){
        for(SubCategory subCategory : subCategoryRepository.findAll()){
            if (name.equals(subCategory.getSubCateName())){
                return Optional.of(subCategory);
            }
        }
        return null;
    }
    Optional<Brand> checkBrandName(String name){
        for(Brand brand : brandRepository.findAll()){
            if (name.equals(brand.getBrandName())){
                return Optional.of(brand);
            }
        }
        return null;
    }
}
