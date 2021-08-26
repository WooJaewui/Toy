package p01.mvc.controller;

import java.util.*;
import p01.mvc.dto.Product;
import p01.mvc.service.Service;
import p01.mvc.service.ServiceImpl;

public class ProductMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int menu;
		Service service = new ServiceImpl();
		Product p = null;
		Vector<Product> v = null;
		
		while(flag) {
			System.out.println("1.제품등록 / 2.제품검색 / 3.전체검색 / 4.수정 / 5.삭제 / 6.종료");
			menu = sc.nextInt();
			sc.nextLine();
			if(menu == 1) {
				System.out.println("제품이름 : ");
				String name = sc.nextLine();
				System.out.println("제품가격 : ");
				String price = sc.nextLine();
				service.addProduct(name, price);
			} else if(menu == 2) {
				System.out.println("검색할 제품번호 : ");
				int id = sc.nextInt();
				sc.nextLine();
				p = service.getProduct(id);
				System.out.println(
						"ID : "+p.getID()+
						", name : "+p.getName()+
						", price : "+p.getPrice());
			} else if(menu == 3) {
				System.out.println("oracle selectAll");
				v = service.getProducts();
				for(Product o:v) {
					System.out.println(
							"ID : "+o.getID()+
							", name : "+o.getName()+
							", price : "+o.getPrice());
				}
				
			} else if(menu == 4) {
				System.out.println("수정할 제품번호 : ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("새 제품이름 : ");
				String name = sc.nextLine();
				System.out.println("새 제품가격 : ");
				String price = sc.nextLine();
				p = new Product(id, name, price);
				service.editProduct(p);
			} else if(menu == 5) {
				System.out.println("삭제할 제품 번호 : ");
				int id = sc.nextInt();
				sc.nextLine();
				service.delProduct(id);
			} else if(menu == 6) {
				System.out.println("종료되었습니다.");
				break;
			} else {
				System.out.println("오류발생.");
			}
			
		}
		
		sc.close();
	}

}
