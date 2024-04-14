package com.Eshop.eshop.Dto;

import com.Eshop.eshop.domain.Coupon;
import com.Eshop.eshop.domain.Customer;
import lombok.*;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CartDTO {
    private  Long id;
    private LocalDate date;
    private String deviceAddress;
    private Customer customer;
    private Coupon coupon;

}
