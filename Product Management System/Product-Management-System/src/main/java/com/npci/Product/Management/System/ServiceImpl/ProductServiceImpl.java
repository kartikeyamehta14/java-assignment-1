package com.npci.Product.Management.System.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.npci.Product.Management.System.Entity.Product;
import com.npci.Product.Management.System.Service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	
	 private final List<Product> products = new ArrayList<>();

	    @Override
	    public Product addProduct(Product product) {
	        product.setProductId(String.valueOf(products.size() + 1)); // Auto-generated ID
	        products.add(product);
	        return product;
	    }

	    @Override
	    public List<Product> getProducts() {
	        return products;
	    }

	    @Override
	    public Map<String, Object> generateBills() {
	        double totalPrice = 0;
	        for (Product product : products) {
	            totalPrice += product.getPrice() * product.getQuantity();
	        }

	        double cgst = 0.09 * totalPrice;
	        double sgst = 0.09 * totalPrice;
	        double finalTotal = totalPrice + cgst + sgst;

	        Map<String, Object> billDetails = new HashMap<>();
	        billDetails.put("Products", products);
	        billDetails.put("Total Price", totalPrice);
	        billDetails.put("CGST 9%", cgst);
	        billDetails.put("SGST 9%", sgst);
	        billDetails.put("Final Total", finalTotal);

	        return billDetails;
	    }
	    
	    
	    @Override
	    public void deleteProduct(String productId) {
	        Product productToRemove = null;
	        for (Product product : products) {
	            if (product.getProductId().equals(productId)) {
	                productToRemove = product;
	                break;
	            }
	        }
	        if (productToRemove != null) {
	        	products.remove(productToRemove);
	        }
	    }


}
