package com.spark.lms.controller;

import com.spark.lms.model.Category;
import com.spark.lms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LoginController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/login")
	public String loginPage(Model model) {
		// Lấy danh sách danh mục
		List<Category> categories = categoryService.getAll();

		// Lấy sách theo từng danh mục
		for (Category category : categories) {
			category.setBooks(categoryService.getByCategory(category)); // Assuming you have a method in service to get books by category
		}

		model.addAttribute("categories", categories);

		// Trả về view login
		return "login";
	}
}