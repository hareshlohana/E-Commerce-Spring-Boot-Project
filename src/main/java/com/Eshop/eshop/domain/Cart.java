package com.Eshop.eshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @JsonIgnore
    @OneToMany(mappedBy = "cart")
    private  List<ProductCart> productCart;

    @JsonIgnore
    @OneToOne(mappedBy = "cart",cascade = CascadeType.ALL)
    private  Transaction transaction;

    private LocalDate date;
    private String deviceAddress;

    @ManyToOne
    @JoinColumn(name = "customerId",referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "couponId",referencedColumnName = "id")
    private   Coupon coupon;
}
