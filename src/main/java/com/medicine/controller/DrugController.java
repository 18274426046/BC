package com.medicine.controller;

import com.medicine.common.Result;
import com.medicine.entity.DrugDTO;
import com.medicine.entity.DrugQuery;
import com.medicine.service.DrugServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drug")
public class DrugController {
    @Autowired
    private DrugServiceImpl drugService;

    @PostMapping("/selectDrug")
    public Result selectDrug(DrugQuery query) {
        return drugService.selectDrug(query);
    }

    @PostMapping("/updateDrug")
    public Result updateDrug(DrugDTO drugDTO) {
        return drugService.updateDrug(drugDTO);
    }

    @PostMapping("/insertDrug")
    public Result insertDrug(DrugDTO drugDTO) {
        return drugService.insertDrug(drugDTO);
    }

}
