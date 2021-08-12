package main;

import java.sql.*;

public class ProcedureTest {
	
	private String url = "jdbc:oracle:thin:@localhost:1521:jaewui";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	public void insert() {
		
		String sql = "insert into member2 values(? ,? ,? ,? ,? ,?)";
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,"java","java");
			System.out.println("Connection Success!");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, "Alpha");
			st.setString(2, "1234");
			st.setString(3, "AI");
			st.setInt(4, 20);
			st.setString(5, "LA");
			st.setString(6, "go@ai.com");
			
			st.executeUpdate();
			
			st.close();
			con.close();
			System.out.println("insert success!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver 오류 발생.");
		} catch (SQLException e) {
			System.out.println("오류 발생.");
		}
		
	}
	
	public void select() {
		
		String sql = "select * from member2";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,"java","java");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(
						"아이디 : "+rs.getString(1)+
						", 비밀번호 : "+rs.getString(2)+
						", 이름 : "+rs.getString(3)+
						", 나이 : "+rs.getInt(4)+
						", 주소 : "+rs.getString(5)+
						", 이메일 : "+rs.getString(6)
						);
			}
			System.out.println("1111");
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver 오류 발생.");
		} catch (SQLException e) {
			System.out.println("오류 발생.");
		}
		
	}
	
	public void insertMember() {
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,"java","java");
			CallableStatement cs = 
					con.prepareCall("{call Insert_member2(?,?,?,?,?,?)}");
			
			cs.setString(1, "procedure");
			cs.setString(2, "1234");
			cs.setString(3, "홍길동");
			cs.setInt(4, 19);
			cs.setString(5, "강원도");
			cs.setString(6, "hong@abc.com");
			
			cs.execute();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver 오류 발생.");
		} catch (SQLException e) {
			System.out.println("오류 발생.");
		}
		
	}
	
	public static void main(String[] args) {
		
		ProcedureTest p = new ProcedureTest();
		System.out.println("-------- 프로시저 호출 전 데이터 --------");
		p.insert();
		p.select();
		System.out.println("-------- 프로시저 호출 후 데이터 --------");
		p.insertMember();
		p.select();
	}
}
