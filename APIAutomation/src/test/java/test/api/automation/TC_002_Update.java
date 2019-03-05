package test.api.automation;

import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;

import test.automation.common.CreatePost;

public class TC_002_Update {

	@Test
	public void updateResource() {
		//Update Author with Put request
		int id = 77;
		CreatePost createPost = new CreatePost();
		createPost.setId(id);
		createPost.setAuthor("Updated Author Name");
		createPost.setTitle("Updated Title");
		 // put request
		 given().contentType(ContentType.JSON)
			.body(createPost).when().put("http://localhost:3000/posts/"+id)
			.then().statusCode(200);
	}
}
