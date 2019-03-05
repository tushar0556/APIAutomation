package test.api.automation;

import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;

public class TC_004_DeleteData {

	
	@Test
	public void deleteData() {
		//Delete Data 
	
		 given().contentType(ContentType.JSON)
			.when().delete("http://localhost:3000/posts/77")
			.then().statusCode(200);
	}
}

