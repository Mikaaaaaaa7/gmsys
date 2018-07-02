package com.neuedu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.mapper.BalanceMapper;
import com.neuedu.mapper.BuyMapper;
import com.neuedu.mapper.DepartmentMapper;
import com.neuedu.mapper.ProductMapper;
import com.neuedu.mapper.ProviderMapper;
import com.neuedu.mapper.RepairMapper;
import com.neuedu.mapper.ScrapMapper;
import com.neuedu.mapper.TranslateMapper;
import com.neuedu.model.Balance;
import com.neuedu.model.Buy;
import com.neuedu.model.Department;
import com.neuedu.model.Product;
import com.neuedu.model.Provider;
import com.neuedu.model.Repair;
import com.neuedu.model.Scrap;
import com.neuedu.model.Translate;
import com.neuedu.service.AssetManageService;

@Service // 注解service的实现类
@Transactional // 此处不再进行创建SqlSession和提交事务 都已经由Spring去管理了
public class AssetManageServiceImpl implements AssetManageService {

	@Resource // 注解注入
	private BuyMapper buyMapper;
	@Resource
	private ProductMapper productMapper;
	@Resource
	private DepartmentMapper departmentMapper;
	@Resource
	private TranslateMapper translateMapper;
	@Resource
	private RepairMapper repairManager;
	@Resource
	private ScrapMapper scrapMapper;
	@Resource
	private BalanceMapper balanceMapper;
	@Resource
	private ProviderMapper providerMapper;

	@Override
	public List<Buy> selectAll() {
		// TODO Auto-generated method stub
		return buyMapper.selectAll();
	}

	@Override
	public Buy findById(Integer id) {
		// TODO Auto-generated method stub
		return buyMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteById(Integer buyid) {
		// TODO Auto-generated method stub
		buyMapper.deleteByPrimaryKey(buyid);
	}

	public List<Product> selectAllProductList() {
		return productMapper.selectAll();
	}

	@Override
	public List<Department> selectAllDepartmentList() {
		// TODO Auto-generated method stub
		return departmentMapper.selectAll();
	}

	@Override
	public Product selectByProvid(Integer provid) {
		// TODO Auto-generated method stub
		return productMapper.selectByProvid(provid);
	}

	@Override
	public void addBuy(Buy buy) {
		// TODO Auto-generated method stub
		buyMapper.insert(buy);
	}

	@Override
	public void updateBuy(Buy buy) {
		// TODO Auto-generated method stub
		buyMapper.updateByPrimaryKey(buy);
	}

	@Override
	public List<Translate> selectAllTranslateList() {
		// TODO Auto-generated method stub
		return translateMapper.selectAll();
	}

	@Override
	public Translate findById2(Integer tid) {
		// TODO Auto-generated method stub
		return translateMapper.selectByPrimaryKey(tid);
	}

	@Override
	public void deleteById2(Integer tid) {
		// TODO Auto-generated method stub
		translateMapper.deleteByPrimaryKey(tid);
	}

	@Override
	public void updateTranslate(Translate translate) {
		// TODO Auto-generated method stub
		translateMapper.updateByPrimaryKey(translate);
	}

	@Override
	public void addTranslate(Translate translate) {
		// TODO Auto-generated method stub
		translateMapper.insert(translate);
		Integer bid = translate.getBid();
		Balance balance = balanceMapper.selectByPrimaryKey(bid);
		balance.setBcount(balance.getBcount() - translate.getTcount());
		balanceMapper.updateByPrimaryKey(balance);
	}

	@Override
	public Balance findBalanceById(Integer bid) {
		// TODO Auto-generated method stub
		return balanceMapper.selectByPrimaryKey(bid);
	}

	@Override
	public List<Repair> selectAllRepairList() {
		// TODO Auto-generated method stub
		return repairManager.selectAll();
	}

	@Override
	public Repair findById3(Integer rid) {
		// TODO Auto-generated method stub
		return repairManager.selectByPrimaryKey(rid);
	}

	@Override
	public void deleteById3(Integer rid) {
		// TODO Auto-generated method stub
		repairManager.deleteByPrimaryKey(rid);
	}

	@Override
	public void addRepair(Repair repair) {
		// TODO Auto-generated method stub
		repairManager.insert(repair);
	}

	@Override
	public void updateRepair(Repair repair) {
		// TODO Auto-generated method stub
		repairManager.updateByPrimaryKey(repair);
	}

	@Override
	public List<Scrap> selectAllScrapList() {
		// TODO Auto-generated method stub
		return scrapMapper.selectAll();
	}

	@Override
	public Scrap findById4(Integer sid) {
		// TODO Auto-generated method stub
		return scrapMapper.selectByPrimaryKey(sid);
	}

	@Override
	public void deleteById4(Integer rid) {
		// TODO Auto-generated method stub
		scrapMapper.deleteByPrimaryKey(rid);
	}

	@Override
	public void addScrap(Scrap scrap) {
		// TODO Auto-generated method stub
		scrapMapper.insert(scrap);
	}

	@Override
	public void updateScrap(Scrap scrap) {
		// TODO Auto-generated method stub
		scrapMapper.updateByPrimaryKey(scrap);
	}

	@Override
	public List<Balance> getBalanceList() {
		// TODO Auto-generated method stub
		return balanceMapper.selectAll();
	}

	@Override
	public List<Provider> selectAllProviderList() {
		// TODO Auto-generated method stub
		return providerMapper.selectAll();
	}

}
