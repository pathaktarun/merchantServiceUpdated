package com.example.merchantplatform.merchantplatform.service;

import com.example.merchantplatform.merchantplatform.payloads.ProductDetailsRequest;
import com.example.merchantplatform.merchantplatform.payloads.ProductDetailsResponse;

public interface MerchantService {

    public ProductDetailsResponse addProduct(ProductDetailsRequest productDetailsRequest);
   
    
    
}
