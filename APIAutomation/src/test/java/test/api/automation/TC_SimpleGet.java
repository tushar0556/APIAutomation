package test.api.automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class TC_SimpleGet {

	
	@Test
	public void tc_001_getMethod_validation() {
		Response response = RestAssured.get("http://services.groupkt.com/country/get/iso2code/IN ");
		System.out.println(response.asString());
		Assert.assertEquals(response.getStatusCode(),200);
		
//		RestAssured.given().param("t", "Spiderman").param("y", "").param("plot", "short").param("r", "json").when()
//				.get("http://www.omdbapi.com/").then().statusCode(200);
//		
//		//Create First Post test case
//		RestAssured.given().contentType(ContentType.JSON)
//		.body("{\r\n" + 
//				"    \"id\": 511,\r\n" + 
//				"    \"title\": \"Thor\",\r\n" + 
//				"    \"author\": \"Tushar\"\r\n" + 
//				"  }").when().post("http://localhost:3000/posts")
//		.then().statusCode(201).contentType(ContentType.JSON);
//		System.out.println(response.asString());
	}

}
