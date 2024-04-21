package restAssuredTests;
/*
1) Verifying Single content in XML Response
2) Verifying Multiple contents in XML response
3) Verify a content in XML response in one go
4) Math with text() function
5) Find values using XML Path in XML response
 */

import static io.restassured.RestAssured.given;  
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasXPath;

import org.testng.annotations.Test;

public class Demo6_BasicValidations_XML {
	
	//1) Verifying Single content in XML Response
	@Test(priority = 1)
	void testSinglecontent() {
		   given()
		        
		   .when()
		         .get("https://bc5d2644-f4fd-4e46-afb7-1eb26bc1da2f.mock.pstmn.io/CUSTOMER/15")
		   .then()
		         .body("CUSTOMER.FIRSTNAME",equalTo("Bill"))
		         .log().all();
	      }
	
	
	//2) Verifying Multiple contents in XML response
		@Test(priority = 2)
		void testMultiplecontents() {
			   given()
			        
			   .when()
			         .get("https://bc5d2644-f4fd-4e46-afb7-1eb26bc1da2f.mock.pstmn.io/CUSTOMER/15")
			   .then()
			         .body("CUSTOMER.FIRSTNAME",equalTo("Bill"))
			         .body("CUSTOMER.LASTNAME",equalTo("Clancy"))
			         .body("CUSTOMER.STREET",equalTo("319 Upland Pl."))
			         .body("CUSTOMER.CITY",equalTo("Seattle"));
		      }
		
		
	//3) Verify a content in XML response in one go
		@Test(priority = 3)
		void testMultiplecontentsInOneGo() {
		          given()
					        
				  .when()
					    .get("https://bc5d2644-f4fd-4e46-afb7-1eb26bc1da2f.mock.pstmn.io/CUSTOMER/15")
				   .then()
					     .body("CUSTOMER.text()",equalTo(" \n  <script/> \n  <ID>15\n  BillClancy319 Upland Pl.Seattle"));
			  }
				
				
	 //4) Math with text() function
		@Test(priority = 4)
		void testUsingXPath1() {
			     given()
					        
			     .when()
					   .get("https://bc5d2644-f4fd-4e46-afb7-1eb26bc1da2f.mock.pstmn.io/CUSTOMER/15")
			     .then()
					   .body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Bill")));
			   }
				
		@Test(priority = 5)
		void testUsingXPath2() {
				given()
					        
			    .when()
					   .get("https://28d0f480-d04a-46bd-9d42-115a290b3197.mock.pstmn.io/INVOICE/")
			    .then()
					   .body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
					   .log().all();
				  }
		

}
