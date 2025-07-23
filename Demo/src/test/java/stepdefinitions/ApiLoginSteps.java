package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import org.junit.Assert;


public class ApiLoginSteps {
	
	RequestSpecification request;
    Response response;

    @Given("I set login payload with valid credentials")
    public void valid_login_payload() {
        request = RestAssured.given().contentType("application/json")
            .body("{\"username\": \"mor_2314\", \"password\": \"83r5^_\"}");
    }

    @When("I send POST request to login endpoint")
    public void send_login_request() {
        response = request.post("https://fakestoreapi.com/auth/login");
    }

    @Then("I should receive a valid auth token")
    public void validate_token() {
        response.then().statusCode(200);
        String token = response.jsonPath().getString("token");
        Assert.assertNotNull("Token should not be null", token);
    }
    
    @Given("I set login payload with invalid credentials")
    public void invalid_login_payload() {
        request = RestAssured.given().contentType("application/json")
            .body("{\"username\": \"Testing\", \"password\": \"Testing\"}");
    }

    @Then("I should receive an authentication error")
    public void validate_auth_error() {
        response.then().statusCode(401);
        String body = response.getBody().asString();
        System.out.println("Auth error response: " + body);
        Assert.assertTrue("Expected error response", body.contains("error") || body.contains("Unauthorized"));
    }


}
