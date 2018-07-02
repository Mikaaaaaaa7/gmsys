package com.neuedu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neuedu.model.Product;
import com.neuedu.model.Provider;
import com.neuedu.service.SupplierService;

//配置mvc的控制器类
@Controller
public class SupplierController {

	// 在mvc的控制层整合service服务层
	@Autowired
	private SupplierService supplierService;

	/**
	 * 获取供应商记录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/provider/findAll")
	public String findAllProvider(HttpServletRequest request) {

		List<Provider> listProvider = supplierService.selectAll();
		request.setAttribute("listProvider", listProvider);

		return "gysxinxi";
	}

	/**
	 * 根据id查询供应商记录
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/provider/findById")
	public String findById(@RequestParam("id") Integer id, HttpServletRequest request) {
		if (id != null) {
			Provider query = supplierService.findById(id);
			request.setAttribute("query", query);
		} else {
			List<Provider> listProvider = supplierService.selectAll();
			request.setAttribute("listProvider", listProvider);
		}
		return "gysxinxi";
	}

	/**
	 * 删除供应商记录
	 * 
	 * @param buyidString
	 * @param request
	 * @return
	 */
	@RequestMapping("/provider/delete")
	public String delete(@RequestParam("number") String buyidString, HttpServletRequest request) {
		String[] sourcestrStrings = buyidString.split("-");
		int[] sourceint = new int[sourcestrStrings.length];
		for (int i = 0; i < sourcestrStrings.length; i++) {
			sourceint[i] = Integer.parseInt(sourcestrStrings[i]);
			supplierService.deleteById(sourceint[i]);
		}
		List<Provider> listProvider = supplierService.selectAll();
		request.setAttribute("listProvider", listProvider);
		return "gysxinxi";
	}

	/**
	 * 添加供应商记录
	 * 
	 * @param provname
	 * @param phone
	 * @param address
	 * @param request
	 * @return
	 */
	@RequestMapping("/provider/add")
	public String addProvider(@RequestParam("provname") String provname, @RequestParam("phone") String phone,
			@RequestParam("address") String address, HttpServletRequest request) {
		Provider provider = new Provider();
		provider.setProvname(provname);
		provider.setPhone(phone);
		provider.setAddress(address);
		supplierService.AddProvider(provider);

		List<Provider> listProvider = supplierService.selectAll();
		request.setAttribute("listProvider", listProvider);
		return "gysxinxi";
	}

	/**
	 * 根据id获取供应商信息，跳转到供应商编辑页
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/provider/find2")
	public String findById2(@RequestParam("id") Integer id, HttpServletRequest request) {
		Provider query = supplierService.findById(id);
		request.setAttribute("listProvider", query);
		return "updategys";
	}

	@RequestMapping("/provider/update")
	public String update(@RequestParam("provid") Integer provid, @RequestParam("provname") String provname,
			@RequestParam("phone") String phone, @RequestParam("address") String address, HttpServletRequest request) {
		Provider provider = new Provider();
		provider.setProvid(provid);
		provider.setProvname(provname);
		provider.setPhone(phone);
		provider.setAddress(address);
		supplierService.updateProvider(provider);

		List<Provider> listProvider = supplierService.selectAll();
		request.setAttribute("listProvider", listProvider);
		return "gysxinxi";
	}

	/**
	 * 根据id获取供应商信息，跳转到供应商详情页
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/provider/find")
	public String findById3(@RequestParam("id") Integer id, HttpServletRequest request) {
		Provider query = supplierService.findById(id);
		request.setAttribute("listProvider", query);
		return "gysdetails";
	}

	/**
	 * 获取产品列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/product/findAll")
	public String findAllProduct(HttpServletRequest request) {

		List<Product> listProduct = supplierService.selectAll2();
		request.setAttribute("listProduct", listProduct);

		return "productxinxi";
	}

	/**
	 * 根据id查询产品记录
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/product/findById")
	public String findById4(@RequestParam("id") Integer id, HttpServletRequest request) {
		if (id != null) {
			Product query = supplierService.findById2(id);
			request.setAttribute("query", query);
		} else {
			List<Product> listProduct = supplierService.selectAll2();
			request.setAttribute("listProduct", listProduct);
		}
		return "productxinxi";
	}

	/**
	 * 删除产品
	 * 
	 * @param buyidString
	 * @param request
	 * @return
	 */
	@RequestMapping("/product/delete")
	public String delete2(@RequestParam("number") String buyidString, HttpServletRequest request) {
		String[] sourcestrStrings = buyidString.split("-");
		int[] sourceint = new int[sourcestrStrings.length];
		for (int i = 0; i < sourcestrStrings.length; i++) {
			sourceint[i] = Integer.parseInt(sourcestrStrings[i]);
			supplierService.deleteById2(sourceint[i]);
		}
		List<Product> listProduct = supplierService.selectAll2();
		request.setAttribute("listProduct", listProduct);
		return "productxinxi";
	}

	/**
	 * 根据id获取产品信息，跳转到产品详情页
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/product/findProduct")
	public String findProductById1(@RequestParam("id") Integer id, HttpServletRequest request) {
		Product query = supplierService.findById2(id);
		request.setAttribute("listProduct", query);
		return "productDetail";
	}
}
