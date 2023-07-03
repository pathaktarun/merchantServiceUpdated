package com.example.merchantplatform.merchantplatform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.merchantplatform.merchantplatform.payloads.ProductDetailsRequest;
import com.example.merchantplatform.merchantplatform.payloads.ProductDetailsResponse;
import com.example.merchantplatform.merchantplatform.service.MerchantService;


@RestController
@RequestMapping("/")
public class merchantProduct {

    @Autowired
    MerchantService merchantService;

    @RequestMapping(path = "/addProduct", method =RequestMethod.POST)
    public ResponseEntity<ProductDetailsResponse> addProduct(@RequestBody ProductDetailsRequest productDetailsRequest )
    {
        ProductDetailsResponse productDetailsResponse=merchantService.addProduct(productDetailsRequest);
        return new ResponseEntity<ProductDetailsResponse>(productDetailsResponse,HttpStatus.CREATED);

    }
    
}
