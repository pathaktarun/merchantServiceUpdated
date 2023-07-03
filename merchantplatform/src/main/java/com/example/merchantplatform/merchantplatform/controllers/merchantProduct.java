package com.example.merchantplatform.merchantplatform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.merchantplatform.merchantplatform.payloads.ProductDetailsRequest;
import com.example.merchantplatform.merchantplatform.payloads.ProductDetailsResponse;
import com.example.merchantplatform.merchantplatform.service.MerchantService;

import java.util.*;


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

    @RequestMapping(path="/getProducts", method=RequestMethod.GET)
    public ResponseEntity<List<ProductDetailsResponse>> getProducts(@RequestParam("merchant_id") String merchant_id){
        List<ProductDetailsResponse> merchantProducts=merchantService.getMerchantProducts(merchant_id);
        return  ResponseEntity.ok(merchantProducts);

    }
    
}
