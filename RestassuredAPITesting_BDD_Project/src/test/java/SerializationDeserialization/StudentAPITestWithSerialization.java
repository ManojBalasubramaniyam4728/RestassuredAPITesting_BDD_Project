package SerializationDeserialization;

import static io.restassured.RestAssured.get; 
import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;


public class StudentAPITestWithSerialization {
	
	@Test(priority = 1)
	public void createNewStudentSerialization(){
	      ArrayList<String> coursesList=new ArrayList<String>();
	      coursesList.add("java");
	      coursesList.add("Selenium");
	      
	      Student stu=new Student();
	      stu.setSID(101);
	      stu.setFirstName("John");
	      stu.setLastName("Deo");
	      stu.setEmail("abcd@gmail.com");
	      stu.setProgramme("Computer science");
	      stu.setCourses(coursesList);
	      
	      given()
	           .contentType(ContentType.JSON)
	           .body(stu)
	      .when()
	           .post("http://localhost:8080/student")
	      .then()
	           .statusCode(201)
		       .assertThat()
		       .body("msg",equalTo("Student added"));
	}
	
	@Test(priority = 2)
	void getStudentRecordDeSerialization() {
           Student stu=get("http://localhost:8080/student/101").as(Student.class);
           System.out.println(stu.getStudentRecord().toString());
           Assert.assertEquals(stu.getSID(), 101);
	}
}