package RmgProjects;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	
	@Test
	public void updateProject()
	{
		JSONObject js = new JSONObject();
		js.put("createdBy", "Arunk");
		js.put("projectName", "Firefox");
		js.put("status", "On-Going");
		js.put("teamSize", 40);
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(js);
		
		Response res = req.put("http://localhost:8084/projects/TY_PROJ_206");
		
		res.then().assertThat().statusCode(200);
		
		
	}

}
