import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TCD002_Post_Request {
	
	
	@Test
	public void registerNewCustomer() {
		
			RestAssured.baseURI="http://restapi.demoqa.com/customer";
			
			RequestSpecification httpRequest=RestAssured.given();
			//creating data to send alonge with post request
			
			JSONObject requestParameters=new JSONObject();
			requestParameters.put("FirstName", "RajhJu1h");
			requestParameters.put("LastName", "kjJm");
			requestParameters.put("UserName", "RajJhu1233h");
			requestParameters.put("Password", "RaJjhuu1414h");
			requestParameters.put("Email", "RaJju1jh233h@gmail.com");
			httpRequest.header("Content-Type","application/json");
			httpRequest.body(requestParameters.toJSONString());
			
			//sending request
			Response response=httpRequest.request(Method.POST,"/register");
			
			
			String responsebody=response.getBody().asString();
			System.out.println(responsebody);
			int statuscode=response.statusCode();
			Assert.assertEquals(201, statuscode);
			System.out.println(statuscode);
			
			System.out.println(response.statusLine());
			
			String SuccesCode=response.jsonPath().get("SuccessCode");
			System.out.println(SuccesCode);
			Assert.assertEquals("OPERATION_SUCCESS", SuccesCode);
			
			Assert.assertEquals(responsebody.contains("OPERATION_SUCCESS"),true);
			
		
		
		
	}
	
	
	
	
	

}
