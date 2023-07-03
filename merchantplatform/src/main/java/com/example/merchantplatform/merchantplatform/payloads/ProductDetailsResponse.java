package com.example.merchantplatform.merchantplatform.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ProductDetailsResponse{

    private String id;
    private String productName;
    private String category;
    private String unit;
    private String quantity;
    private String price;
    private String merchant_id;

}
