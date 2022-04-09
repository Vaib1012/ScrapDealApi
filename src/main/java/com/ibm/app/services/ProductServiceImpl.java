package com.ibm.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ibm.app.models.Product;
import com.ibm.app.models.Stock;
import com.ibm.app.models.User;
import com.ibm.app.payload.response.ProductResponse;
import com.ibm.app.payload.response.StockResponse;
import com.ibm.app.repository.ProductRepository;
import com.ibm.app.repository.UserRepository;

@Service
public class ProductServiceImpl {
	@Autowired
	ProductRepository productRepository;
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	//returns list of stocks along with the time-stamps in a user's watchlist
	public List<ProductResponse> retrieveAll() {
		List<Product> products = productRepository.findAll();
		List<ProductResponse>  productList= new ArrayList<>();

		for (Product s : products) {
			ProductResponse productResponse=new ProductResponse(s.getProductId(), s.getProductName()
											, s.getAmountPerKg(), s.getProductImgLink());
			productList.add(productResponse);
		}
		return productList;
	}
	
//	//returns list of stocks along with the time-stamps in a user's watchlist
//	public List<ProductResponse> retrieveProductsByType(String type) {
//		Set<Product> products = productRepository.findProductsByType(type);
//		List<ProductResponse>  productList= new ArrayList<>();
//
//		for (Product s : products) {
//			ProductResponse productResponse=new ProductResponse(s.getProductId(), s.getProductName(), s.getAmountPerKg(), s.getProductImgLink());
//			productList.add(productResponse);
//		}
//		return productList;
//	}

}
