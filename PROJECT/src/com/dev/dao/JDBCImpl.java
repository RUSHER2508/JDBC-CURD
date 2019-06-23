package com.dev.dao;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dev.beans.User;

public class JDBCImpl implements JDBC {

	public JDBCImpl() {

	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	String url="jdbc:mysql://localhost:3306/caps_mumbai?user=root&password=root";


	@Override
	public boolean createProfile(User user) {


		String query="INSERT INTO USER_INFO  VALUES(?,?,?,?)";
		try(Connection conn =DriverManager.getConnection(url);PreparedStatement pstmt =conn.prepareStatement(query)){
		
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			int i =pstmt.executeUpdate();
			if(i>0) {
				System.out.println("Data inserted");
				return true;
			}
			else {
				System.out.println("Something went wrong");

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;		
		
	}


	@Override
	public User showProfile() {

		String query="SELECT * FROM USER_INFO";
		try(Connection conn=DriverManager.getConnection(url);Statement stmt=conn.createStatement();ResultSet rs=stmt.executeQuery(query)){
		
			while(rs.next()) {
				int userid=rs.getInt(1);
				String username=rs.getString(2);
				String email=rs.getString(3);
				String password=rs.getString(4);
				User user=new User();
				user.setId(userid);
				user.setUsername(username);
				user.setEmail(email);
				user.setPassword(password);
				System.out.println(user.toString());
			}
			
		}
	catch(Exception e) {
		e.printStackTrace();
	}
		return null;

	}


	@Override
	public boolean updateProfile(User user) {


		String query="UPDATE USER_INFO SET USERNAME=? WHERE USER_ID=? AND PASSWORD=?";
		try(Connection conn=DriverManager.getConnection(url);PreparedStatement pstmt=conn.prepareStatement(query)){
			pstmt.setString(1, user.getUsername());
			pstmt.setInt(2,user.getId());
			pstmt.setString(3, user.getPassword());
			int i=pstmt.executeUpdate();
			if(i>0) {
				System.out.println("Updated Successfully");
				return true;
			}
			else {
				System.out.println("Something went wrong");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean deleteProfile(User user) {

		String query="DELETE FROM USER_INFO WHERE USER_ID=? AND PASSWORD=?";
		try(Connection conn=DriverManager.getConnection(url);PreparedStatement pstmt=conn.prepareStatement(query)){
			pstmt.setInt(1, user.getId());
			pstmt.setString(2,user.getPassword());
			int i=pstmt.executeUpdate();
			if(i>0) {
				System.out.println("Deleted Successfully");
				return true;
			}
			else {
				System.out.println("Something went wrong");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	}
