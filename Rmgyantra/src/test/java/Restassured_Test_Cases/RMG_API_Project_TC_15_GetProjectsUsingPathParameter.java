package Restassured_Test_Cases;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
/**
 * get all projects using path parameter
 * @author ARUN R
 *
 */
public class RMG_API_Project_TC_15_GetProjectsUsingPathParameter {

	@Test
	public void getProjectsUsingPathParameter() {
		//get projects
	 	when()
		.get("http://localhost/8084/projects")
		
		//validate
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}
}
