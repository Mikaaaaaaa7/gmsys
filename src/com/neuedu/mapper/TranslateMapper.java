package com.neuedu.mapper;

import com.neuedu.model.Translate;
import java.util.List;

public interface TranslateMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Translate record);

    Translate selectByPrimaryKey(Integer tid);

    List<Translate> selectAll();
    List<Translate> selectOne(Integer tid);
    
    int updateByPrimaryKey(Translate record);
}