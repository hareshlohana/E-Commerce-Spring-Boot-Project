package com.Eshop.eshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ManyToOne
   @JoinColumn(name="modelId",referencedColumnName = "id")
    private Model model;
    private  String productName;
    private  Double cost;
    private   Double price;

    private  Double stock;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<ProductCart> productCartList;
    @ManyToOne
    @JoinColumn(name = "categoryId",referencedColumnName = "id")
    Category category;
    private Boolean isActive;

}
