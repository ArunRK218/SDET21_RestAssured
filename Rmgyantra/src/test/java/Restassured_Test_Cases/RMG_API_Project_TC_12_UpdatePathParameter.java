package Restassured_Test_Cases;

import static io.restassured.RestAssured.*;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import sdet21.POJOclass.ProjectLibrary;
/**
 * update project with path parameter
 * @author ARUN R
 *
 */
public class RMG_API_Project_TC_12_UpdatePathParameter {
	@Test
	public void updateProjectWithPathParameter() throws FileNotFoundException {
			
			//read the file
			ProjectLibrary plib = new ProjectLibrary("Kas12", "aks12", "on going", 200);
			
			//request specification
			given()
			.contentType(ContentType.JSON)
			.body(plib)

			//actual request
			.when()
			.put("http://localhost:8084/projects/TY_PROJ_206")
			
			//validate
			.then()
			.assertThat()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.log().all();

		}

}
