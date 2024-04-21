package restAssuredTests;

import static io.restassured.RestAssured.*;  
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

/*
 given()
     set cookies, add auth, add param, set headers info etc....
 when()
     get, post,put,delete...
 then()
     validate status code, extract response, extract headers cookies and response body..
 */

public class Demo1_GET_Request {

	@Test
	public void getWeatherDetails() {
		given()
		.when()
		      .get("https://reqres.in/api/users/2")
		.then()
		      .statusCode(200)
		      .statusLine("HTTP/1.1 200 OK")
		      .assertThat().body("data.email",equalTo("janet.weaver@reqres.in"))
		      .header("Content-Type", "application/json; charset=utf-8");
	}
}
