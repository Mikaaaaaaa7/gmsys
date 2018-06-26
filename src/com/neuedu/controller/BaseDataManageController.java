package com.neuedu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.model.Category;
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
	public String findAll(HttpServletRequest request){
		List<Category> listcategory=baseDataManageService.selectAll();
		request.setAttribute("listCategory", listcategory);
		//session.setAttribute("listCategory", listcategory);
		
		return "zcflxinxi";
	}
	///category/findBymh.do?zha="+params
}
