package booklist.madang.main;

import java.sql.*;
import java.util.ArrayList;

public class BookList {

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	String url = "jdbc:oracle:thin:@localhost:1521:jaewui";
	Connection con;
	int bookid;
	String bookname; 
	String publisher; 
	int price ;
	ArrayList<BookList> list = new ArrayList();
	
	public BookList() {}
	
	public BookList(int bookid, String bookname, String publisher, int price) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.publisher = publisher;
		this.price = price;
	}

	private void sqlRun() {
		String sql = "select * from book";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "madang", "madang");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int bookid = rs.getInt("bookid");
				String bookname = rs.getString("bookname");
				String publisher = rs.getString("publisher");
				int price = rs.getInt("price");
				list.add(new BookList(bookid, bookname, publisher, price));
			}
			
			System.out.println("BOOKNO      BOOKNAME     PUBLISHER     PRICE");
			System.out.println("--------------------------------------------");
			for(BookList b : list) {
				System.out.println(b.getBookid()+"      "+
								b.getBookname()+"        "+
								b.getPublisher()+"           "+
								b.getPrice()
						);
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver 연결이 실패했습니다.");
		} catch (SQLException e) {
			System.out.println("오류가 발생했습니다.");
		}
		
		
		
	}
	
	public static void main(String[] args) {
		
		BookList b = new BookList();
		b.sqlRun();
		
	}

}
