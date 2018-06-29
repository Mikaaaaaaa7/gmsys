package com.neuedu.service;

import java.util.List;

import com.neuedu.model.Balance;
import com.neuedu.model.Buy;
import com.neuedu.model.Repair;
import com.neuedu.model.Scrap;
import com.neuedu.model.Translate;

public interface UsageStatisticService {
	//资产统计：order by 资产分类编号BID
	public List<Balance> getZCByBid();
	public List<Balance> getOneBid(Integer bid);
	
	//资产统计：order by 部门编号DEPARTID
	public List<Balance> getZCByDepart();
	public List<Balance> getOneDepart(Integer depart);
	
	//采购记录
	public List<Buy> getAllBuyDetail();
	public List<Buy> getOneBuyDetail(Integer buyid);
	
	//调配记录
	public List<Translate> getAllTranslate();
	public List<Translate> getOneTranslate(Integer tid);
	
	//报修记录
	public List<Repair> getRepairDetail();
	public List<Repair> getOneRepair(Integer repairid);
	
	//报废记录
	public List<Scrap> getScrapDetail();
	public List<Scrap> getOneScrap(Integer sid);
}
