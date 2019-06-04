package com.neuedu.service;

import java.util.List;

import com.neuedu.model.Product;
import com.neuedu.model.Provider;

public interface SupplierService {

	/**
	 * 获取供应商列表
	 * 
	 * @return
	 */
	public List<Provider> selectAll();

	/**
	 * 根据id获取供应商记录
	 * 
	 * @return
	 */
	public Provider findById(Integer provid);

	/**
	 * 删除供应商记录
	 * 
	 * @param provid
	 */
	public void deleteById(Integer provid);

	/**
	 * 添加供应商记录
	 * 
	 * @param provider
	 */
	public void AddProvider(Provider provider);

	/**
	 * 更新供应商信息
	 * 
	 * @param provider
	 */
	public void updateProvider(Provider provider);

	/**
	 * 获取产品列表
	 * 
	 * @return
	 */
	public List<Product> selectAll2();

	/**
	 * 根据id获取产品记录
	 * 
	 * @param provid
	 * @return
	 */
	public Product findById2(Integer prodid);

	/**
	 * 删除产品记录
	 * 
	 * @param product
	 */
	public void deleteById2(Integer prodid);
}
