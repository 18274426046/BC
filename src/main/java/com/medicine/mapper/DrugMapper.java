package com.medicine.mapper;

import com.medicine.entity.DrugDTO;
import com.medicine.entity.DrugQuery;

import java.util.List;

/**
 * @author 1100238
 */
public interface DrugMapper {
    void insertDrug(DrugDTO drugDTO);

    List<DrugDTO> selectDrug(DrugQuery query);

    void updateDrug(DrugDTO drugDTO);
}
