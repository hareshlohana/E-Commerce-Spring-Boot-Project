package com.Eshop.eshop.domain;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long Id;
    @OneToOne
    @JoinColumn(name = "cartId",referencedColumnName ="id")
    private   Cart cart;
    private LocalDate localDate;
    private Double totalAmount;

}
