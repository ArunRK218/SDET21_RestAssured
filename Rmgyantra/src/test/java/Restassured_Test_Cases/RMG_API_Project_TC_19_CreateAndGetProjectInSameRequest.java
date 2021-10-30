package Restassured_Test_Cases;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import sdet21.GenericUtility.JavaUtility;
import sdet21.POJOclass.ProjectLibrary;

public class RMG_API_Project_TC_19_CreateAndGetProjectInSameRequest {

	@Test
	public void createAndGetProjectInSameRequest() {
		baseURI="http://localhost";
		port=8084;
		JavaUtility jlib = new JavaUtility();
		
		ProjectLibrary plib = new ProjectLibrary("Kaavya", "akss16"+jlib.getRandomNumber(), "Completed", 80);
		
		given()
		.contentType(ContentType.JSON)
		.body(plib)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
		
		when()
		.get("/projects")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
	}
}
