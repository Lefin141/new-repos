import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TCD003_GET_Request {

	@Test
	public void googleMapValidateHeader() {
		
		RestAssured.baseURI="https://maps.googleapis.com";
		RequestSpecification httprequest=RestAssured.given();
		Response response=httprequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

		System.out.println(response.getBody().asString());

		String Content=response.header("Content-Type");
		System.out.println(Content);
		Assert.assertEquals(Content, "application/xml; charset=UTF-8");
		
		String contentencoding=response.header("Content-Encoding");
		System.out.println(contentencoding);
		
	}
	
	
	
	
	
	
	
	
}
