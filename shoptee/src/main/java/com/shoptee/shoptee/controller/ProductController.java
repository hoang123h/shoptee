package com.shoptee.shoptee.controller;

import com.shoptee.shoptee.entity.Product;
import com.shoptee.shoptee.service.CategoryService;
import com.shoptee.shoptee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("product")
    public String listProduct(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products",products);
        return "product/product";
    }

    @GetMapping("/product/add")
    public String newProductForm(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "product/product_add";
    }


    @PostMapping("/product")
    public String addProduct(@ModelAttribute("product") Product product, @RequestParam("createDate") String createDate) {
        LocalDate localDate = LocalDate.parse(createDate);
        product.setCreateDate(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        productService.createProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/product/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategory());
        return "product/product_edit";
    }

    @PostMapping("product/updateProduct/{id:[0-9]+}")
    public String updateProduct(@PathVariable("id") int id, @ModelAttribute("product") Product product) {
        product.setId(id);
        productService.updateProduct(product);
        return "redirect:/product";
    }


    @GetMapping("/product/delete/{id}")
    public String deleteCategory(@PathVariable("id") Integer id) {
        productService.deleteById(id);
        return "redirect:/product";
    }

}
