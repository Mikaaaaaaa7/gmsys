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
	
	//资产统计：order by 部门编号DEPARTID
	public List<Balance> getZCByDepart();
	
	//采购记录
	public List<Buy> getAllBuyDetail();
	public Buy getOneBuyDetail(Integer buyid);
	
	//调配记录
	public List<Translate> getAllTranslate();
	
	//报修记录
	public List<Repair> getRepairDetail();
	
	//报废记录
	public List<Scrap> getScrapDetail();
}
