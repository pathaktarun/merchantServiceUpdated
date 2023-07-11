package com.example.merchantplatform.merchantplatform.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="products")
@Entity
public class MerchantProduct {

    
    @Id
    private int id;
    private String productName;
    private String category;
    private String unit;
    private String quantity;
    private String price;
    private String merchant_id;
    
}