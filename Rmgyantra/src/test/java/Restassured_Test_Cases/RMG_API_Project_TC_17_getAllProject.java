package Restassured_Test_Cases;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
/**
 * get all the projects
 * @author ARUN R
 *
 */
public class RMG_API_Project_TC_17_getAllProject {

	@Test
		public void getProjects() {
	
			baseURI="http://localhost";
			port=8084;
	
	
		//actual request
		 when()
		.get("/projects")
		
		//validate
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	
	}
	
	}
