package com.example.merchantplatform.merchantplatform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.merchantplatform.merchantplatform.entities.MerchantProduct;

public interface ProductRepositories extends JpaRepository<MerchantProduct,Integer>{

}
