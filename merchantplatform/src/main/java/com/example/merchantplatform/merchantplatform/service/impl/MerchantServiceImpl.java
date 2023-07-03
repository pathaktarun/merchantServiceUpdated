package com.example.merchantplatform.merchantplatform.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.merchantplatform.merchantplatform.entities.MerchantProduct;
import com.example.merchantplatform.merchantplatform.payloads.ProductDetailsRequest;
import com.example.merchantplatform.merchantplatform.payloads.ProductDetailsResponse;
import com.example.merchantplatform.merchantplatform.repositories.ProductRepositories;
import com.example.merchantplatform.merchantplatform.service.MerchantService;



@Service
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

  
    

    
}
