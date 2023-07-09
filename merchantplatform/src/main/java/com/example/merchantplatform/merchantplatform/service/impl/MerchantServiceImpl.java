package com.example.merchantplatform.merchantplatform.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.merchantplatform.merchantplatform.entities.MerchantProduct;
import com.example.merchantplatform.merchantplatform.payloads.ProductDetailsRequest;
import com.example.merchantplatform.merchantplatform.payloads.ProductDetailsResponse;
import com.example.merchantplatform.merchantplatform.repositories.ProductRepositories;
import com.example.merchantplatform.merchantplatform.service.MerchantService;

import jakarta.transaction.Transactional;



@Service
@Transactional
public class MerchantServiceImpl implements MerchantService {

    @Autowired 
    public ProductRepositories productRepositories;

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public ProductDetailsResponse addProduct(ProductDetailsRequest productDetailsRequest)
    {
          
        MerchantProduct merchantProduct=this.modelMapper.map(productDetailsRequest,MerchantProduct.class);
        MerchantProduct addedMerchantProduct=this.productRepositories.save(merchantProduct);

        return this.modelMapper.map(addedMerchantProduct,ProductDetailsResponse.class);
         
    }

    @Override
    public List<ProductDetailsResponse> getMerchantProducts(String merchant_id)
    {
       
             List<MerchantProduct> merchantProducts= productRepositories.findByColumnValue(merchant_id);
            merchantProducts.forEach(System.out::println);

       List<ProductDetailsResponse> merchantProductsDtos=merchantProducts.stream().map(product->modelMapper.map(product,ProductDetailsResponse.class)).collect(Collectors.toList());
       return merchantProductsDtos;
   
    }

    @Override
    public void deleteAllProducts(String merchant_id) 
    {
    
           productRepositories.deleteByColumnValue(merchant_id);
           return;
     
    }

  
    

    
}
