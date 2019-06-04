package com.neuedu.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neuedu.model.Balance;
import com.neuedu.model.Buy;
import com.neuedu.model.Department;
import com.neuedu.model.Product;
import com.neuedu.model.Provider;
import com.neuedu.model.Repair;
import com.neuedu.model.Scrap;
import com.neuedu.model.Translate;
import com.neuedu.service.AssetManageService;

//配置mvc的控制器类
@Controller
public class AssetManageController {

	// 在mvc的控制层整合service服务层
	@Autowired
	private AssetManageService assetManageService;

	/**
	 * 查询采购记录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/buy/findAll")
	public String findAllBuy(HttpServletRequest request) {

		List<Buy> listBuy = assetManageService.selectAll();
		request.setAttribute("listBuy", listBuy);

		return "caigouxinxi";
	}

	/**
	 * 根据id查询采购记录
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/buy/findById3")
	public String findById3(@RequestParam("id") Integer id, HttpServletRequest request) {
		if (id != null) {
			Buy Buy1 = assetManageService.findById(id);
			request.setAttribute("Buy1", Buy1);
		} else {
			List<Buy> listBuy = assetManageService.selectAll();
			request.setAttribute("listBuy", listBuy);
		}
		return "caigouxinxi";
	}

	/**
	 * 删除采购记录
	 * 
	 * @param buyidString
	 * @param request
	 * @return
	 */
	@RequestMapping("/buy/delete")
	public String delete(@RequestParam("number") String buyidString, HttpServletRequest request) {
		String[] sourcestrStrings = buyidString.split("-");
		int[] sourceint = new int[sourcestrStrings.length];
		for (int i = 0; i < sourcestrStrings.length; i++) {
			sourceint[i] = Integer.parseInt(sourcestrStrings[i]);
			assetManageService.deleteById(sourceint[i]);
		}
		List<Buy> listBuy = assetManageService.selectAll();
		request.setAttribute("listBuy", listBuy);
		return "caigouxinxi";
	}

