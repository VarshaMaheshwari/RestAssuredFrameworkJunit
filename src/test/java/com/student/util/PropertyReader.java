package com.student.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	private static volatile PropertyReader propInstance;

	private PropertyReader() {

	}

	public static synchronized PropertyReader getInstance() {

		if (propInstance == null) {
			propInstance = new PropertyReader();
		}

		return propInstance;
	}

	public static String getProperty(String propertyName) {
 
		Properties prop=new Properties();
		try {
		FileInputStream io = new FileInputStream("application.properties");
//		//C:\Users\varsham\eclipse-workspace\RestAssuredAPIAutomation\src\test\resources\com\student\config\application.properties
	//InputStream io=getClass().getClassLoader().getResourceAsStream("application.properties");
		
			prop.load(io);
		} catch (IOException e) {
			System.out.println("Property file not found");
		}
		
		if(prop.getProperty(propertyName)!=null) {
			return prop.getProperty(propertyName);
		}
		return null;
		
	
		
	}
	
	/*
	 * Properties prop;
	 * 
	 * public String getProperty(String propertyName) { try { prop=new Properties();
	 * FileInputStream io = new FileInputStream(".\\application.properties");
	 * prop.load(io); } catch (FileNotFoundException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return
	 * prop.getProperty(propertyName); }
	 * 
	 * // public String getProperty(String propertyName) { // // TODO Auto-generated
	 * method stub // return prop.getProperty(propertyName); // }
	 */
}
