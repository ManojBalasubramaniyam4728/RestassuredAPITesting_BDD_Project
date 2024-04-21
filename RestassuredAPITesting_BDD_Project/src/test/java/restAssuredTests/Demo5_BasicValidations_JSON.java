package restAssuredTests;

import static io.restassured.RestAssured.given; 
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

/*
  1) Test Status code
  2) Log Response
  3) Verifying single content in response body
  4) Verifying multiple contents in response body
  5) Setting parameters and headers
 */

public class Demo5_BasicValidations_JSON {
	
	//1) Test Status code
	@Test(priority = 1)
	public void testStatusCode() {
		given()
		
		.when()
		      .get("http://jsonplaceholder.typicode.com/posts/5")
		.then()
		      .statusCode(200)
		      .log().all();
		
	}
	
	 //2) Log Response
		@Test(priority = 2)
		public void testLogging() {
			given()
			     
			.when()
			      .get("https://reqres.in/api/users/2")
			.then()
			      .statusCode(200)
			      .log().all();
		}
		
	  //3)  Verifying single content in response body
		@Test(priority = 3)
		public void testSingleContent() {
			given()
			
			.when()
			     .get("https://reqres.in/api/users/2")
			.then()
			     .statusCode(200)
			     .body("data.last_name",equalTo("Weaver"));
		}
		
	  //4) Verifying multiple contents in response body
		@Test(priority = 4)
		public void testMultipleContents() {
            given()
			
			.when()
			     .get("https://reqres.in/api/unknown")
			.then()
			     .statusCode(200)
			     .body("data.name",hasItems("cerulean","aqua sky","true red","tigerlily","blue turquoise"))
			     .log().all();
		}
		
	  //5) Setting parameters and headers
		@Test(priority = 5)

		public void testParametersAndheaders() {
            given()
                  .param("currency","USD")
                  .header("Content-Type","application/json")
			.when()
			     .get("https://api.coindesk.com/v1/bpi/currentprice.json")
			.then()
			     .statusCode(200)
			     .log().all();
		}
	}
