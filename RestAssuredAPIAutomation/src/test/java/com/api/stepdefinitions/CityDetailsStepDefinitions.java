package com.api.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.api.utility.Constants;
import com.api.utility.PropertiesConfiguration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Step definition class to get the city details
 * @author Kavitha Munusamy
 *
 */
public class CityDetailsStepDefinitions {
	private static Logger logger = LogManager.getLogger(PropertiesConfiguration.class);
	PropertiesConfiguration propConf = new PropertiesConfiguration("config.properties");
	private static String baseUrl;
	private static String jsonString;
	Response response;

	/**
	 * Precondition step with the Base url
	 */
	@Given("The URL for the list of companies and its location in the network")
	public void the_url_for_the_list_of_companies_and_its_location_in_the_network() {
		baseUrl = propConf.getBaseUrl();
		logger.debug("given the base url:" + baseUrl);

	}

	/**
	 * Action step to hit the get Http request method
	 * @param pathParameter
	 */
	@When("Hit the URL with the  {string} path param")
	public void hit_the_url_with_the_path_param(String pathParameter) {
		logger.debug("hit url:" + baseUrl + pathParameter);
		response = RestAssured.given().auth().none().when().get(baseUrl + pathParameter);
	}

	/**
	 * Verification step to verify the Country
	 * @param city
	 * @param country
	 */
	@Then("Verify the {string} City is in the {string} Country")
	public void verify_the_city_is_in_the_country(String city, String country) {
		logger.debug("response.getStatusCode():" + response.getStatusCode());
		assertEquals(response.getStatusCode(), Constants.HTTP_STATUSCODE_200);

		jsonString = response.jsonPath().prettyPrint();
		assertTrue(city + " is in " + country + ":", jsonString.contains(country));

	}

	/**
	 * Verification step to verify the latitude and longitude
	 * @param latitude
	 * @param longitude
	 */
	@Then("Verify the {string} and {string} of the city")
	public void verify_the_and_of_the_city(String latitude, String longitude) {
		assertTrue(Constants.LATITUDE + ": " + latitude + " : ", jsonString.contains(latitude));
		assertTrue(Constants.LONGITUDE + ": " + longitude + " : ", jsonString.contains(longitude));
	}

}
