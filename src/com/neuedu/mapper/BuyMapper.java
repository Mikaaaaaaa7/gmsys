package com.neuedu.mapper;

import com.neuedu.model.Buy;
import java.util.List;

public interface BuyMapper {
    int deleteByPrimaryKey(Integer buyid);

    int insert(Buy record);

    Buy selectByPrimaryKey(Integer buyid);

    List<Buy> selectAll();
    List<Buy> selectByBuyid(Integer buyid);

    int updateByPrimaryKey(Buy record);
    
}