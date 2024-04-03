package com.npci.Product.Management.System.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.Product.Management.System.Entity.Product;
import com.npci.Product.Management.System.Service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body("Product added successfully");
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Product>> findAllProducts() {
        List<Product> products = productService.getProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/checkout")
    public ResponseEntity<Map<String, Object>> checkout() {
        Map<String, Object> billDetails = productService.generateBills();
        return ResponseEntity.status(HttpStatus.OK).body(billDetails);
    }
    
    
    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
    }
}
