package p01.mvc.service;

import java.util.Vector;

import p01.mvc.dao.OracleDao;
import p01.mvc.dto.Product;

public class ServiceImpl implements Service{

	OracleDao dao = new OracleDao();
	Product p = null;
	
	@Override
	public void addProduct(String name, String price) {
		p = new Product(0, name, price);
		dao.insert(p);	
	}
	
	@Override
	public void editProduct(Product p) {
		dao.update(p.getID(), p);
	}
	
	@Override
	public void delProduct(int id) {
		dao.delete(id);
	}
	
	@Override
	public Product getProduct(int id) {
		p = dao.select(id);
		return p;
	}
	
	@Override
	public Vector<Product> getProducts() {
		
		Vector<Product> v = dao.selectAll();
		return v;
	}
	
}
