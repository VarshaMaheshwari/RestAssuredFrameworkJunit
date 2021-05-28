package com.student.specs;

import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

import com.student.util.PropertyReader;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationFactory {

	public static  PropertyReader prop;
	public static synchronized ResponseSpecification genericResponse() {
		
		ResponseSpecBuilder responseSpecBuilder=new ResponseSpecBuilder();
		ResponseSpecification reqSpec;
		
		responseSpecBuilder.expectHeader("Content-Type","application/json;charset=UTF-8");
		responseSpecBuilder.expectHeader("Transfer-Encoding", "chunked");
		responseSpecBuilder.expectResponseTime(lessThan(5L),TimeUnit.SECONDS);
		
		reqSpec=responseSpecBuilder.build();
		
		return reqSpec;
		
	}
	
	
	public static synchronized RequestSpecification logPayloadResponseInfo() {
		
		RequestSpecBuilder logBuilder;
		RequestSpecification logSpec;
		logBuilder=new RequestSpecBuilder();
		
		if(prop.getProperty("log").equals("ENABLE")) {
			logBuilder.addFilter(new AllureRestAssured());
		}
		
		logSpec=logBuilder.build();
		return logSpec;
		
	}
	
	
	
	
	
	
	
}
