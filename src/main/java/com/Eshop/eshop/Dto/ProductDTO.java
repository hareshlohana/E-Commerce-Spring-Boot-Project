package com.Eshop.eshop.Dto;

import com.Eshop.eshop.domain.Category;
import com.Eshop.eshop.domain.Image;
import com.Eshop.eshop.domain.Model;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductDTO {
    private Long id;
    @NotNull(message = "Model should not be blank")
    private Model model;
    @NotBlank(message = "Product Name should not be blank")
    private  String productName;
    @NotNull
    @Min(value = 1)
    private  Double cost;
    @NotNull
    @Min(value = 1)
    private   Double price;
    @NotNull
    @Min(value = 1)
    private  Double stock;
    @NotNull(message = "Category should not be blank")
    private Category category;
    private Boolean isActive;

}
