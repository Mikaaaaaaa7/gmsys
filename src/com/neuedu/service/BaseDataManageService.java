package com.neuedu.service;

import java.util.List;

import com.neuedu.model.Category;

public interface BaseDataManageService {
	public List<Category> selectAll();
	public List<Category> selectByCnamemohu(String cname);
	public Category selectByCid(Integer cid);
	public Category findByCidchakan(Integer cid);
	public void updatezcfl(Category record);
	public void deletezcfl(Integer cid);
	public void addzcfl(Category record);
}
