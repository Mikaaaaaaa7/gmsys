package com.neuedu.mapper;

import com.neuedu.model.Repair;
import java.util.List;

public interface RepairMapper {
    int deleteByPrimaryKey(Integer repairid);

    int insert(Repair record);

    Repair selectByPrimaryKey(Integer repairid);

    List<Repair> selectAll();

    int updateByPrimaryKey(Repair record);
}