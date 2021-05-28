package com.student.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class DataDrivenTest {

	@DataProvider
public static Object[][] dataProviderAdd(){
	return new Object[][] {
		
		{0,1},
		{1,2},
		{3,4}
	};
	
}

@UseDataProvider("dataProviderAdd")
@Test
public void add2nums(int num1,int num2) {
	System.out.print("Sum is: ");
	System.out.println(num1 + num2);
}








}
