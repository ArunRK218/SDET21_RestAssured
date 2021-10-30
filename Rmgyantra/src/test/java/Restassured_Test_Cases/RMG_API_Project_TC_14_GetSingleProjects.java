package Restassured_Test_Cases;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
/**
 * get single project
 * @author ARUN R
 *
 */
public class RMG_API_Project_TC_14_GetSingleProjects {

	@Test
	public void getSingleProjects() {
		
			baseURI="http://localhost";
			port=8084;
			//get projects
		 	when()
			.get("/projects/TY_PROJ_209")
			
			//validate
			.then()
			.assertThat()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
