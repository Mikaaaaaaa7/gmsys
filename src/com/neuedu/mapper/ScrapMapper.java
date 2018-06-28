package com.neuedu.mapper;

import com.neuedu.model.Scrap;
import java.util.List;

public interface ScrapMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Scrap record);

    Scrap selectByPrimaryKey(Integer sid);

    List<Scrap> selectAll();

    int updateByPrimaryKey(Scrap record);
}