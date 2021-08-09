package p01.mvc.service;

import java.util.Vector;

import p01.mvc.dto.Product;

public interface Service {
	
	void addProduct();
	void editProduct();
	void delProduct();
	Product getProduct();
	Vector<Product> getProducts();
	
}
