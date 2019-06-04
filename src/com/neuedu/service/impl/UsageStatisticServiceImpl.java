package com.neuedu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.mapper.BuyMapper;
import com.neuedu.mapper.RepairMapper;
import com.neuedu.mapper.ScrapMapper;
import com.neuedu.mapper.TranslateMapper;
import com.neuedu.mapper.BalanceMapper;
import com.neuedu.model.Balance;
import com.neuedu.model.Buy;
import com.neuedu.model.Repair;
import com.neuedu.model.Scrap;
import com.neuedu.model.Translate;
import com.neuedu.service.UsageStatisticService;

@Service //注解service的实现类
@Transactional //此处不再进行创建SqlSession和提交事务 都已经由Spring去管理了
public class UsageStatisticServiceImpl implements UsageStatisticService{
	@Resource //注解注入
	private BalanceMapper balanceMapper;
	//资产统计：order by 资产分类编号BID
	public List<Balance> getZCByBid(){
		return balanceMapper.orderByBid();
	}
	public List<Balance> getOneBid(Integer bid){
		return balanceMapper.selectByBid(bid);
	}
	
	//资产统计：order by 部门编号DEPARTID
	public List<Balance> getZCByDepart(){
		return balanceMapper.orderByDepart();
	}
	public List<Balance> getOneDepart(Integer depart){
		return balanceMapper.selectByDepart(depart);
	}
	
	@Resource //注解注入
	private BuyMapper BuyMapper;	
	public List<Buy> getAllBuyDetail(){
		return BuyMapper.selectAll();
	}
	public List<Buy> getOneBuyDetail(Integer buyid){
		return BuyMapper.selectByBuyid(buyid);
	}
	
	//调配记录
	@Resource //注解注入
	private TranslateMapper translateMapper;
	public List<Translate> getAllTranslate(){
		return translateMapper.selectAll();
	}
	public List<Translate> getOneTranslate(Integer pepartid){
		return translateMapper.selectOne(pepartid);
	}
	
	@Resource //注解注入
	private RepairMapper repairMapper;
	//报修记录
	public List<Repair> getRepairDetail(){
		return repairMapper.selectAll();
	}
	public List<Repair> getOneRepair(Integer repairid){
		return repairMapper.selectOne(repairid);
	}
	
	
	//报废记录
	@Resource //注解注入
	private ScrapMapper scrapMapper;
	public List<Scrap> getScrapDetail(){
		return scrapMapper.selectAll();
	}
	public List<Scrap> getOneScrap(Integer sid){
		return scrapMapper.selectOne(sid);
	}
}
