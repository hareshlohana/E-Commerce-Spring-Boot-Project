package com.Eshop.eshop.Dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryDTO {

    private  Long id;
    private String categorName;
    private Boolean isActive;
}
