package com.neuedu.mapper;

import java.util.List;

import com.neuedu.model.Product;

public interface ProductMapper {
	int deleteByPrimaryKey(Integer prodid);

	int insert(Product record);

	Product selectByPrimaryKey(Integer prodid);

	Product selectByProvid(Integer provid);

	List<Product> selectAll();

	int updateByPrimaryKey(Product record);
}