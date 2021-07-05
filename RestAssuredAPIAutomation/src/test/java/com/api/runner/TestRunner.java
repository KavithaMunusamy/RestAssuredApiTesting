package com.api.runner;

/**
 * Runner class to execute the Scenarios in the given feature file
 */
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = { "com.api.stepdefinitions" }, plugin = { "pretty",
		"html:test-output", "json:target/JsonReports/Cucumber-Report.json",
		"junit:junit_xml/cucumber.xml" }, monochrome = true)
public class TestRunner {

}
