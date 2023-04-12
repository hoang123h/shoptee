package com.shoptee.shoptee.controller;

import com.shoptee.shoptee.entity.Category;
import com.shoptee.shoptee.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public String listCategory(Model model) {
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        return "category/category";
    }

    @GetMapping("/category/add")
    public String newCategoryForm(Model model){
        model.addAttribute("category", new Category());
        return "category/category_add";
    }

    @PostMapping("/category")
    public String createCategory(@ModelAttribute("category") Category category){
        categoryService.createCategory(category);
        return "redirect:/category";
    }

    @GetMapping("/category/edit/{id}")
    public String showEditCategoryForm(@PathVariable("id") Integer id, Model model) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "category/category_edit";
    }

    @PostMapping("/category/update/{id}")
    public String updateCategory(@PathVariable Integer id, @ModelAttribute("category") Category category) {
        category.setId(id);
        categoryService.updateCategory(id, category);
        return "redirect:/category";
    }


    @GetMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable("id") Integer id) {
        categoryService.deleteById(id);
        return "redirect:/category";
    }
}
