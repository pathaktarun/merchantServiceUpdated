package com.example.merchantplatform.merchantplatform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.merchantplatform.merchantplatform.entities.MerchantProduct;
import com.example.merchantplatform.merchantplatform.payloads.ProductDetailsRequest;



import java.util.*;

public interface ProductRepositories extends JpaRepository<MerchantProduct,Integer>{

//    @PersistenceContext
//     private EntityManager entityManager;

 
    @Query("SELECT mp FROM MerchantProduct mp WHERE mp.id=:product_id")
     MerchantProduct getSingleProductByProductId(@Param("product_id") String product_id);


    @Query("SELECT mp FROM MerchantProduct mp WHERE mp.merchant_id =:merchant_id")
    List<MerchantProduct> findByColumnValue(@Param("merchant_id") String column_value);

    @Modifying
    @Query("Delete from MerchantProduct where merchant_id=:merchant_id")
    void deleteByColumnValue(@Param("merchant_id") String merchant_id);

    @Modifying
    @Query("Delete from MerchantProduct where id=:product_id")
    void deleteByProductId(@Param("product_id") String product_id);

    @Modifying
    @Query("UPDATE MerchantProduct mp SET " +
    "mp.productName = CASE WHEN :#{#productDetailsRequestDto.productName} IS NULL THEN mp.productName ELSE :#{#productDetailsRequestDto.productName} END, " +
    "mp.quantity = CASE WHEN :#{#productDetailsRequestDto.quantity} IS NULL THEN mp.quantity ELSE :#{#productDetailsRequestDto.quantity} END, " +
    "mp.category = CASE WHEN :#{#productDetailsRequestDto.category} IS NULL THEN mp.category ELSE :#{#productDetailsRequestDto.category} END, " +
    "mp.unit = CASE WHEN :#{#productDetailsRequestDto.unit} IS NULL THEN mp.unit ELSE :#{#productDetailsRequestDto.unit} END, " +
    "mp.price = CASE WHEN :#{#productDetailsRequestDto.price} IS NULL THEN mp.price ELSE :#{#productDetailsRequestDto.price} END " +
    "WHERE mp.id = :#{#productDetailsRequestDto.id}")
    void updateSingleProductUsingProductId(ProductDetailsRequest productDetailsRequestDto );


    // @Modifying
    // default
    // void updateSingleProductUsingProductId(ProductDetailsRequest productDetailsRequestDto )
    // {
    //     StringBuilder query=new StringBuilder("Update MerchantProduct set ");
    //     if(productDetailsRequestDto.getProductName()!=null)
    //     {
    //         query.append("productName=:productName, ");
    //     }
    //     if(productDetailsRequestDto.getQuantity()!=null)
    //     {
    //         query.append("quantity=:quantity, ");
    //     }
    //     if(productDetailsRequestDto.getCategory()!=null)
    //     {
    //         query.append("category=:category, ");
    //     }
    //     if(productDetailsRequestDto.getUnit()!=null)
    //     {
    //         query.append("unit=:unit, ");
    //     }
    //     if(productDetailsRequestDto.getPrice()!=null)
    //     {
    //         query.append("price=:price, ");
    //     }

    //     query.delete(query.length() - 2, query.length());

    //     query.append("WHERE id =:id");

    //     jakarta.persistence.Query jpaQuery=entityManager.createQuery(query.toString());

    //     if(productDetailsRequestDto.getProductName()!=null)
    //     {
    //         jpaQuery.setParameter("productName",productDetailsRequestDto.getProductName());
    //     }
    //      if(productDetailsRequestDto.getQuantity()!=null)
    //     {
    //         jpaQuery.setParameter("quantity",productDetailsRequestDto.getQuantity());
    //     }
    //      if(productDetailsRequestDto.getCategory()!=null)
    //     {
    //         jpaQuery.setParameter("category",productDetailsRequestDto.getCategory());
    //     }
    //      if(productDetailsRequestDto.getUnit()!=null)
    //     {
    //         jpaQuery.setParameter("unit",productDetailsRequestDto.getUnit());
    //     }
    //      if(productDetailsRequestDto.getPrice()!=null)
    //     {
    //         jpaQuery.setParameter("price",productDetailsRequestDto.getPrice());
    //     }

    //     jpaQuery.executeUpdate();


    // };



}
