package restAssuredTests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo4_DELETE_Request {
	
	@Test
	public void deleteEmployeeRecord() {
		
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/delete/1493";
		
		Response response= given()
				
				           .when()
				                 .delete()
				           .then()
				                 .statusCode(200)
				                 .statusLine("HTTP/1.1 200 OK")
				                 .log().all()
				                 .extract().response();
		String jsonAsString=response.asString();
		Assert.assertEquals(jsonAsString.contains("Successfully! Record has been deleted"), true);
	}

}
