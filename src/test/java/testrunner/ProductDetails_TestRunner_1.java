package testrunner;

import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
 features = "src/test/resources/features/ProductDetails1.feature",
 glue =  {"productdetails_stepdefinition_1", "apphooks"},
 plugin= {"pretty" ,
		 "html:cucumber_report/cucumber",
		 "json:cucumber_report/cucumber.json",
 		 "junit:cucumber_report/cucumber.xml"}
)
public class ProductDetails_TestRunner_1 extends AbstractTestNGCucumberTests {

}