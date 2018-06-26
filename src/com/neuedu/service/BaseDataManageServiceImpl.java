package com.neuedu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.mapper.CategoryMapper;
import com.neuedu.mapper.UserAccountMapper;
import com.neuedu.model.Category;
import com.neuedu.model.UserAccount;
import com.neuedu.service.BaseDataManageService;

@Service     //注解service的实现类
@Transactional  //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class BaseDataManageServiceImpl implements BaseDataManageService{

	@Resource  //注解注入
	private CategoryMapper mapper;
	
	
	@Override//重新接口中定义的方法
	public List<Category> selectAll(){
		return mapper.selectAll();
	}
}
