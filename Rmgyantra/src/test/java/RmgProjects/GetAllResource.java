package RmgProjects;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllResource {
	@Test
	public void getAllData() {
		//send the request
		Response response = RestAssured.get("http://localhost:8084/projects");
		
		//print the response
		System.out.println(response.getContentType());
		//System.out.println(response.getTime());
		System.out.println(response.statusCode());
		System.out.println(response.prettyPeek());
		
		//validate the response
//		ValidatableResponse validate = response.then();
//		validate.assertThat().contentType("application/json");
//		validate.assertThat().statusCode(200);
//		response.prettyPrint();
//		validate.log().all();
		
	}

}
