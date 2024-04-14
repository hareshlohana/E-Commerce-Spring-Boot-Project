package com.Eshop.eshop.Dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelDTO {

    private Long id;
    private String modelName;
    private Boolean isActive;

}
