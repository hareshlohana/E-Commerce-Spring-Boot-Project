package com.Eshop.eshop.domain;

import lombok.*;

import jakarta.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Data
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private  String email;
    private String phoneNumber;
    private Boolean isActive;
}
