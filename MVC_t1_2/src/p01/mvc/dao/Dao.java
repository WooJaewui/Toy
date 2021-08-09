package p01.mvc.dao;

import java.util.Vector;

import p01.mvc.dto.Product;

public interface Dao {
	void insert(Product P);
	Product select(int num);
	Vector<Product> selectAll();
	void update(int num, Product p);
	void delete(int num);
}
