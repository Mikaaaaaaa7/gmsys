package com.neuedu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neuedu.model.Balance;
import com.neuedu.model.Buy;
import com.neuedu.model.Repair;
import com.neuedu.model.Scrap;
import com.neuedu.model.Translate;
import com.neuedu.service.UsageStatisticService;

//配置mvc的控制器类
@Controller
public class UsageStatisticController {
	// 在mvc的控制层整合service服务层
	@Autowired
	private UsageStatisticService usageStatisticService;
	
	//在浏览中通过URL调用这个方法进行查询所有采购记录:/cgjl/findAll.do
	@RequestMapping("/cgjl/findAll")
	public String showBuyDetail(HttpServletRequest request){
		List<Buy> buyList=usageStatisticService.getAllBuyDetail();			
		request.setAttribute("listCgjl", buyList);
		return "caigoujilu";
	}
	@RequestMapping("/cgjl/findById")
	public String findOneBuy(@RequestParam("buyid") Integer bid,HttpServletRequest request){
		List<Buy> b=usageStatisticService.getOneBuyDetail(bid);
		request.setAttribute("listCgjl", b);
		return "caigoujilu";
	}
	
	//在浏览中通过URL调用这个方法进行查询资产总数:/balance/findAll.do
	@RequestMapping("/balance/findAll")
	public String showAllBalance(HttpServletRequest request){
		List<Balance> bidList=usageStatisticService.getZCByBid();			
		request.setAttribute("bidList", bidList);
		List<Balance> departList=usageStatisticService.getZCByDepart();			
		request.setAttribute("departList", departList);		
		return "totalzc";
	}
	//查询资产总数 by Bid
	@RequestMapping("balance/findById")
	public String showBalanceByBid(@RequestParam("bid") Integer bid,HttpServletRequest request){
		List<Balance> b=usageStatisticService.getOneBid(bid);			
		request.setAttribute("bidList", b);
		return "totalzc";
	}
	//查询资产总数 by Departid
	@RequestMapping("balance/findById2")
	public String showBalanceByDepart(@RequestParam("departid") Integer departid,HttpServletRequest request){
		List<Balance> b=usageStatisticService.getOneDepart(departid);			
		request.setAttribute("departList", b);
		return "totalzc";
	}
	
	//在浏览中通过URL调用这个方法进行查询跨部门调配记录:/tpjl/findAll.do
	@RequestMapping("/tpjl/findAll")
	public String showTranslate(HttpServletRequest request){
		List<Translate> translateList=usageStatisticService.getAllTranslate();			
		request.setAttribute("translateList", translateList);
		return "tiaopeijilu";
	}
	@RequestMapping("/tpjl/fingById")
	public String getOneById(@RequestParam("pepartid") Integer pepartid,HttpServletRequest request){
		List<Translate> translateList=usageStatisticService.getOneTranslate(pepartid);			
		request.setAttribute("translateList", translateList);
		return "tiaopeijilu";
	}
	
	
	//在浏览中通过URL调用这个方法进行查询保修记录:/bxjl/findAll.do
	@RequestMapping("/bxjl/findAll")
	public String showRepair(HttpServletRequest request){
		List<Repair> repairList=usageStatisticService.getRepairDetail();			
		request.setAttribute("repairList", repairList);
		return "baoxiujilu";
	}
	@RequestMapping("/bxjl/findById")
	public String showOneRepair(@RequestParam("repairid") Integer repairid,HttpServletRequest request){
		List<Repair> repairList=usageStatisticService.getOneRepair(repairid);			
		request.setAttribute("repairList", repairList);
		return "baoxiujilu";
	}
	
	//在浏览中通过URL调用这个方法进行查询报废记录:/bfjl/findAll.do
	@RequestMapping("/bfjl/findAll")
	public String showScrap(HttpServletRequest request){
		List<Scrap> scrapList=usageStatisticService.getScrapDetail();			
		request.setAttribute("scrapList", scrapList);
		return "baofeijilu";
	}
	@RequestMapping("/bfjl/findById")
	public String showOneScrap(@RequestParam("sid") Integer sid,HttpServletRequest request){
		List<Scrap> scrapList=usageStatisticService.getOneScrap(sid);			
		request.setAttribute("scrapList", scrapList);
		return "baofeijilu";
	}
}
