package com.example.merchantplatform.merchantplatform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.merchantplatform.merchantplatform.entities.MerchantProduct;
import java.util.*;

public interface ProductRepositories extends JpaRepository<MerchantProduct,Integer>{

    @Query("SELECT mp FROM MerchantProduct mp WHERE mp.merchant_id =:merchant_id")
    List<MerchantProduct> findByColumnValue(@Param("merchant_id") String merchant_id);

}
