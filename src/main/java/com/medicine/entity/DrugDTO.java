package com.medicine.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class DrugDTO {
    private Long id;

    private String name;

    private BigDecimal price;

    private Integer isShelf;

    private String img;

    private Integer classification;

    private Date createTime;
}
