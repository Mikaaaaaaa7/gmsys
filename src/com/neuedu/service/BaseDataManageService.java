package com.neuedu.service;

import java.util.List;

import com.neuedu.model.Category;
import com.neuedu.model.Department;

public interface BaseDataManageService {
	public List<Category> selectAll();
	public List<Category> selectByCnamemohu(String cname);
	public Category selectByCid(Integer cid);
	public Category findByCidchakan(Integer cid);
	public void updatezcfl(Category record);
	public void deletezcfl(Integer cid);
	public void addzcfl(Category record);
	
	public List<Department> selectAllDepartment();
	public Department selectByDid(Integer departid);
	public Department findByDidchakan(Integer departid);
	//public List<Department> selectByDidjuti(Integer departid);
	public void updatebm(Department record);
	public void deletebm(Integer departid);
	public void addbm(Department record);
	
}
