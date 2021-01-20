package ru.aamsystems.juniortest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.aamsystems.juniortest.model.entity.Product;
import ru.aamsystems.juniortest.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String getProducts(@RequestParam(value = "searchProduct",required = false) String name,ModelMap model){
        if(name==null) {
            List<Product> products = productService.getAllProducts();
            model.addAttribute("listProduct", products);
        }else {
            List<Product> products = productService.getProductByName(name);
            model.addAttribute("listProduct", products);

        }
        return "products";
    }

    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("newProduct") Product p, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "addForm";
        }
        productService.save(p);
        return "redirect:/products";
    }
    @GetMapping("/add")
    public String addProductPage(ModelMap modelMap){
        modelMap.addAttribute("newProduct",new Product());
        return "addForm";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("id") Long id){
        productService.delete(id);
        return "redirect:/products";
    }
    @GetMapping("/edit")
    public String editProduct(@RequestParam("id")Long id,ModelMap modelMap){
        Product p = productService.getProductById(id);
        modelMap.addAttribute("productData",p);
        return "editForm";
    }

    @PostMapping("/edit")
    public String updateProduct(@Valid @ModelAttribute("productData") Product p,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "editForm";
        }
        productService.updateProduct(p);
        return "redirect:/products";
    }



}