	/**
	 * 初始化添加采购记录页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/buy/findAll2")
	public String findAll2(HttpServletRequest request) {
		List<Provider> Buy2 = assetManageService.selectAllProviderList();

		List<Department> Buy3 = assetManageService.selectAllDepartmentList();

		request.setAttribute("Buy2", Buy2);
		request.setAttribute("Buy3", Buy3);
		return "addcaigou";
	}

	/**
	 * 添加采购记录
	 * 
	 * @param BUYCOUNT
	 * @param BUYTIME
	 * @param PROVID
	 * @param DEPARTID
	 * @param request
	 * @return
	 */
	@RequestMapping("/buy/add")
	public String addCaigouxinxi(Double BUYCOUNT, String BUYTIME, Integer PROVID, Integer DEPARTID,
			HttpServletRequest request) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Buy buy = new Buy();
			buy.setBuycount(BUYCOUNT);
			buy.setBuytime(format.parse(BUYTIME));
			buy.setProvid(PROVID);
			buy.setDepartid(DEPARTID);
			assetManageService.addBuy(buy);
			List<Buy> listBuy = assetManageService.selectAll();
			request.setAttribute("listBuy", listBuy);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "caigouxinxi";
	}

	/**
	 * 初始化更新采购记录页
	 * 
	 * @param buyid
	 * @param request
	 * @return
	 */
	@RequestMapping("/buy/findById")
	public String findById(@RequestParam("id") Integer buyid, HttpServletRequest request) {
		Buy Buy1 = assetManageService.findById(buyid);

		List<Product> Buy2 = assetManageService.selectAllProductList();
		List<Department> Buy3 = assetManageService.selectAllDepartmentList();

		request.setAttribute("Buy1", Buy1);
		request.setAttribute("Buy2", Buy2);
		request.setAttribute("Buy3", Buy3);

		return "updatecaigou";
	}

	/**
	 * 更新采购记录
	 * 
	 * @param BUYID
	 * @param BUYCOUNT
	 * @param BUYTIME
	 * @param PROVID
	 * @param DEPARTID
	 * @param request
	 * @return
	 */
	@RequestMapping("/buy/upate")
	public String update(Integer BUYID, Double BUYCOUNT, String BUYTIME, Integer PROVID, Integer DEPARTID,
			HttpServletRequest request) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Buy buy = new Buy();
			buy.setBuyid(BUYID);
			buy.setBuycount(BUYCOUNT);
			buy.setBuytime(format.parse(BUYTIME));
			buy.setProvid(PROVID);
			buy.setDepartid(DEPARTID);
			assetManageService.updateBuy(buy);

			List<Buy> listBuy = assetManageService.selectAll();
			request.setAttribute("listBuy", listBuy);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "caigouxinxi";
	}

	/**
	 * 根据id获取采购记录，跳转到详情页
	 * 
	 * @param buyid
	 * @param request
	 * @return
	 */
	@RequestMapping("/buy/findById2")
	public String findById2(@RequestParam("id") Integer buyid, HttpServletRequest request) {
		Buy Buy1 = assetManageService.findById(buyid);
		request.setAttribute("Buy1", Buy1);
		return "caigoudetails";
	}

	/**
	 * 初始化盘点管理页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/buyProuduct/findAll")
	public String findAllBuyProduct(HttpServletRequest request) {
		List<Buy> listBuy1 = assetManageService.selectAll();
		List<Translate> listBuy2 = assetManageService.selectAllTranslateList();
		List<Repair> listBuy3 = assetManageService.selectAllRepairList();
		List<Scrap> listBuy4 = assetManageService.selectAllScrapList();

		request.setAttribute("listBuy1", listBuy1);
		request.setAttribute("listBuy2", listBuy2);
		request.setAttribute("listBuy3", listBuy3);
		request.setAttribute("listBuy4", listBuy4);

		return "pandianxinxi";
	}

	/**
	 * 获取调配列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/buyProuduct/findAll2")
	public String findAll2BuyProduct(HttpServletRequest request) {
		List<Translate> listBuy2 = assetManageService.selectAllTranslateList();

		request.setAttribute("listBuy2", listBuy2);

		return "daiopeixinxi";
	}

	/**
	 * 根据id查询调配记录
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/translate/findById")
	public String findById4(@RequestParam("id") Integer id, HttpServletRequest request) {
		if (id != null) {
			Translate query = assetManageService.findById2(id);
			request.setAttribute("query", query);
		} else {
			List<Translate> listBuy2 = assetManageService.selectAllTranslateList();
			request.setAttribute("listBuy2", listBuy2);
		}
		return "daiopeixinxi";
	}

	/**
	 * 删除调配记录
	 * 
	 * @param buyidString
	 * @param request
	 * @return
	 */
	@RequestMapping("/translate/delete")
	public String delete2(@RequestParam("number") String buyidString, HttpServletRequest request) {
		String[] sourcestrStrings = buyidString.split("-");
		int[] sourceint = new int[sourcestrStrings.length];
		for (int i = 0; i < sourcestrStrings.length; i++) {
			sourceint[i] = Integer.parseInt(sourcestrStrings[i]);
			assetManageService.deleteById2(sourceint[i]);
		}
		List<Translate> listBuy2 = assetManageService.selectAllTranslateList();
		request.setAttribute("listBuy2", listBuy2);
		return "daiopeixinxi";
	}

	/**
	 * 跳转到添加调配页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/translate/toAddTranslatePage")
	public String toAddTranslatePage(HttpServletRequest request) {
		List<Balance> balanceList = assetManageService.getBalanceList();
		List<Department> Buy3 = assetManageService.selectAllDepartmentList();

		request.setAttribute("balance", balanceList);
		request.setAttribute("Buy3", Buy3);
		return "addtiaopei";
	}

	/**
	 * 根据id获取资产计数
	 * 
	 * @param bid
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/buy/checkBalance")
	public void checkBalance(@RequestParam("id") Integer bid, HttpServletResponse response) throws Exception {
		Integer bCount = 0;
		Balance balance = assetManageService.findBalanceById(bid);
		bCount = ((Number) balance.getBcount()).intValue();
		Map<String, Integer> returnMap = new HashMap<String, Integer>();
		returnMap.put("count", bCount);
		ObjectMapper objectMapper = new ObjectMapper();
		String str = objectMapper.writeValueAsString(returnMap);
		response.getWriter().write(str);
	}

	/**
	 * 添加调配记录
	 * 
	 * @return
	 */
	@RequestMapping("/translate/addTranslate")
	public String addTranslate(@RequestParam("TCOUNT") Double TCOUNT, @RequestParam("TRTIME") String TRTIME,
			@RequestParam("BID") Integer BID, @RequestParam("DEPARTID") Integer DEPARTID, HttpServletRequest request) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Translate translate = new Translate();
			translate.setTrtime(format.parse(TRTIME));
			translate.setTcount(TCOUNT);
			translate.setDepartid(DEPARTID);
			translate.setBid(BID);
			assetManageService.addTranslate(translate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Translate> listBuy2 = assetManageService.selectAllTranslateList();
		request.setAttribute("listBuy2", listBuy2);
		return "daiopeixinxi";
	}

	/**
	 * 根据id查询调配记录,并跳转到详情页
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/translate/translateDetail")
	public String toTranslateDetail(@RequestParam("id") Integer id, HttpServletRequest request) {
		Translate query = assetManageService.findById2(id);
		request.setAttribute("translate", query);
		return "diaopeidetails";
	}

	/**
	 * 根据id查询调配记录,并跳转到编辑页
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/translate/toTranslateUpdate")
	public String toTranslateUpdate(@RequestParam("id") Integer id, HttpServletRequest request) {
		Translate query = assetManageService.findById2(id);
		List<Balance> balances = assetManageService.getBalanceList();
		List<Department> departments = assetManageService.selectAllDepartmentList();
		request.setAttribute("translate", query);
		request.setAttribute("balanceList", balances);
		request.setAttribute("departmentList", departments);
		return "updatediaopei";
	}

	/**
	 * 更新调度记录
	 * 
	 * @param TID
	 * @param TCOUNT
	 * @param TRTIME
	 * @param BID
	 * @param DEPARTID
	 * @param request
	 * @return
	 */
	@RequestMapping("/translate/update")
	public String updateTranslate(@RequestParam("TID") Integer TID, @RequestParam("TCOUNT") Double TCOUNT,
			@RequestParam("TRTIME") String TRTIME, @RequestParam("BID") Integer BID,
			@RequestParam("DEPARTID") Integer DEPARTID, HttpServletRequest request) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Translate translate = new Translate();
			translate.setTid(TID);
			translate.setTrtime(format.parse(TRTIME));
			translate.setTcount(TCOUNT);
			translate.setDepartid(DEPARTID);
			translate.setBid(BID);
			assetManageService.updateTranslate(translate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Translate> listBuy2 = assetManageService.selectAllTranslateList();
		request.setAttribute("listBuy2", listBuy2);
		return "daiopeixinxi";
	}

	/**
	 * 获取报修列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/buyProuduct/findAll3")
	public String findAll3BuyProduct(HttpServletRequest request) {
		List<Repair> listBuy3 = assetManageService.selectAllRepairList();

		request.setAttribute("listBuy3", listBuy3);

		return "baoxiuxinxi";
	}

	/**
	 * 根据id查询报修记录
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/repair/findById")
	public String findById5(@RequestParam("id") Integer id, HttpServletRequest request) {
		if (id != null) {
			Repair query = assetManageService.findById3(id);
			request.setAttribute("query", query);
		} else {
			List<Repair> listBuy3 = assetManageService.selectAllRepairList();
			request.setAttribute("listBuy3", listBuy3);
		}
		return "baoxiuxinxi";
	}

	/**
	 * 删除报修记录
	 * 
	 * @param buyidString
	 * @param request
	 * @return
	 */
	@RequestMapping("/repair/delete")
	public String delete3(@RequestParam("number") String buyidString, HttpServletRequest request) {
		String[] sourcestrStrings = buyidString.split("-");
		int[] sourceint = new int[sourcestrStrings.length];
		for (int i = 0; i < sourcestrStrings.length; i++) {
			sourceint[i] = Integer.parseInt(sourcestrStrings[i]);
			assetManageService.deleteById3(sourceint[i]);
		}
		List<Repair> listBuy3 = assetManageService.selectAllRepairList();
		request.setAttribute("listBuy3", listBuy3);
		return "baoxiuxinxi";
	}

	/**
	 * 根据id查询报修记录,并跳转到详情页
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/repair/repairDetail")
	public String toRepairDetail(@RequestParam("id") Integer id, HttpServletRequest request) {
		Repair query = assetManageService.findById3(id);
		request.setAttribute("query", query);
		return "baoxiudetails";
	}

	/**
	 * 跳转到新增报修页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/repair/toAddRepair")
	public String toAddRepairPage(HttpServletRequest request) {
		List<Balance> balanceList = assetManageService.getBalanceList();
		List<Department> departmentList = assetManageService.selectAllDepartmentList();

		request.setAttribute("balanceList", balanceList);
		request.setAttribute("departmentList", departmentList);
		return "addbaoxiu";
	}

	/**
	 * 添加报修记录
	 * 
	 * @return
	 */
	@RequestMapping("/repair/addRepair")
	public String addRepair(@RequestParam("RCOUNT") Double RCOUNT, @RequestParam("RTIME") String RTIME,
			@RequestParam("BID") Integer BID, @RequestParam("DEPARTID") Integer DEPARTID, HttpServletRequest request) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Repair repair = new Repair();
			repair.setRtime(format.parse(RTIME));
			repair.setRcount(RCOUNT);
			repair.setDepartid(DEPARTID);
			repair.setBid(BID);
			assetManageService.addRepair(repair);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Repair> listBuy3 = assetManageService.selectAllRepairList();
		request.setAttribute("listBuy3", listBuy3);
		return "baoxiuxinxi";
	}

	/**
	 * 根据id查询报修记录,并跳转到编辑页
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/repair/toRepairUpdate")
	public String toRepairUpdate(@RequestParam("id") Integer id, HttpServletRequest request) {
		Repair query = assetManageService.findById3(id);
		List<Balance> balances = assetManageService.getBalanceList();
		List<Department> departments = assetManageService.selectAllDepartmentList();
		request.setAttribute("query", query);
		request.setAttribute("balanceList", balances);
		request.setAttribute("departmentList", departments);
		return "updatebaoxiu";
	}

	/**
	 * 更新报修记录
	 * 
	 * @param TID
	 * @param TCOUNT
	 * @param TRTIME
	 * @param BID
	 * @param DEPARTID
	 * @param request
	 * @return
	 */
	@RequestMapping("/repair/update")
	public String updateRepair(@RequestParam("REPAIRID") Integer REPAIRID, @RequestParam("RCOUNT") Double RCOUNT,
			@RequestParam("RTIME") String RTIME, @RequestParam("BID") Integer BID,
			@RequestParam("DEPARTID") Integer DEPARTID, HttpServletRequest request) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Repair repair = new Repair();
			repair.setRepairid(REPAIRID);
			repair.setRtime(format.parse(RTIME));
			repair.setRcount(RCOUNT);
			repair.setDepartid(DEPARTID);
			repair.setBid(BID);
			assetManageService.updateRepair(repair);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Repair> listBuy3 = assetManageService.selectAllRepairList();
		request.setAttribute("listBuy3", listBuy3);
		return "baoxiuxinxi";
	}

	/**
	 * 获取报废列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/buyProuduct/findAll4")
	public String findAll4BuyProduct(HttpServletRequest request) {
		List<Scrap> listBuy4 = assetManageService.selectAllScrapList();

		request.setAttribute("listBuy4", listBuy4);

		return "baofeixinxi";
	}

	/**
	 * 根据id查询报废记录
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/scrap/findById")
	public String findById6(@RequestParam("id") Integer id, HttpServletRequest request) {
		if (id != null) {
			Scrap query = assetManageService.findById4(id);
			request.setAttribute("query", query);
		} else {
			List<Scrap> listBuy4 = assetManageService.selectAllScrapList();
			request.setAttribute("listBuy4", listBuy4);
		}
		return "baofeixinxi";
	}

	/**
	 * 删除报废记录
	 * 
	 * @param buyidString
	 * @param request
	 * @return
	 */
	@RequestMapping("/scrap/delete")
	public String delete4(@RequestParam("number") String buyidString, HttpServletRequest request) {
		String[] sourcestrStrings = buyidString.split("-");
		int[] sourceint = new int[sourcestrStrings.length];
		for (int i = 0; i < sourcestrStrings.length; i++) {
			sourceint[i] = Integer.parseInt(sourcestrStrings[i]);
			assetManageService.deleteById4(sourceint[i]);
		}
		List<Scrap> listBuy4 = assetManageService.selectAllScrapList();
		request.setAttribute("listBuy4", listBuy4);
		return "baofeixinxi";
	}

	/**
	 * 根据id查询报废记录,并跳转到详情页
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/scrap/scrapDetail")
	public String toScrapDetail(@RequestParam("id") Integer id, HttpServletRequest request) {
		Scrap query = assetManageService.findById4(id);
		request.setAttribute("query", query);
		return "baofeidetails";
	}

	/**
	 * 跳转到新增报废页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/scrap/toAddScrap")
	public String toAddScrapPage(HttpServletRequest request) {
		List<Balance> balanceList = assetManageService.getBalanceList();
		List<Department> departmentList = assetManageService.selectAllDepartmentList();

		request.setAttribute("balanceList", balanceList);
		request.setAttribute("departmentList", departmentList);
		return "addbaofei";
	}

	/**
	 * 添加报废记录
	 * 
	 * @return
	 */
	@RequestMapping("/scrap/addScrap")
	public String addScrap(@RequestParam("SCOUNT") Double SCOUNT, @RequestParam("STIME") String STIME,
			@RequestParam("BID") Integer BID, @RequestParam("DEPARTID") Integer DEPARTID, HttpServletRequest request) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Scrap scrap = new Scrap();
			scrap.setStime(format.parse(STIME));
			scrap.setScount(SCOUNT);
			scrap.setDepartid(DEPARTID);
			scrap.setBid(BID);
			assetManageService.addScrap(scrap);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Scrap> listBuy4 = assetManageService.selectAllScrapList();
		request.setAttribute("listBuy4", listBuy4);
		return "baofeixinxi";
	}

	/**
	 * 根据id查询报废记录,并跳转到编辑页
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/scrap/toScrapUpdate")
	public String toScrapUpdate(@RequestParam("id") Integer id, HttpServletRequest request) {
		Scrap query = assetManageService.findById4(id);
		List<Balance> balances = assetManageService.getBalanceList();
		List<Department> departments = assetManageService.selectAllDepartmentList();
		request.setAttribute("query", query);
		request.setAttribute("balanceList", balances);
		request.setAttribute("departmentList", departments);
		return "updatebaofei";
	}

	/**
	 * 更新报废记录
	 * 
	 * @param TID
	 * @param TCOUNT
	 * @param TRTIME
	 * @param BID
	 * @param DEPARTID
	 * @param request
	 * @return
	 */
	@RequestMapping("/scrap/update")
	public String updateScrap(@RequestParam("SID") Integer SID, @RequestParam("SCOUNT") Double SCOUNT,
			@RequestParam("STIME") String STIME, @RequestParam("BID") Integer BID,
			@RequestParam("DEPARTID") Integer DEPARTID, HttpServletRequest request) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Scrap scrap = new Scrap();
			scrap.setSid(SID);
			scrap.setStime(format.parse(STIME));
			scrap.setScount(SCOUNT);
			scrap.setDepartid(DEPARTID);
			scrap.setBid(BID);
			assetManageService.updateScrap(scrap);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Scrap> listBuy4 = assetManageService.selectAllScrapList();
		request.setAttribute("listBuy4", listBuy4);
		return "baofeixinxi";
	}
}
