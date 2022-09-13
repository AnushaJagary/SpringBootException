package com.exception.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exception.demo.IdNotFoundException;
import com.exception.demo.model.Product;

@RestController

public class Controller {
	private static Map<String, Product> productRepo = new HashMap<>();
	static {
		Product honey =new Product();
		honey.setId("1");
		honey.setName("Honey");
		
		Product mobile=new Product();
		mobile.setId("2");
		mobile.setName("MI");
	}
	
	 @RequestMapping(value = "/products")
	   public ResponseEntity<Object> getProduct() {
	      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
	   }
	
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
		
		if(!productRepo.containsKey(id)) throw new IdNotFoundException();
		 productRepo.remove(id);
	      product.setId(id);
	      productRepo.put(id, product);
		return new  ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
	}

}
