package p01.mvc.dao;

import java.sql.*;
import java.util.Vector;
import p01.mvc.dto.Product;

public class OracleDao implements Dao{
	
	String url = "jdbc:oracle:thin:@localhost:1521:jaewui";
	
	@Override
	public void insert(Product p) {
		
	    String sql = "insert into product values(PRODUCT_PK.nextval,?,?)";
	    
	    try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"product","product");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, p.getName());
			st.setString(2, p.getPrice());
			st.executeUpdate();
			
			st.close();
			con.close();
			
	    } catch (ClassNotFoundException e) {
			System.out.println("Driver가 연결되지 않았습니다.");
		} catch (SQLException e) {
			System.out.println("오류가 발생했습니다.");
		}
	
	}
	
	@Override
	public Product select(int num) {
		
	    String sql = "select * from product where id="+num;
	    int id = 0;
		String name = null;
		String price = null;
		Product p = null;
		
	    try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"product","product");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				id = rs.getInt("id");
				name = rs.getString("name");
				price = rs.getString("price");	

			}
			
			p = new Product(id, name, price);
			
			rs.close();
			st.close();
			con.close();
			
	    } catch (ClassNotFoundException e) {
			System.out.println("Driver가 연결되지 않았습니다.");
		} catch (SQLException e) {
			System.out.println("오류가 발생했습니다.");
		}
	    
		return p;
	}
	
	@Override
	public Vector<Product> selectAll() {
	    String sql = "select * from product";
	    int id = 0;
		String name = null;
		String price = null;
		Vector<Product> v = new Vector<>();
		
	    try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"product","product");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				id = rs.getInt(1);
				name = rs.getString(2);
				price = rs.getString(3);
				v.add(new Product(id, name, price));
			}
			
			rs.close();
			st.close();
			con.close();
			
	    } catch (ClassNotFoundException e) {
			System.out.println("Driver가 연결되지 않았습니다.");
		} catch (SQLException e) {
			System.out.println("오류가 발생했습니다.");
		}
		
		return v;
	}
	
	@Override
	public void update(int num, Product p) {
		
	    String sql = "update product set name= ?, price=? where id="+num;
	    
	    try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"product","product");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, p.getName());
			st.setString(2, p.getPrice());
			st.executeUpdate();
			
			st.close();
			con.close();
			
	    } catch (ClassNotFoundException e) {
			System.out.println("Driver가 연결되지 않았습니다.");
		} catch (SQLException e) {
			System.out.println("오류가 발생했습니다.");
		}
		
	}
	
	@Override
	public void delete(int num) {
		
	    String sql = "delete from product where id="+num;
	    
	    try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"product","product");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.executeUpdate();
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 연결되지 않았습니다.");
		} catch (SQLException e) {
			System.out.println("오류가 발생했습니다.");
		}
	}
}
