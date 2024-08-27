package com.spark.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spark.lms.service.MemberService;
import com.spark.lms.service.BookService;
import com.spark.lms.service.CategoryService;

@Controller
public class DashboardController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("totalMembers", memberService.getTotalCount());
        model.addAttribute("totalParents", memberService.getParentsCount());
        model.addAttribute("totalStudents", memberService.getStudentsCount());
        model.addAttribute("totalBooks", bookService.getTotalCount());
        model.addAttribute("totalIssuedBooks", bookService.getTotalIssuedBooks());
        model.addAttribute("totalCategories", categoryService.getTotalCount());

        // Additional statistics (if needed)
        model.addAttribute("memberStats", memberService.getAll());
        model.addAttribute("bookCategoryStats", bookService.getAll());

        return "dashboard";
    }

}