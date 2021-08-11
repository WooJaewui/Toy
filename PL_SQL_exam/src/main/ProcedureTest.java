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
			
		} catch (SQLException e) {
			
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
						"���̵� : "+rs.getString(1)+
						", ��й�ȣ : "+rs.getString(2)+
						", �̸� : "+rs.getString(3)+
						", ���� : "+rs.getInt(4)+
						", �ּ� : "+rs.getString(5)+
						", �̸��� : "+rs.getString(6)
						);
			}
			System.out.println("1111");
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			cs.setString(3, "ȫ�浿");
			cs.setInt(4, 19);
			cs.setString(5, "������");
			cs.setString(6, "hong@abc.com");
			
			cs.execute();
			
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		ProcedureTest p = new ProcedureTest();
		System.out.println("-------- ���ν��� ȣ�� �� ������ --------");
		p.insert();
		p.select();
		System.out.println("-------- ���ν��� ȣ�� �� ������ --------");
		p.insertMember();
		p.select();
	}

}
