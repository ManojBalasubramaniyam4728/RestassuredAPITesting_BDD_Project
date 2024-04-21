package SerializationDeserialization;



import java.util.ArrayList; 
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class StudentAPITestNoSerialization {

	public HashMap map=new HashMap();
	
	//Post Requests create a new student recod
	@Test(priority = 1)
	public void createNewStudent() {
		map.put("id", 101);
		map.put("firstName", "Manoj");
		map.put("lastName", "Balasubramaniyam");
		map.put("email", "manojbalasubramaniyam4488@gmail.com");
		map.put("programme", "Manager");
		
		ArrayList<String> courseList=new ArrayList<String>();
		courseList.add("java");
		courseList.add("selenium");
		
		map.put("courses", courseList);
		
		given()
		     .contentType(ContentType.JSON)
		     .body(map)
		.when()
		     .post("http://localhost:8080/student")
		.then()
		     .statusCode(201)
		     .assertThat()
		     .body("msg",equalTo("Student added"));
	}
	
	//Get Requests to retrieve student details
	@Test(priority = 2)
	void getStudentRecord() {
	     given()
		
		 .when()
		       .get("http://localhost:8080/student/101")
	     .then()
		       .statusCode(200)
		       .assertThat()
		       .body("id", equalTo(101))               
		       .log().all();
	}
}
