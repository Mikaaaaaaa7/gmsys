package com.neuedu.mapper;

import com.neuedu.model.Translate;
import java.util.List;

public interface TranslateMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Translate record);

    Translate selectByPrimaryKey(Integer tid);

    List<Translate> selectAll();

    int updateByPrimaryKey(Translate record);
}