package com.yeems214.assignment3;

import java.util.Arrays;

public class Store {
	
	String name;
	String phone_number;
	String[] localities;
	
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return phone_number
	 */
	public String getPhone_number() {
		return phone_number;
	}
	
	/**
	 * @param phone_number 
	 */
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	/**
	 * @return localities
	 */
	public String[] getLocalities() {
		return localities;
	}
	
	/**
	 * @param localities to set
	 */
	public void setLocalities(String[] localities) {
		this.localities = localities;
	}
	
	/**
	 * @param name
	 * @param phone_number
	 * @param localities
	 */
	public Store(String name, String phone_number, String[] localities) {
		this.name = name;
		this.phone_number = phone_number;
		this.localities = localities;
	}
	
	public Store() {
	}
	@Override
	public String toString() {
		return "Store [name=" + name + ", phone_number=" + phone_number + ", localities=" + Arrays.toString(localities)
				+ "]";
	}
}
