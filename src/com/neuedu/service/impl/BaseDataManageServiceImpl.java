package com.neuedu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.mapper.AreaMapper;
import com.neuedu.mapper.BalanceMapper;
import com.neuedu.mapper.CategoryMapper;
import com.neuedu.mapper.DepartmentMapper;
import com.neuedu.mapper.UserAccountMapper;
import com.neuedu.model.Area;
import com.neuedu.model.Balance;
import com.neuedu.model.Category;
import com.neuedu.model.Department;
import com.neuedu.model.UserAccount;
import com.neuedu.service.BaseDataManageService;

@Service     //ע��service��ʵ����
@Transactional  //�˴����ٽ��д���SqlSession���ύ���񣬶��ѽ���springȥ�����ˡ�
public class BaseDataManageServiceImpl implements BaseDataManageService{

	@Resource  //ע��ע��
	private CategoryMapper mapper;
	
	@Resource
	private DepartmentMapper DepartmentMapper;
	
	@Resource
	private AreaMapper AreaMapper;
	
	@Resource
	private BalanceMapper BalanceMapper;
	
	@Override//���½ӿ��ж���ķ���
	public List<Category> selectAll(){
		return mapper.selectAll();
	}
	
	@Override
	public List<Category> selectByCnamemohu(String cname) {
		// TODO Auto-generated method stub
		List<Category> categories = mapper.selectByCnamemohu(cname);
		return categories;
	}
	@Override
	public Category selectByCid(Integer cid) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(cid);
	}
	@Override
	public Category findByCidchakan(Integer cid) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(cid);
	}
	public void updatezcfl(Category record) {
		// TODO Auto-generated method stub
		mapper.updateByPrimaryKey(record);
	}
	@Override
	public void deletezcfl(Integer cid) {
		// TODO Auto-generated method stub
		mapper.deleteByPrimaryKey(cid);
	}
	@Override
	public void addzcfl(Category record) {
		// TODO Auto-generated method stub
		mapper.insert(record);
	}
	
	@Override
	public List<Department> selectAllDepartment() {
		// TODO Auto-generated method stub
		return DepartmentMapper.selectAll();
	}
	@Override
	public Department selectByDid(Integer departid) {
		// TODO Auto-generated method stub
		return DepartmentMapper.selectByPrimaryKey(departid);
	}
	@Override
	public Department findByDidchakan(Integer departid) {
		// TODO Auto-generated method stub
		return DepartmentMapper.selectByPrimaryKey(departid);
	}
	@Override
	public void updatebm(Department record) {
		// TODO Auto-generated method stub
		DepartmentMapper.updateByPrimaryKey(record);
	}
	@Override
	public void deletebm(Integer departid) {
		// TODO Auto-generated method stub
		DepartmentMapper.deleteByPrimaryKey(departid);
	}
	@Override
	public void addbm(Department record) {
		// TODO Auto-generated method stub
		DepartmentMapper.insert(record);
	}
	
	@Override
	public List<Area> selectAllArea() {
		// TODO Auto-generated method stub
		return AreaMapper.selectAll();
	}
	
	@Override
	public Area selectByAreaid(Integer areaid) {
		// TODO Auto-generated method stub
		return AreaMapper.selectByPrimaryKey(areaid);
	}
	@Override
	public void updatearea(Area record) {
		// TODO Auto-generated method stub
		AreaMapper.updateByPrimaryKey(record);
	}
	@Override
	public Area findByAreaidchakan(Integer areaid) {
		// TODO Auto-generated method stub
		return AreaMapper.selectByPrimaryKey(areaid);
	}
	@Override
	public void deletearea(Integer areaid) {
		// TODO Auto-generated method stub
		AreaMapper.deleteByPrimaryKey(areaid);
	}
	@Override
	public void addarea(Area record) {
		// TODO Auto-generated method stub
		AreaMapper.insert(record);
	}
	@Override
	public void addzc(Balance record) {
		// TODO Auto-generated method stub
		BalanceMapper.insert(record);
	}
	@Override
	public Long findNewCont() {
		// TODO Auto-generated method stub
		return AreaMapper.findNewCont();
	}
	@Override
	public List<Area> findNewsPage(int i, int j) {
		// TODO Auto-generated method stub
		return AreaMapper.findNewsPage(i, j);
	}
	@Override
	public Long findNewContCategory() {
		// TODO Auto-generated method stub
		return mapper.findNewCont();
	}
	@Override
	public List<Category> findNewsPageCategory(int i, int j) {
		// TODO Auto-generated method stub
		return mapper.findNewsPage(i, j);
	}
	@Override
	public Long findNewContDepartment() {
		// TODO Auto-generated method stub
		return DepartmentMapper.findNewCont();
	}
	@Override
	public List<Department> findNewsPageDepartment(int i, int j) {
		// TODO Auto-generated method stub
		return DepartmentMapper.findNewsPage(i, j);
	}
}
