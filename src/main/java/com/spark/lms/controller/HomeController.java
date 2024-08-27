package com.spark.lms.controller;

import com.spark.lms.model.Book;
import com.spark.lms.model.Category;
import com.spark.lms.service.BookService;
import com.spark.lms.service.CategoryService;
import com.spark.lms.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	CategoryService categoryService;

	@Autowired
	BookService bookService;

	@Autowired
	HomeService homeService;
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String homePage(Model model) {
		model.addAttribute("topTiles", homeService.getTopTilesMap());
		List<Category> categories = categoryService.getAll();
		model.addAttribute("categories", categories);

		// Tạo một Map để lưu danh sách sách theo danh mục
		Map<Category, List<Book>> booksByCategory = new HashMap<>();

		// Lặp qua từng danh mục để lấy sách theo danh mục
		for (Category category : categories) {
			List<Book> books = bookService.getByCategory(category);
			booksByCategory.put(category, books);
		}

		model.addAttribute("booksByCategory", booksByCategory);

		return "home";
	}
}