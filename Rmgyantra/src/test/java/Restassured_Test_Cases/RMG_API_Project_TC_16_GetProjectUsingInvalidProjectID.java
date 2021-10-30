package Restassured_Test_Cases;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
/**
 * get project with invalid id
 * we will get 
 * (Expected status code <200> but was <500>)
 * @author ARUN R
 *
 */
public class RMG_API_Project_TC_16_GetProjectUsingInvalidProjectID {

	@Test
	public void getProjectUsingInvalidProjectID() {
		
		baseURI="http://localhost";
		port=8084;
		//get projects
	 	when()
		.get("/projects/TY_PROJ_609")
		
		//validate
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}
}
