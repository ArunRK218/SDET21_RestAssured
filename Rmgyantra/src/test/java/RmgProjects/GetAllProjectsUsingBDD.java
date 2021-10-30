package RmgProjects;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllProjectsUsingBDD {
	
	@Test
	public void getAllPrjectsUsingBDD()
	{
		when()
		.get("http://localhost:8084/projects")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}

}
