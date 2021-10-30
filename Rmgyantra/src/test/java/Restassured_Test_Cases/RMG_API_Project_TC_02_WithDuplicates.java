package Restassured_Test_Cases;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import  io.restassured.http.ContentType;
import sdet21.POJOclass.ProjectLibrary;

public class RMG_API_Project_TC_02_WithDuplicates {
	@Test
	public void createProjectWithDuplicates() {
		
		baseURI ="http://localhost";
		port =8084;
		ProjectLibrary plib = new ProjectLibrary("kass", "akss", "completed", 40);
		
		
		given()
		.contentType(ContentType.JSON)
		.body(plib)
		
		.when()
		.post("addProject")
		
		.then()
		.assertThat()
		.statusCode(409)
		.log().all();
	}

}
