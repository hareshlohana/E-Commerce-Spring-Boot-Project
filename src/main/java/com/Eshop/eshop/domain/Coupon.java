package com.Eshop.eshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Data
@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;
    private   String couponCode;
    private  Double discount;
    private Boolean isPercentage;
    @JsonIgnore
    @OneToMany(mappedBy = "coupon" )
    List<Cart> cartList;
    private Boolean isActive;
}
