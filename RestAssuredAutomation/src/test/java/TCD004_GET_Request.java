import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TCD004_GET_Request {
	
	
	
	@Test
	public void getHeaders() {
		
		RestAssured.baseURI="https://maps.googleapis.com";
		RequestSpecification httprequest=RestAssured.given();
		Response response=httprequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		Headers allheaders = response.headers();
		for( Header allHeaders:allheaders) {
			
		System.out.println(allHeaders.getName()+"---"+allHeaders.getValue());
			
			
			
		}
		
		
	}

}
