package com.bingo.mallstart.service.impl;

import com.bingo.mallstart.mapper.PmsBrandMapper;
import com.bingo.mallstart.model.PmsBrand;
import com.bingo.mallstart.model.PmsBrandExample;
import com.bingo.mallstart.service.PmsBrandService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @Autowired
    private PmsBrandMapper brandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand pmsBrand) {
        return brandMapper.insertSelective(pmsBrand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand pmsBrand) {
        pmsBrand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(pmsBrand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        brandMapper.selectByExample(new PmsBrandExample());
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
