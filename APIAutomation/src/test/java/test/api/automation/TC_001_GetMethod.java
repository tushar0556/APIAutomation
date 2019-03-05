package test.api.automation;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import test.automation.common.CreatePost;

import static com.jayway.restassured.RestAssured.*;

public class TC_001_GetMethod {
	
	/*@Test
	public void tc_001_getMethod_validation() {
//		Response response = get("http://services.groupkt.com/country/get/iso2code/IN ");
//		System.out.println(response.asString());
//		Assert.assertEquals(response.getStatusCode(),200);
		
//		given().param("t", "Spiderman").param("y", "").param("plot", "short").param("r", "json").when()
//				.get("http://www.omdbapi.com/").then().statusCode(200);
		
		//Create First Post test case
		 given().contentType(ContentType.JSON)
		.body("{\r\n" + 
				"    \"id\": 511,\r\n" + 
				"    \"title\": \"Thor\",\r\n" + 
				"    \"author\": \"Tushar\"\r\n" + 
				"  }").when().post("http://localhost:3000/posts")
		.then().statusCode(201).contentType(ContentType.JSON);
	//	System.out.println(response.asString());
	}
*/
	
	@Test
	public void tc_001_getMethod_validation() {
		//Create post test with Json Object
		CreatePost createPost = new CreatePost();
		createPost.setId(77);
		createPost.setAuthor("TKNAIK");
		createPost.setTitle("ABC");
		
		 given().contentType(ContentType.JSON)
			.body(createPost).when().post("http://localhost:3000/posts")
			.then().statusCode(201).contentType(ContentType.JSON);
		 
		 System.out.println(createPost.toString());
	}
}
