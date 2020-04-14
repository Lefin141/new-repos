import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TCID01_Demo_GetRequest {
	

	@Test
	public void getWeatherData() {
		//base uri
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		//request specification
		RequestSpecification httpRequest=RestAssured.given();
		//response
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
		
		//print response in console
		
		String responsebody=response.getBody().asString();
		
		System.out.println("response body is: "+responsebody);
		//print status code
		
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200);
		
		//status line verification
		String statusLine=response.getStatusLine();
		System.out.println(statusLine);
		//in order to get data from jason use json path
		System.out.println(response.jsonPath().get("City"));
		Assert.assertEquals(response.jsonPath().get("City"), "Hyderabad");
		
		
		
		
		
		
		
		
		
	}
	

}
