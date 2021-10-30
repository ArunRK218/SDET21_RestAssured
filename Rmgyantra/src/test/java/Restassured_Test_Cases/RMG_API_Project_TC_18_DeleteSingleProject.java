package Restassured_Test_Cases;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
/**
 * delete single project
 * 
 * @author ARUN R
 *
 */
public class RMG_API_Project_TC_18_DeleteSingleProject {
	@Test
	public void deleteSingleProject() {
		baseURI="http://localhost";
		port=8084;
		
		//get projects
	 	when()
		.delete("/projects/TY_PROJ_207")
		
		//validate
		.then()
		.assertThat()
		.statusCode(204)
		.contentType(ContentType.JSON)
		.log().all();
	}
	}


