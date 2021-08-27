package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.stringContainsInOrder;

public class PublicWeatherAPI {

    Response response;
    final String endpoint ="https://api.weather.gov/points/";

    @Given("I send GET request with given {string} and {string}")
    public void i_send_get_request_with_given_and(String latitude, String longitude) {
        response = given().get(endpoint + latitude + "," + longitude);
    }
    @Then("I should get {string} status code")
    public void i_should_get_status_code(String statusCode) {
        int sc = Integer.parseInt(statusCode);
        response.then().statusCode(sc);
    }
    @Then("Response body should contain {string}")
    public void response_body_should_contain(String closestForecastProperty) {
        response.then().body(stringContainsInOrder(closestForecastProperty));
    }
    @Then("Response time should be not more than {string} ms")
    public void response_time_should_be_not_more_than(String responseTime) {
        long respTime = Integer.parseInt(responseTime);
        response.then().time(lessThan(respTime));
    }

}
