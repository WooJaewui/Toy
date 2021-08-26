package p01.mvc.controller;

import java.util.*;
import p01.mvc.dto.Product;
import p01.mvc.service.Service;
import p01.mvc.service.ServiceImpl;

public class ProductMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		String menu_ = null;
		int menu = 0;
		Service service = new ServiceImpl();

		while (flag) {
			System.out.println("1.제품등록 / 2.제품검색 / 3.전체검색 / 4.수정 / 5.삭제 / 6.종료");
			menu_ = sc.nextLine();
			boolean result = true;

			for (int i = 0; i < menu_.length(); i++) {
				Character c = menu_.charAt(i);
				result = Character.isDigit(c);
				if (result == false) {
					break;
				}
			}
			
			if (result == true) {
				menu = Integer.parseInt(menu_);
				switch (menu) {
				case 1:
					service.addProduct();
					break;
				case 2:
					service.getProduct();
					break;
				case 3:
					service.getProducts();
					break;
				case 4:
					service.editProduct();
					break;
				case 5:
					service.delProduct();
					break;
				case 6:
					System.out.println("종료합니다.");
					flag = false;
					break;
				default:
					System.out.println("오류 발생.");
					break;
				}
			} else {
				System.out.println("숫자를 입력하세요.");
			}
		}
		sc.close();
	}

}
