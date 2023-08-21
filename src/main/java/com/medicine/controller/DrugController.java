package com.medicine.controller;

import com.medicine.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drug")
public class DrugController {

    @PostMapping("/selectDrug")
    public Result selectDrug() {
        if (1 == 1) {
         throw new RuntimeException("123");
        }
        return new Result();
    }
}
