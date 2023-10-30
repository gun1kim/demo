package com.example.demo.viewcontroller;

import com.example.demo.model.Product;
import com.example.demo.model.Student;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewController {

    private final ProductService productService;

    public ViewController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/text")
    public String method1(Model model) {
        model.addAttribute("data", "Hello, World!");
        return "text";
    }

    @GetMapping("/object")
    public String method2(Model model) {
        Student student = new Student();
        student.setStudentId(1);
        student.setName("tester");
        student.setMajor("CE");
        student.setPoint(4.0F);
        model.addAttribute("student", student);
        return "object";
    }

    @GetMapping("/link")
    public String method3(Model model) {
        model.addAttribute("param1", 3);
        model.addAttribute("param2", 5);
        return "link";
    }

    @GetMapping("/param")
    public String method4(@RequestParam Integer param1, @RequestParam Integer param2, Model model) {
        model.addAttribute("result", param1 + param2);
        return "param";
    }

    @GetMapping("/param/{param1}/{param2}")
    public String method5(@PathVariable Integer param1, @PathVariable Integer param2, Model model) {
        model.addAttribute("result", param1 + param2);
        return "param";
    }

    @GetMapping("/param/{param1}")
    public String method6(@PathVariable Integer param1, @RequestParam Integer param2, Model model) {
        model.addAttribute("result", param1 + param2);
        return "param";
    }

    @GetMapping("/student")
    public String method7() {

        return "studentForm";
    }

    @PostMapping("/student")
    @ResponseBody
    public Student method8(@ModelAttribute Student student) {

        return student;
    }

    @GetMapping("/products")
    public String products(Model model) {
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("products", allProducts);
        return "products";
    }
}
