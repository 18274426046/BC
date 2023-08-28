package com.medicine.controller;

import com.medicine.common.Result;
import com.medicine.entity.DrugDTO;
import com.medicine.entity.DrugQuery;
import com.medicine.service.DrugServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/drug")
@Slf4j
public class DrugController {
    @Autowired
    private DrugServiceImpl drugService;

    @Value("${file.path}")
    private String savePath;

    @PostMapping("/selectDrug")
    public Result selectDrug(@RequestBody DrugQuery query) {
        return drugService.selectDrug(query);
    }

    @PostMapping("/updateDrug")
    public Result updateDrug(DrugDTO drugDTO) {
        return drugService.updateDrug(drugDTO);
    }

    @PostMapping("/insertDrug")
    public Result insertDrug(MultipartFile file, DrugDTO drugDTO) {
        String imgPath = savePath + File.separator + file.getOriginalFilename();
        File imgFile = new File(imgPath);
        try {
            file.transferTo(imgFile);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("添加异常", e);
            return new Result(409, "图片添加异常");
        }
        drugDTO.setImg(file.getOriginalFilename());
        if (Objects.isNull(drugDTO.getIsShelf())){
            drugDTO.setIsShelf(1);
        }
        return drugService.insertDrug(drugDTO);
    }

}
