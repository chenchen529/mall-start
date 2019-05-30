package com.bingo.mallstart.service;

import com.bingo.mallstart.model.PmsBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand pmsBrand);

    int updateBrand(Long id, PmsBrand pmsBrand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(Integer pageNum, Integer pageSize);

    PmsBrand getBrand(Long id);
}
