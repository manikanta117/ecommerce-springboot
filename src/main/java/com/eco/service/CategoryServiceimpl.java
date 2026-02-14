package com.eco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eco.model.Category;
import com.eco.repo.CategoryRepo;

@Service
public class CategoryServiceimpl implements CategeoryService{
 
	@Autowired
	private CategoryRepo repo;
	
	@Override
	public Category saveCategeory(Category category) {
		
		return repo.save(category);
	}

	@Override
	public List<Category> getAll() {
	
		return repo.findAll();
	}

	@Override
	public Boolean existCategory(String name) {
		
		return repo.exitsByName(name);
	}

}
