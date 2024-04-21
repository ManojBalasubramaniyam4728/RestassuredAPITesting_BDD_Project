package restAssuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*; 
import static org.hamcrest.Matchers.equalTo;

import utils.RestUtils;

public class Demo2_POST_Request {
	
	public static HashMap map=new HashMap();

	@BeforeClass
	public void Postdata() {
		map.put("Name", RestUtils.getFirstName());
		map.put("job", RestUtils.getJobRole());
		
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.basePath="/users";
	}
	
	@Test
	public void testPost() {
		given()
		     .contentType("application/json")
		     .body(map)
		.when()
		     .post()
		.then()
		      .statusCode(201)
		      .and()
		      .body("job",equalTo("leader"));
	}
}
