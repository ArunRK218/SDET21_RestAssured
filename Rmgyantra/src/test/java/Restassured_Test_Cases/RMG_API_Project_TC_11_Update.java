package Restassured_Test_Cases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.port;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import sdet21.POJOclass.ProjectLibrary;
/**
 * updated the project
 * @author ARUN R
 *
 */
public class RMG_API_Project_TC_11_Update {
	@Test
	public void updateProject() throws FileNotFoundException {
			baseURI ="http://localhost";
			port =8084;
			//read the file
			ProjectLibrary plib = new ProjectLibrary("Kas11", "aks11", "competed", 100);
			
			//request specification
			given()
			.contentType(ContentType.JSON)
			.body(plib)

			//actual request
			.when()
			.put("projects/TY_PROJ_206")
			
			//validate
			.then()
			.assertThat()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.log().all();

		}

}
