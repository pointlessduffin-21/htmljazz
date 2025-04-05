package com.Assignment2.bean;

import java.util.ArrayList;

public class User {
	private static String _email;
	private static String _password;
	private static String _firstName;
	private static String _lastName;
	private static String _userName;
	private static String _gender;
	private static int _age;
	private static String _city;
	private static String _country;
	private static String _phoneNumber;
	private static String _title;
	private static String _about;
	private static String _company;
	private static String _website;
	
	private static ArrayList<String[]> _experiences = new ArrayList<String[]>();
	private static ArrayList<String[]> _educations = new ArrayList<String[]>();
	
	public static void setEmail(String email) {
		_email = email;
	}
	
	public static String getEmail() {
		return _email;
	}
	
	public static void setPassword(String password) {
		_password = password;
	}
	
	public static String getPassword() {
		return _password;
	}
	
	public static void setfN(String fN) {
		_firstName = fN;
	}
	
	public static String getFN() {
		return _firstName;
	}
	
	public static void setlN(String lN) {
		_lastName = lN;
	}
	
	public static String getLN() {
		return _lastName;
	}
	
	public static void setuN(String uN) {
		_userName = uN;
	}
	
	public static String getUN() {
		return _userName;
	}
	
	public static void setgN(String gN) {
		_gender = gN;
	}
	
	public static String getGN() {
		return _gender;
	}
	
	public static void setaG(int aG) {
		_age = aG;
	}
	
	public static int getAG() {
		return _age;
	}
	
	public static void setcT(String cT) {
		_city = cT;
	}
	
	public static String getCT() {
		return _city;
	}
	
	public static void setAbout(String about) {
		_about = about;
	}
	
	public static String getAbout() {
		return _about;
	}
	
	public static void setTitle(String title) {
		_title = title;
	}
	
	public static String getTitle() {
		return _title;
	}
	
	public static void setCompany(String company) {
		_company = company;
	}
	
	public static String getCompany() {
		return _company;
	}
	
	public static void setWebsite(String website) {
		_website = website;
	}
	
	public static String getWebsite() {
		return _website;
	}
	
	public static void setExperiences(String ...experience) {
		_experiences.add(experience);
	}
	
	public static ArrayList<String[]> getExperiences() {
		return _experiences;
	}
	
	public static void setEducations(String ...education) {
		_educations.add(education);
	}
	
	public static ArrayList<String[]> getEducations() {
		return _educations;
	}
	
	private static boolean _isLogin = false;
	public static void setIsLogin(boolean isLogin) {
		_isLogin = isLogin;
	}
	
	public static boolean isLogin() {
		return _isLogin;
	}
	
	private static boolean _isReset = false;
	public static void setIsReset(boolean isReset) {
		_isReset = isReset;
	}
	
	public static boolean isReset() {
		return _isReset;
	}
	
}
