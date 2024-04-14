package com.Eshop.eshop.Dto;

import com.Eshop.eshop.domain.Cart;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TransactionDTO {
    private Long Id;
    private Cart cart;
    private   LocalDate localDate;
    private Double totalAmount;

}
