package RmgProjects;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import sdet21.POJOclass.ProjectLibrary;

public class CreateProjectUsingPOJO {
	@Test
	public void createProjectUsingPojo() {
		
		baseURI ="http://localhost";
		port =8084;
		
		//read data through pojo class
		ProjectLibrary plib = new ProjectLibrary("AKS", "KAS", "On going", 30);
		
		//request specification
		given()
		.contentType(ContentType.JSON)
		.body(plib)
		
		//request
		.when()
		.post("/addProject")
		
		//validation
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
	}

}
