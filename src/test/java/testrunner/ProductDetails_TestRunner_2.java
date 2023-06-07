package testrunner;

import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
 features = "src/test/resources/features/ProductDetails2.feature",
 glue =  {"productdetails_stepdefinition_2", "apphooks"},
 plugin= {"pretty" ,
		 "html:cucumber_report/cucumber",
		 "json:cucumber_report/cucumber.json",
 		 "junit:cucumber_report/cucumber.xml"}
)
public class ProductDetails_TestRunner_2 extends AbstractTestNGCucumberTests{

}
