package p01.mvc.service;

import java.util.Scanner;
import java.util.Vector;

import p01.mvc.dao.OracleDao;
import p01.mvc.dto.Product;

public class ServiceImpl implements Service {

	OracleDao dao = new OracleDao();
	Product p = null;
	Scanner sc = new Scanner(System.in);
	boolean result = true;
	String id_ = null;
	int id = 0;

	@Override
	public void addProduct() {
		System.out.println("제품 이름 : ");
		String name = sc.next();
		System.out.println("제품 가격 : ");
		String price = sc.next();
		p = new Product(0, name, price);
		dao.insert(p);

	}

	@Override
	public void editProduct() {
		System.out.println("수정한 제품 번호 : ");
		id_ = sc.next();
		
		for (int i = 0; i < id_.length(); i++) {
			char c = id_.charAt(i);
			result = Character.isDigit(c);
			if(result == false) {
				break;
			}
		}
		
		if (result) {
			id = Integer.parseInt(id_);
			p = dao.select(id);
			if(p.getName() == null) {
				System.out.println("변경할 제품이 없습니다.");
			} else {
				System.out.println("새 제품 이름 : ");
				String name = sc.next();
				System.out.println("새 제품 가격 : ");
				String price = sc.next();
				p = new Product(id, name, price);
				dao.update(id, p);
			}
		} else {
			System.out.println("숫자를 입력해주세요.");
		}

	}

	@Override
	public void delProduct() {
		System.out.println("삭제할 제품 번호 : ");
		id_ = sc.next();
		for(int i=0; i<id_.length(); i++) {
			char c = id_.charAt(i);
			result = Character.isDigit(c);
			if(result == false) {
				break;
			}
		}
			
		if(result) {
			int id = Integer.parseInt(id_);
			p = dao.select(id);
			if(p.getName() == null) {
				System.out.println("검색한 제품이 없습니다.");
			} else {
				dao.delete(id);			
			}
		} else {
			System.out.println("숫자를 입력해주세요.");
		}
	}
	
	@Override
	public Product getProduct() {
		System.out.println("검색할 제품 번호 :");
		id_ = sc.next();
		for (int i = 0; i < id_.length(); i++) {
			char c = id_.charAt(i);
			p = dao.select(id);
			result = Character.isDigit(c);
			if(result == false) {
				break;
			}
		}
		
		if (result) {
			p = dao.select(id);
			if(p.getName() == null) {
				System.out.println("검색한 제품이 없습니다.");
				return null;
			} else {
				System.out.println("ID : " + p.getID() + 
						", name : " + p.getName() + 
						", price : " + p.getPrice()
						);
				return p;
			}
		} else {
			System.out.println("숫자를 입력하세요.");
			return null;
		}

	}

	@Override
	public Vector<Product> getProducts() {
		Vector<Product> v = dao.selectAll();
		for (Product p : v) {
			System.out.println("ID : " + p.getID() + 
					", name : " + p.getName() + 
					", price : " + p.getPrice()
					);
		}
		return v;
	}

}
