package com.Eshop.eshop.Dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
//@JsonIgnoreProperties(value = {"productList"})
public class CouponDTO {


    private  Long Id;
    private   String couponCode;
    private  Double discount;
    private Boolean isPercentage;
    private Boolean isActive;
}

