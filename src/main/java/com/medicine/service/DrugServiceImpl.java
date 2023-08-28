package com.medicine.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medicine.common.Constant;
import com.medicine.common.Result;
import com.medicine.entity.DrugDTO;
import com.medicine.entity.DrugQuery;
import com.medicine.mapper.DrugMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DrugServiceImpl {
    @Autowired
    private DrugMapper drugMapper;

    public Result selectDrug(DrugQuery query) {
        PageInfo<DrugDTO> pageInfo = PageHelper.startPage(query.getPageNum(), query.getPageSize()).doSelectPageInfo(() -> drugMapper.selectDrug(query));
        List<DrugDTO> list = pageInfo.getList();
        list.forEach(drugDTO -> drugDTO.setImg(Constant.ip+"/"+drugDTO.getImg()));
        return new Result(pageInfo);
    }

    public Result updateDrug(DrugDTO drugDTO) {
        drugMapper.updateDrug(drugDTO);
        return new Result();
    }

    public Result insertDrug(DrugDTO drugDTO) {
        drugDTO.setCreateTime(new Date());
        drugMapper.insertDrug(drugDTO);
        return new Result();
    }

}
