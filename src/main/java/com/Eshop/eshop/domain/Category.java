package com.Eshop.eshop.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotBlank(message = "Category Name should Not be blank")
    private String categorName;
    private Boolean isActive;
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product>  productList;


}
