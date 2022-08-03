package com.example.springboot.reponse;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryReponse {
    @Id
    private Long id;

    private String subCode;

    private String cateName;
}
