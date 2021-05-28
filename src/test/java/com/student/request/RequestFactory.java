package com.student.request;

import java.util.List;

import com.student.pojo.Student;
import com.student.test.TestBase;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RequestFactory extends TestBase {

	RestClient restClient = new RestClient();

	@Step("Getting all student info from DB")
	public Response getAllStudents() {
		Response response = restClient.doGetRequest("/list");
		//Response res= restClient.doPostRequest(url, body);

		return response;
	}

	@Step("Creating a new student : {0} , {1} , {2} , {3} , {4} , {5}")
	public Response createStudent(String url, String firstName, String lastName, String email, String programme,
			List<String> courses) {
		Student body = new Student();
		body.setFirstName(firstName);
		body.setLastName(lastName);
		body.setEmail(email);
		body.setProgramme(programme);
		body.setCourses(courses);

	
		
		return restClient.doPostRequest(url, body);
	}

	@Step("Updating a new student : {0} , {1} , {2} , {3} , {4} , {5}")
	public Response updateStudent(int studentId, String firstName, String lastName, String email, String programme,
			List<String> courses) {
		Student body = new Student();
		body.setFirstName(firstName);
		body.setLastName(lastName);
		body.setEmail(email);
		body.setProgramme(programme);
		body.setCourses(courses);
		return restClient.doPutRequest("/" + studentId, body);

	}

	@Step("Deleting a new student with id: {0}")
	public Response deleteStudent(int studentId) {
		return restClient.doDeleteRequest("/" + studentId);
	}

	@Step("Get student by id: {0}")
	public Response getStudentbyId(int studentId) {
		return restClient.doGetRequest("/" + studentId);
	}

}
