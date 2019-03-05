package test.api.automation;

import static com.jayway.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;

public class TC_005_Get_Json_Data {

	@Test
	public void validateJsonResponse() {
//		Response response = when().get("http://localhost:3000/posts/6");
//		System.out.println(response.asString());
		
//		String actualAuthor = when().get("http://localhost:3000/posts/6").then().contentType(ContentType.JSON).extract().path("author");
//		Assert.assertEquals(actualAuthor, "Updated Author Name");
		
		ValidatableResponse response = when().get("http://localhost:3000/posts/1").then().contentType(ContentType.JSON);
		String author = response.extract().path("author");
		String title  = response.extract().path("title");
		int id = response.extract().path("id");
		
		System.out.println(author +"\n" +title +"\n" +id);
	}
}
