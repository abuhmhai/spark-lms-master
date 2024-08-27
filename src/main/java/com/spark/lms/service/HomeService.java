package com.spark.lms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spark.lms.model.Book;
import com.spark.lms.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

	@Autowired
	private MemberService memberService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private BookService bookService;

	public Map<String, Long> getTopTilesMap() {
		Map<String, Long> map = new HashMap<>();
		map.put("totalMembers", memberService.getTotalCount());
		map.put("totalStudents", memberService.getStudentsCount());
		map.put("totalParents", memberService.getParentsCount());
		map.put("totalCategories", categoryService.getTotalCount());
		map.put("totalBooks", bookService.getTotalCount());
		map.put("totalIssuedBooks", bookService.getTotalIssuedBooks());
		return map;
	}

	public Map<Category, List<Book>> getBooksByCategory() {
		Map<Category, List<Book>> booksByCategory = new HashMap<>();
		List<Category> categories = categoryService.getAll();
		for (Category category : categories) {
			List<Book> books = bookService.getByCategory(category);
			booksByCategory.put(category, books);
		}
		return booksByCategory;
	}
}