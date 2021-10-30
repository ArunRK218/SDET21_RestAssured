package Restassured_Test_Cases;

import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import sdet21.POJOclass.ProjectLibrary;
/**
 * update with in valid project ID
 * @author ARUN R
 *
 */
public class RMG_API_Project_TC_13_WithInValidProjectID {
	@Test
	public void updateProjectWithInValidProjectID() throws FileNotFoundException {
			baseURI="http://localhost";
		
			port=8084;
			//read the file
			ProjectLibrary plib = new ProjectLibrary("Kas13", "aks13", "on going", 200);
			
			//request specification
			given()
			.contentType(ContentType.JSON)
			.body(plib)

			//actual request
			.when()
			.put("projects/TY_PROJ_602")
			
			//validate
			.then()
			.assertThat()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.log().all();

		}

}
