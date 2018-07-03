package com.neuedu.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neuedu.model.Area;
import com.neuedu.model.Balance;
import com.neuedu.model.Category;
import com.neuedu.model.Department;
import com.neuedu.model.Page;
import com.neuedu.service.BaseDataManageService;
import com.neuedu.service.UserAccountService;

//配置mvc的控制器类
@Controller
public class BaseDataManageController {

	// 在mvc的控制层整合service服务层
	@Autowired
	private BaseDataManageService baseDataManageService;
	
	//在浏览中通过URL调用这个方法进行登录:findAll.do
	@RequestMapping("/category/findAll.do")
	public String findAll(Model model,HttpServletRequest request){
		 //获取当前页数
        String pageNow=request.getParameter("pageNow");
        //获取总页数
        int totalCount=((Number)baseDataManageService.findNewContCategory()).intValue();
        Page page=null;
        List<Category> list=new ArrayList<Category>();
        if (pageNow!=null) {
            page=new Page(Integer.parseInt(pageNow), totalCount);
            list=this.baseDataManageService.findNewsPageCategory(page.getStartPos(),page.getPageSize());
        }else {
            page=new Page(1, totalCount);
            list=this.baseDataManageService.findNewsPageCategory(page.getStartPos(),page.getPageSize());
        }
        model.addAttribute("listCategory", list);
        model.addAttribute("page", page);
		
		//List<Category> listcategory=baseDataManageService.selectAll();
		//request.setAttribute("listCategory", listcategory);
		
		return "zcflxinxi";
	}
	//在浏览中通过URL调用这个方法进行登录:findBymh.do
	@RequestMapping("/category/findBymh.do")
	public String findByCname(@RequestParam("zha") String cname,HttpServletRequest request){
		List<Category> listcategory=baseDataManageService.selectByCnamemohu(cname);
		request.setAttribute("listCategory", listcategory);
		
		return "zcflxinxi";
	}
	//在浏览中通过URL调用这个方法进行登录:findById.do
	@RequestMapping("/category/findById.do")
	public String findByCid(@RequestParam("cid") Integer cid,HttpServletRequest request){
		Category category=baseDataManageService.selectByCid(cid);
		request.setAttribute("category", category);
		return "updatezcfl";
	}
	//在浏览中通过URL调用这个方法进行登录:findByIdchakan.do
	@RequestMapping("/category/findByIdchakan.do")
	public String findByCidchakan(@RequestParam("cid") Integer cid,HttpServletRequest request){
		Category category=baseDataManageService.findByCidchakan(cid);
		request.setAttribute("category", category);
		return "zcfldetails";
	}
	//在浏览中通过URL调用这个方法进行登录:update.do
	@RequestMapping("/category/update.do")
	public String updatezcfl(Integer cid, String cname,HttpServletRequest request){
		Category record=new Category();
		record.setCid(cid);
		record.setCname(cname);
		request.setAttribute("category", record);
		baseDataManageService.updatezcfl(record);
		return "zcfldetails";
	}
	//在浏览中通过URL调用这个方法进行登录:delete.do
	@RequestMapping("/category/delete.do")
	public String deletezcfl(@RequestParam("cid") String cid, Model model,HttpServletRequest request){
		//baseDataManageService.deletezcfl(cid);
		String[] sourcestrStrings=cid.split(":");
		int[] sourceint=new int[sourcestrStrings.length];
		for (int i = 0; i < sourcestrStrings.length; i++) {
			sourceint[i]=Integer.parseInt(sourcestrStrings[i]);
			baseDataManageService.deletezcfl(sourceint[i]);
		}
		/*List<Category> listcategory=baseDataManageService.selectAll();
		request.setAttribute("listCategory", listcategory);
		return "zcflxinxi";*/
		//获取当前页数
        String pageNow=request.getParameter("pageNow");
        //获取总页数
        int totalCount=((Number)baseDataManageService.findNewContCategory()).intValue();
        Page page=null;
        List<Category> list=new ArrayList<Category>();
        if (pageNow!=null) {
            page=new Page(Integer.parseInt(pageNow), totalCount);
            list=this.baseDataManageService.findNewsPageCategory(page.getStartPos(),page.getPageSize());
        }else {
            page=new Page(1, totalCount);
            list=this.baseDataManageService.findNewsPageCategory(page.getStartPos(),page.getPageSize());
        }
        model.addAttribute("listCategory", list);
        model.addAttribute("page", page);
		
		//List<Category> listcategory=baseDataManageService.selectAll();
		//request.setAttribute("listCategory", listcategory);
		
		return "zcflxinxi";
	}
	//在浏览中通过URL调用这个方法进行登录:add.do
	@RequestMapping("/category/add.do")
	public String addzcfl(String cname,Model model, HttpServletRequest request){
		Category record=new Category();
		record.setCname(cname);
		baseDataManageService.addzcfl(record);
		
		//List<Category> listcategory=baseDataManageService.selectAll();
		//request.setAttribute("listCategory", listcategory);
		//return "zcflxinxi";
		//获取当前页数
        String pageNow=request.getParameter("pageNow");
        //获取总页数
        int totalCount=((Number)baseDataManageService.findNewContCategory()).intValue();
        Page page=null;
        List<Category> list=new ArrayList<Category>();
        if (pageNow!=null) {
            page=new Page(Integer.parseInt(pageNow), totalCount);
            list=this.baseDataManageService.findNewsPageCategory(page.getStartPos(),page.getPageSize());
        }else {
            page=new Page(1, totalCount);
            list=this.baseDataManageService.findNewsPageCategory(page.getStartPos(),page.getPageSize());
        }
        model.addAttribute("listCategory", list);
        model.addAttribute("page", page);
		
		//List<Category> listcategory=baseDataManageService.selectAll();
		//request.setAttribute("listCategory", listcategory);
		
		return "zcflxinxi";
	}

	
	//部门设置
	//在浏览中通过URL调用这个方法进行登录:findAll.do
	@RequestMapping("/department/findAll.do")
	public String departmentfindAll(Model model,HttpServletRequest request){
		 //获取当前页数
        String pageNow=request.getParameter("pageNow");
        //获取总页数
        int totalCount=((Number)baseDataManageService.findNewContDepartment()).intValue();
        Page page=null;
        List<Department> list=new ArrayList<Department>();
        if (pageNow!=null) {
            page=new Page(Integer.parseInt(pageNow), totalCount);
            list=this.baseDataManageService.findNewsPageDepartment(page.getStartPos(),page.getPageSize());
        }else {
            page=new Page(1, totalCount);
            list=this.baseDataManageService.findNewsPageDepartment(page.getStartPos(),page.getPageSize());
        }
        model.addAttribute("listDepartment", list);
        model.addAttribute("page", page);
		
		//List<Department> listdepartment=baseDataManageService.selectAllDepartment();
		//request.setAttribute("listDepartment", listdepartment);
		return "bmxinxi";
	}
	//在浏览中通过URL调用这个方法进行登录:findById.do
	@RequestMapping("/department/findById.do")
	public String findByDid(@RequestParam("departid") Integer departid,HttpServletRequest request){
		Department department=baseDataManageService.selectByDid(departid);
		request.setAttribute("department", department);
		return "updatebm";
	}
	//在浏览中通过URL调用这个方法进行登录:findByIdchakan.do
	@RequestMapping("/department/findByIdchakan.do")
	public String findByDidchakan(@RequestParam("departid") Integer departid,HttpServletRequest request){
		Department department=baseDataManageService.findByDidchakan(departid);
		request.setAttribute("department", department);
		return "bmdetails";
	}
	//在浏览中通过URL调用这个方法进行登录:findBymh.do
	@RequestMapping("/department/findBymh.do")
	public String findByDepartid(@RequestParam("zha") Integer departid,HttpServletRequest request){
		Department department=baseDataManageService.selectByDid(departid);
		List<Object> list = new ArrayList<Object>();
		list.add(department);
		request.setAttribute("listDepartment", list);
		return "bmxinxi";
	}
	//在浏览中通过URL调用这个方法进行登录:update.do
	@RequestMapping("/department/update.do")
	public String updatebm(Integer departid, String departname,String areaname,HttpServletRequest request){
		Department record=new Department();
		record.setDepartid(departid);
		record.setAreaid(baseDataManageService.selectByDid(departid).getAreaid());
		record.setAreaname(areaname);
		record.setDepartname(departname);
		baseDataManageService.updatebm(record);
		request.setAttribute("department", record);
		return "bmdetails";
	}
	//在浏览中通过URL调用这个方法进行登录:delete.do
	@RequestMapping("/department/delete.do")
	public String deletebm(@RequestParam("cid") String departid, Model model,HttpServletRequest request){
		//baseDataManageService.deletezcfl(cid);
		String[] sourcestrStrings=departid.split(":");
		int[] sourceint=new int[sourcestrStrings.length];
		for (int i = 0; i < sourcestrStrings.length; i++) {
			sourceint[i]=Integer.parseInt(sourcestrStrings[i]);
			baseDataManageService.deletebm(sourceint[i]);
		}
		 //获取当前页数
        String pageNow=request.getParameter("pageNow");
        //获取总页数
        int totalCount=((Number)baseDataManageService.findNewContDepartment()).intValue();
        Page page=null;
        List<Department> list=new ArrayList<Department>();
        if (pageNow!=null) {
            page=new Page(Integer.parseInt(pageNow), totalCount);
            list=this.baseDataManageService.findNewsPageDepartment(page.getStartPos(),page.getPageSize());
        }else {
            page=new Page(1, totalCount);
            list=this.baseDataManageService.findNewsPageDepartment(page.getStartPos(),page.getPageSize());
        }
        model.addAttribute("listDepartment", list);
        model.addAttribute("page", page);
		//List<Department> listdepartment=baseDataManageService.selectAllDepartment();
		//request.setAttribute("listDepartment", listdepartment);
		return "bmxinxi";
	}
	//在浏览中通过URL调用这个方法进行登录:add.do
	@RequestMapping("/department/add.do")
	public String addbm(String departname,String areaname, Model model,HttpServletRequest request){
		Department record=new Department();
		record.setDepartname(departname);
		record.setAreaname(areaname);
		baseDataManageService.addbm(record);
		
		 //获取当前页数
        String pageNow=request.getParameter("pageNow");
        //获取总页数
        int totalCount=((Number)baseDataManageService.findNewContDepartment()).intValue();
        Page page=null;
        List<Department> list=new ArrayList<Department>();
        if (pageNow!=null) {
            page=new Page(Integer.parseInt(pageNow), totalCount);
            list=this.baseDataManageService.findNewsPageDepartment(page.getStartPos(),page.getPageSize());
        }else {
            page=new Page(1, totalCount);
            list=this.baseDataManageService.findNewsPageDepartment(page.getStartPos(),page.getPageSize());
        }
        model.addAttribute("listDepartment", list);
        model.addAttribute("page", page);
		//List<Department> listdepartment=baseDataManageService.selectAllDepartment();
		//request.setAttribute("listDepartment", listdepartment);
		return "bmxinxi";
	}
	//资产录入功能
	@RequestMapping("/zc/add.do")
	public String addzc(String zcname,Double zcnumber,BigDecimal price,Integer cid,Integer departid, HttpServletRequest request){
		Balance balance=new Balance();
		//balance.setBcount(bcount);在这里加一个bid
		Date day=new Date();    
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		balance.setBcount(zcnumber);
		balance.setBdate(day);
		balance.setBname(zcname);
		balance.setCid(cid);
		balance.setCname(baseDataManageService.selectByCid(cid).getCname());
		balance.setDepartid(departid);
		balance.setPrice(price);
		baseDataManageService.addzc(balance);
		return "addzc";
	}
	//区域管理
	@RequestMapping("/area/list.do")
	public String areafindAll(Model model,HttpServletRequest request){
		 //获取当前页数
        String pageNow=request.getParameter("pageNow");
        //获取总页数
        int totalCount=((Number)baseDataManageService.findNewCont()).intValue();
        Page page=null;
        List<Area> list=new ArrayList<Area>();
        if (pageNow!=null) {
            page=new Page(Integer.parseInt(pageNow), totalCount);
            list=this.baseDataManageService.findNewsPage(page.getStartPos(),page.getPageSize());
        }else {
            page=new Page(1, totalCount);
            list=this.baseDataManageService.findNewsPage(page.getStartPos(),page.getPageSize());
        }
        model.addAttribute("list", list);
        model.addAttribute("page", page);
        //return "news.jsp";
        //request.setAttribute("list", list);
        //request.setAttribute("page", page);
		
		
		List<Area> listdepartment=baseDataManageService.selectAllArea();
		request.setAttribute("areaList", listdepartment);
		return "quyuxinxi";
	}
	//在浏览中通过URL调用这个方法进行登录:findById.do
	@RequestMapping("/area/findById.do")
	public String findByAreaid(@RequestParam("areaid") Integer areaid,HttpServletRequest request){
		Area area=baseDataManageService.selectByAreaid(areaid);
		request.setAttribute("area", area);
		return "updatequyu";
	}
	//在浏览中通过URL调用这个方法进行登录:findByIdchakan.do
	@RequestMapping("/area/findByIdchakan.do")
	public String findByAreaidchakan(@RequestParam("areaid") Integer areaid,HttpServletRequest request){
		Area area=baseDataManageService.findByAreaidchakan(areaid);
		request.setAttribute("area", area);
		return "quyudetails";
	}
	//在浏览中通过URL调用这个方法进行登录:update.do
	@RequestMapping("/area/update.do")
	public String updatearea(Integer areaid,String areaname,HttpServletRequest request){
		Area record=baseDataManageService.selectByAreaid(areaid);
		record.setAreaname(areaname);
		baseDataManageService.updatearea(record);
		request.setAttribute("area", record);
		return "quyudetails";
	}
	//在浏览中通过URL调用这个方法进行登录:delete.do
	@RequestMapping("/area/delete.do")
	public String deletearea(@RequestParam("areaid") String areaid,Model model, HttpServletRequest request){
		//baseDataManageService.deletezcfl(cid);
		String[] sourcestrStrings=areaid.split(":");
		int[] sourceint=new int[sourcestrStrings.length];
		for (int i = 0; i < sourcestrStrings.length; i++) {
			sourceint[i]=Integer.parseInt(sourcestrStrings[i]);
			baseDataManageService.deletearea(sourceint[i]);
		}
		 //获取当前页数
        String pageNow=request.getParameter("pageNow");
        //获取总页数
        int totalCount=((Number)baseDataManageService.findNewCont()).intValue();
        Page page=null;
        List<Area> list=new ArrayList<Area>();
        if (pageNow!=null) {
            page=new Page(Integer.parseInt(pageNow), totalCount);
            list=this.baseDataManageService.findNewsPage(page.getStartPos(),page.getPageSize());
        }else {
            page=new Page(1, totalCount);
            list=this.baseDataManageService.findNewsPage(page.getStartPos(),page.getPageSize());
        }
        model.addAttribute("areaList", list);
        model.addAttribute("page", page);
		//List<Area> listdepartment=baseDataManageService.selectAllArea();
		//request.setAttribute("areaList", listdepartment);
		return "quyuxinxi";
	}
	//在浏览中通过URL调用这个方法进行登录:add.do
	@RequestMapping("/area/add.do")
	public String addarea(String areaname,Integer relative,Integer areaid, Model model,HttpServletRequest request){
		Area record=new Area();
		record.setAreaid(areaid);
		record.setAreaname(areaname);
		record.setRelative(relative);
		baseDataManageService.addarea(record);
		 //获取当前页数
        String pageNow=request.getParameter("pageNow");
        //获取总页数
        int totalCount=((Number)baseDataManageService.findNewCont()).intValue();
        Page page=null;
        List<Area> list=new ArrayList<Area>();
        if (pageNow!=null) {
            page=new Page(Integer.parseInt(pageNow), totalCount);
            list=this.baseDataManageService.findNewsPage(page.getStartPos(),page.getPageSize());
        }else {
            page=new Page(1, totalCount);
            list=this.baseDataManageService.findNewsPage(page.getStartPos(),page.getPageSize());
        }
        model.addAttribute("areaList", list);
        model.addAttribute("page", page);
		//List<Area> listdepartment=baseDataManageService.selectAllArea();
		//request.setAttribute("areaList", listdepartment);
		return "quyuxinxi";
	}
	//在浏览中通过URL调用这个方法进行登录:findBymh.do
	@RequestMapping("/area/findBymh.do")
	public String findByAreaidmh(@RequestParam("zha") Integer areaid,HttpServletRequest request){
		Area department=baseDataManageService.selectByAreaid(areaid);
		List<Object> list = new ArrayList<Object>();
		list.add(department);
		request.setAttribute("areaList", list);
		return "quyuxinxi";
	}
	
}
