package com.npci.Product.Management.System.Service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.npci.Product.Management.System.Entity.Product;
@Service
public interface ProductService {
	
	
	 Product addProduct(Product product);
	    List<Product> getProducts();
	    Map<String, Object> generateBills();
	    public void deleteProduct(String productId);

}
