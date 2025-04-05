package com.yeems214.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.yeems214.bean.UserRegister;

public class UserRegisterDao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/communityportal", "root", "roelfrancis100");
		} catch (Exception e) {
			System.out.println("An Error Occured!");
			System.out.println(e);
		}
		return con;
	}
public static int save(UserRegister u) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO user (FirstName, LastName, UserName, pronouns, country, email, `password`) VALUES(?,?,?,?,?,?,?)");
			ps.setString(1,u.getFirstName());
			ps.setString(2,u.getLastName());
			ps.setString(3,u.getUserName());
			ps.setString(4,u.getPronouns());
			ps.setString(5,u.getCountry());
			ps.setString(6,u.getEmail());
			ps.setString(7,u.getPassword());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("An Error Occured!");
			System.out.println(e);
		} return status;
	}
}
