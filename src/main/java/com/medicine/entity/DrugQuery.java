package com.medicine.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DrugQuery {
    private String name;

    private Integer classification;

    private Integer pageNum;

    private Integer pageSize;

}
