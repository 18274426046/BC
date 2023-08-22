package com.medicine.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DrugDTO {
    private Long id;

    private String name;

    private BigDecimal price;

    private Integer isShelf;

    private String img;

    private Integer classification;
}
