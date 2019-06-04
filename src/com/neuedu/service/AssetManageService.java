package com.neuedu.service;

import java.util.List;

import com.neuedu.model.Balance;
import com.neuedu.model.Buy;
import com.neuedu.model.Department;
import com.neuedu.model.Product;
import com.neuedu.model.Provider;
import com.neuedu.model.Repair;
import com.neuedu.model.Scrap;
import com.neuedu.model.Translate;

public interface AssetManageService {
	/**
	 * 获取采购管理列表
	 * 
	 * @return
	 */
	public List<Buy> selectAll();

	/**
	 * 根据采购单号查询订单
	 * 
	 * @param id
	 * @return
	 */
	public Buy findById(Integer id);

	/**
	 * 根据采购单号删除订单
	 * 
	 * @param buyid
	 */
	public void deleteById(Integer buyid);

	/**
	 * 获取产品列表
	 * 
	 * @return
	 */
	public List<Product> selectAllProductList();

	/**
	 * 获取供应商列表
	 * 
	 * @return
	 */
	public List<Department> selectAllDepartmentList();

	/**
	 * 根据供应商id获取产品
	 * 
	 * @param provid
	 * @return
	 */
	public Product selectByProvid(Integer provid);

	/**
	 * 添加采购记录
	 * 
	 * @param buy
	 */
	public void addBuy(Buy buy);

	/**
	 * 更新采购记录
	 * 
	 * @param buy
	 */
	public void updateBuy(Buy buy);

	/**
	 * 获取调度列表
	 * 
	 * @return
	 */
	public List<Translate> selectAllTranslateList();

	/**
	 * 根据id查询调度记录
	 * 
	 * @param tid
	 * @return
	 */
	public Translate findById2(Integer tid);

	/**
	 * 根据id删除调度记录
	 * 
	 * @param tid
	 */
	public void deleteById2(Integer tid);

	/**
	 * 更新调配记录
	 * 
	 * @param translate
	 */
	public void updateTranslate(Translate translate);

	/**
	 * 添加调配记录
	 * 
	 * @param translate
	 */
	public void addTranslate(Translate translate);

	/**
	 * 根据id查询资产记录
	 * 
	 * @param BID
	 * @return
	 */
	public Balance findBalanceById(Integer bid);

	/**
	 * 获取报修列表
	 * 
	 * @return
	 */
	public List<Repair> selectAllRepairList();

	/**
	 * 根据id查询报修记录
	 * 
	 * @param tid
	 * @return
	 */
	public Repair findById3(Integer rid);

	/**
	 * 根据id删除报修记录
	 * 
	 * @param tid
	 */
	public void deleteById3(Integer rid);

	/**
	 * 添加报修记录
	 * 
	 * @param repair
	 */
	public void addRepair(Repair repair);

	/**
	 * 更新报修记录
	 * 
	 * @param repair
	 */
	public void updateRepair(Repair repair);

	/**
	 * 获取报废列表
	 * 
	 * @return
	 */
	public List<Scrap> selectAllScrapList();

	/**
	 * 根据id查询报废记录
	 * 
	 * @param tid
	 * @return
	 */
	public Scrap findById4(Integer sid);

	/**
	 * 根据id删除报废记录
	 * 
	 * @param tid
	 */
	public void deleteById4(Integer sid);

	/**
	 * 添加报废记录
	 * 
	 * @param scrap
	 */
	public void addScrap(Scrap scrap);

	/**
	 * 更新报废记录
	 * 
	 * @param scrap
	 */
	public void updateScrap(Scrap scrap);

	/**
	 * 获取资产列表
	 * 
	 * @return
	 */
	public List<Balance> getBalanceList();

	/**
	 * 获取供应商列表
	 * 
	 * @return
	 */
	public List<Provider> selectAllProviderList();
}
