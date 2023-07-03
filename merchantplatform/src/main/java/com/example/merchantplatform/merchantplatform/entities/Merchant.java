package com.example.merchantplatform.merchantplatform.entities;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Merchant {

@Id
private int id;
private String phoneNumber;
private String name;
private String bussinessName;
private String merchant_product_id;
    
}