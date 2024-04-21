package SerializationDeserialization;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class VideoGameAPITestwithSerializationJSON {
	@Test(priority = 1)
	public void testVideoGameSerializationJSON() {
		VideoGame myVideoGame=new VideoGame();
		myVideoGame.setId(11);
		myVideoGame.setName("xyz123");
		myVideoGame.setReleaseDate("2023-04-21");
		myVideoGame.setReviewScore(90);
		myVideoGame.setCategory("Driving");
		myVideoGame.setRating("Five");
		
		given()
		      .contentType("application/json")
		      .body(myVideoGame)
		.when()
		      .post("http://localhost:8080/app/videogames")
		.then()
		      .log().all()
		      .body(equalTo("{\"status\": \"Record Added Successfully\"}"));
	}
	
	@Test(priority = 2)
	public void testVideoGameDeSerializationJSON() {
		VideoGame myVideoGame=get("http://localhost:8080/app/videogames/11").as(VideoGame.class);
		System.out.println(myVideoGame.toString());
	}
}
