package com.student.test;

import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.student.request.RequestFactory;
import com.student.tags.Smoke;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//import io.qameta.allure.junit4.DisplayName;

@Story("This is a CRUD testing story")
public class CRUDTest extends TestBase {
	RequestFactory requestFactory = new RequestFactory();
	
@Category(Smoke.class)
	@Story("This is a CRUD testing story")
	@DisplayName("Get all student api automation")
	@Feature("This test is to get all students data")
	@Test
	public void getAllStudentsTest() {

//		requestFactory.getAllStudents()
//					  .then()
//					  .log()
//					  .all()
//					  .spec(SpecificationFactory.genericResponse())
//					  .assertThat()
//					  .statusCode(200);

	Response res=requestFactory.getAllStudents();
	JsonPath json=	res.jsonPath();
	List <String>ls=json.getList("id");
	
	for(String i:ls) {
		System.out.println("value " + i);
	}
	}
	
//	@Story("This is a CRUD testing story")
//	@DisplayName("Test to create & verify a new student")
//	@Feature("Test to create & verify a new student")
//	@Tag("Regression,Smoke")
//	@Test
//	public void createNewStudent() {
//
//		Faker faker =new Faker();
//		String firstName=faker.name().firstName();
//		String lastName=faker.name().lastName();
//		String email=faker.internet().emailAddress();
//		String programme="Computer Science";
//		List<String>courses= new ArrayList<String>();
//		courses.add("Internet Security");
//		courses.add("Java");
//		courses.add("C++");
//		
//		requestFactory.createStudent("",firstName, lastName, email, programme, courses)
//					  .then()
//					  .log()
//					  .all()
//					  .spec(SpecificationFactory.genericResponse())
//					  .assertThat()
//					  .statusCode(201);
//
//	}

}
