package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectionManager.ConnectionManager;
import model.Employee;


public class EmployeeDAO {
	public void addEmployee(Employee emp) throws ClassNotFoundException, SQLException {
		int id=emp.getID();
		String username= emp.getUSERNAME();
		String password=emp.getPASSWORD();
		String fullname=emp.getFULLNAME();
		String email=emp.getEMAIL();
		long mobileno=emp.getMOBILE_NUMBER();
		
		ConnectionManager conn = new ConnectionManager();
		Connection con = conn.establishConnection();
		
		String query ="insert into EMPLOYEE(ID,USERNAME,PASSWORD,FULLNAME,EMAIL,MOBILE_NUMBER)values(?,?,?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, id);
		ps.setString(2, username);
		ps.setString(3, password);
		ps.setString(4, fullname);
		ps.setString(5, email);
		ps.setLong(6, mobileno);
		
		ps.executeUpdate();
		conn.closeConnection();
		
	}
	
	public void displayEmployeeDetails() throws ClassNotFoundException, SQLException {
		ConnectionManager conn=new ConnectionManager();
		Connection con=conn.establishConnection();
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM EMPLOYEE");
		
		while(rs.next()) {
			System.out.println("-----------------------------------------------------------------");
			System.out.println(rs.getInt("ID")+" | "+rs.getString("USERNAME")+" | "+rs.getString("PASSWORD")+" | "+rs.getString("FULLNAME")+" | "+rs.getString("EMAIL")+" | "+rs.getLong("MOBILE_NUMBER")+"|");
			System.out.println("-----------------------------------------------------------------");
		}
		conn.closeConnection();
	}

	public void selectUser(Employee emp) throws SQLException, ClassNotFoundException {
		
		String username=emp.getUSERNAME();
		
		
		ConnectionManager conn=new ConnectionManager();
		Connection con=conn.establishConnection();
		
		String query="SELECT * FROM EMPLOYEE WHERE USERNAME = '"+username+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println("-----------------------------------------------------------------");
			System.out.println(rs.getInt("ID")+" | "+rs.getString("USERNAME")+" | "+rs.getString("PASSWORD")+" | "+rs.getString("FULLNAME")+" | "+rs.getString("EMAIL")+" | "+rs.getLong("MOBILE_NUMBER")+"|");
			System.out.println("-----------------------------------------------------------------");
		}
		conn.closeConnection();
		
	}
	

	public void updateEmail(int id, String new_email) throws ClassNotFoundException, SQLException {
		
		
		ConnectionManager conn=new ConnectionManager();
		Connection con=conn.establishConnection();
		
		
		String query="UPDATE EMPLOYEE SET EMAIL='"+new_email+"' WHERE ID = '"+id+"'";
		
		Statement st=con.createStatement();
		st.executeUpdate(query);
		conn.closeConnection();
		
		
	}

	public void deleteEmployee(int id) throws ClassNotFoundException, SQLException {
		ConnectionManager conn=new ConnectionManager();
		Connection con=conn.establishConnection();
		
		
		String query="DELETE FROM EMPLOYEE WHERE ID = '"+id+"'";
		
		Statement st=con.createStatement();
		st.executeUpdate(query);
		conn.closeConnection();
		
		
	}

	public void updateMobileNumber(int id, long new_number) throws ClassNotFoundException, SQLException {
		
		ConnectionManager conn=new ConnectionManager();
		Connection con=conn.establishConnection();
		
		
		String query="UPDATE EMPLOYEE SET MOBILE_NUMBER='"+new_number+"' WHERE ID = '"+id+"'";
		
		Statement st=con.createStatement();
		st.executeUpdate(query);
		conn.closeConnection();
		
		
		
	}

}
