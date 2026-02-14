package com.eco.service;

import java.util.List;

import com.eco.model.Category;

public interface CategeoryService {
 
	
	public Category saveCategeory(Category category);
	
	public Boolean existCategory(String name);
	
	public List<Category> getAll();
}
