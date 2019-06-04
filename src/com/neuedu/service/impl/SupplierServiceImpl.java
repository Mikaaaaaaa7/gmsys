package com.neuedu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.mapper.ProductMapper;
import com.neuedu.mapper.ProviderMapper;
import com.neuedu.model.Product;
import com.neuedu.model.Provider;
import com.neuedu.service.SupplierService;

@Service // 注解service的实现类
@Transactional // 此处不再进行创建SqlSession和提交事务 都已经由Spring去管理了
public class SupplierServiceImpl implements SupplierService {

	@Resource
	private ProviderMapper providerMapper;
	@Resource
	private ProductMapper productMapper;

	/**
	 * 获取供应商列表
	 */
	@Override
	public List<Provider> selectAll() {
		// TODO Auto-generated method stub
		return providerMapper.selectAll();
	}

	@Override
	public Provider findById(Integer provid) {
		// TODO Auto-generated method stub
		return providerMapper.selectByPrimaryKey(provid);
	}

	@Override
	public void deleteById(Integer provid) {
		// TODO Auto-generated method stub
		providerMapper.deleteByPrimaryKey(provid);
	}

	@Override
	public void AddProvider(Provider provider) {
		// TODO Auto-generated method stub
		providerMapper.insert(provider);
	}

	@Override
	public void updateProvider(Provider provider) {
		// TODO Auto-generated method stub
		providerMapper.updateByPrimaryKey(provider);
	}

	@Override
	public List<Product> selectAll2() {
		// TODO Auto-generated method stub
		return productMapper.selectAll();
	}

	@Override
	public Product findById2(Integer prodid) {
		// TODO Auto-generated method stub
		return productMapper.selectByPrimaryKey(prodid);
	}

	@Override
	public void deleteById2(Integer prodid) {
		// TODO Auto-generated method stub
		productMapper.deleteByPrimaryKey(prodid);
	}
}
