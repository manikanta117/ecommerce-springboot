package com.eco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eco.model.Category;
import com.eco.service.CategeoryService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private CategeoryService service;
	
    @GetMapping("/")
	public String index() {
		return "admin/index";
	}
    
    @GetMapping("/loadAddProduct")
	public String loadAddProduct() {
		return "admin/add_product";
	}
    
    @GetMapping("/category")
	public String category() {
		return "admin/categoery";
	}
    
    @PostMapping("/")  
    public String saveCategory(@ModelAttribute Category category,HttpSession session) {
    	 Boolean exitCategory=service.existCategory(category.getName());
    	if(exitCategory) {
    		session.setAttribute("error", "Category Name already existed");
    	}else {
    	Category savecategory = service.saveCategeory(category);
    	
    	//savecategory==null
    	if(ObjectUtils.isEmpty(savecategory)) {
    		session.setAttribute("erro", "Internal Server Error");
    	}
    	else {
    		session.setAttribute("Success", "saveSucessFully");
    	}
    	}
    	
    	//service.saveCategeory(category);
    	return "redirect:/category";
	}
}
