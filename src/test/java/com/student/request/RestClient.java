package com.student.request;

import com.student.specs.SpecificationFactory;
import com.student.test.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestClient extends TestBase {

	public Response doGetRequest(String requestPath) {
		Response response = RestAssured.given().when().log().all().get(requestPath);
		return response;
	}

	public Response doPostRequest(String requestPath, Object body) {
		Response response = RestAssured.given()
				                       .contentType(ContentType.JSON)
				                       .spec(SpecificationFactory.logPayloadResponseInfo())
				                       .when()
				                       .body(body)
				                       .post(requestPath);

		return response;
		
	//	RestAssured.given().auth()
	}

	public Response doPutRequest(String requestPath, Object body) {
		Response response = RestAssured.given().when().body(body).put(requestPath);

		return response;

	}

	public Response doPatchRequest(String requestPath, Object body) {
		Response response = RestAssured.given().when().body(body).patch(requestPath);

		return response;

	}

	public Response doDeleteRequest(String requestPath) {
		Response response = RestAssured.given().when().delete(requestPath);

		return response;

	}
}
