package test.api.automation;

import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;

import test.automation.common.CreatePost;

public class TC_003_PatchMethod {

	@Test
	public void updateResourcewithPatch() {
		//Update Author with Patch request
		int id = 6;
		CreatePost createPost = new CreatePost();
	//	createPost.setId(id);
	//	createPost.setAuthor("Updated Author Name");
		createPost.setTitle("Updated Title is Chhava");
		 // put request
		 given().contentType(ContentType.JSON)
			.body(createPost).when().patch("http://localhost:3000/posts/6")
			.then().statusCode(200);
	}
}
