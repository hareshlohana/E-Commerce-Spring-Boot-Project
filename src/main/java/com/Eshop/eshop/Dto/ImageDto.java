package com.Eshop.eshop.Dto;

import com.Eshop.eshop.domain.Product;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ImageDto {
    private  Long id;
    private String imageName;
    private String type;
    private byte[] imageDate;
    Product product;
}
