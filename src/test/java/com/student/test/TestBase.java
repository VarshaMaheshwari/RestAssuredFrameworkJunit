package com.student.test;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.student.util.PropertyReader;

import io.restassured.RestAssured;

public class TestBase {

	@Rule
	public TestRule listener = new TestWatcher() {
		@Override
		protected void succeeded(Description description) {
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(description.getMethodName().toUpperCase());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}

		@Override
		protected void failed(Throwable e, Description description) {

			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Test Failed: " + description.getMethodName().toUpperCase());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}
		@Override
		protected void starting( Description description) {

			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Test started: " + description.getMethodName().toUpperCase());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}
		
		@Override
		protected void finished( Description description) {

			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Test finished: " + description.getMethodName().toUpperCase());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}

	};

	public static PropertyReader prop;

	@BeforeClass
	public static void initUrl() {
		prop = PropertyReader.getInstance();
		RestAssured.baseURI = prop.getProperty("baseURI");
		System.out.println("base uri" + RestAssured.baseURI);
		RestAssured.port = Integer.valueOf(prop.getProperty("port"));
	}

}
