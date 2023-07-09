package com.example.merchantplatform.merchantplatform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.merchantplatform.merchantplatform.entities.MerchantProduct;
import java.util.*;

public interface ProductRepositories extends JpaRepository<MerchantProduct,Integer>{

    @Query("SELECT mp FROM MerchantProduct mp WHERE mp.merchant_id =:merchant_id")
    List<MerchantProduct> findByColumnValue(@Param("merchant_id") String column_value);

    @Modifying
    @Query("Delete from MerchantProduct where merchant_id=:merchant_id")
    void deleteByColumnValue(@Param("merchant_id") String merchant_id);

    @Modifying
    @Query("Delete from MerchantProduct where id=:product_id")
    void deleteByProductId(@Param("product_id") String product_id);

}
