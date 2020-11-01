package apiTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Truekey {

	@Test
	public void githubDetails()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://github.com/";//"http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET, "/kavitarathod/API-Testing");

		// Now let us print the body of the message to see what response
		// we have received from the server
		String responseBody = response.getBody().asString();
		int statusCode=response.getStatusCode();
		System.out.println("Status Code -> " +statusCode);
		Assert.assertEquals(statusCode,200,"Correct Status Code received");
		System.out.println("Status Line -> " +response.getStatusLine());
		System.out.println("Response Body is =>  " + responseBody);
		
		Headers allHeaders=response.getHeaders();
		
		for(Header header:allHeaders) {
			System.out.println("Key: "+header.getName()+" Value:"+header.getValue());
		}
		
		

	}
}
