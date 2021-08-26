package p01.mvc.service;

import java.util.Vector;

import p01.mvc.dto.Product;

public interface Service {
	
	void addProduct(String name, String price);
	void editProduct(Product p);
	void delProduct(int id);
	Product getProduct(int id);
	Vector<Product> getProducts();
	
}
