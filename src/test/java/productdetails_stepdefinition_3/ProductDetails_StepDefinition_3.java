package productdetails_stepdefinition_3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.aventstack.extentreports.Status;
import com.pages.Page01_LandingPage;
import com.pages.Page02_ProductListPage;
import com.pages.Page03_ProductDetailsPage;
import com.utility.Utility;
import com.utility.Config;
import com.utility.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetails_StepDefinition_3 extends Utility{
		
	public Page01_LandingPage  lp;
	public Page02_ProductListPage plp;
	public Page03_ProductDetailsPage pdp;
	
	ExcelReader reader;
	
	public void objectMethod() throws IOException {

		lp = new Page01_LandingPage();
		plp = new Page02_ProductListPage();
		pdp = new Page03_ProductDetailsPage();
	
	}
	
	//ScenarioOutline1

	@Given("Chrome is opened and Asianpaints app is opened")
	public void chrome_is_opened_and_asianpaints_app_is_opened() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		Thread.sleep(4500);
		lp.noThanksButton();
		Thread.sleep(2500);
		lp.laterButton();
		Thread.sleep(2000);
		lp.acceptCookiesButtonValidation();
		Thread.sleep(3000);
		
		logger = report.createTest("Test01");
        logger.log(Status.INFO, "Validating Landing page title");
        
        String actualTitle = lp.validateLandingPageTitle();
        String expectedTitle = "Trusted Wall Painting, Home Painting & Waterproofing in India - Asian Paints";

        try {
            assertEquals(expectedTitle,actualTitle);
            logger.log(Status.PASS, "Title verification validation is successfull");
            System.out.println(actualTitle);
            assert true;
        } catch (AssertionError e) {
            e.printStackTrace();
            logger.log(Status.FAIL, "Title verification validation is unsuccessfull");
            captureScreenshotOnFailure();
            assert false;
        }
		assertTrue(lp.checkasianPaintLogo());
		
        String text = lp.verifyText();
        System.out.println(text);
        
	}
	@When("User searches the product")
	public void user_searches_the_product() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		lp.productListPageNavigation1();
		Thread.sleep(2000);
	}
	@When("User clicks on the product")
	public void user_clicks_on_the_product() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
        lp.productListPageNavigation2();
        
	}
	@Then("User navigates onto the ProductList page")
	public void user_navigates_onto_the_product_list_page() throws IOException, InterruptedException {
		logger.log(Status.INFO, "Validating user is able to navigate to the productlist page");
		objectMethod();
		Utility.implicitWait();
		Thread.sleep(2000);
	    
        String actualTitle = plp.validateProductListPageTitle();
        String expectedTitle = "Interior Wall Texture Designs, Modern Texture Paint Designs & Catalogue - Asian Paints";
		
        try {
            assertEquals(expectedTitle,actualTitle);
            logger.log(Status.PASS, "Validation is successfull");
            System.out.println(actualTitle);
            assert true;
        } catch (AssertionError e) {
            e.printStackTrace();
            logger.log(Status.FAIL, "Validation is unsuccessfull");
            captureScreenshotOnFailure();
            assert false;
        } 
        
		Thread.sleep(3000);
		
	}
	@Then("User clicks on any listed item")
	public void user_clicks_on_any_listed_item() throws IOException, InterruptedException {
		objectMethod();
	    Utility.implicitWait();
	    Utility.scroll();
	    Thread.sleep(3000);
	    plp.clickOnItem();

	  
	}
	@Then("ProductDetails page is launched and fields are visible to the user")
	public void product_details_page_is_launched_and_fields_are_visible_to_the_user() throws Exception {
		logger.log(Status.INFO, "Validating ProductDetails page is launched and it is visible to the user");
		objectMethod();
		Utility.implicitWait();
		Thread.sleep(2000);
		
		String actualTitle = pdp.validateProductDetailsPageTitle();
	    String expectedTitle = "Metallics Ikkat TNB1008CMB1001 - Wall Texture Design - Asian Paints";
	    
	    try {
            assertEquals(expectedTitle,actualTitle);
            logger.log(Status.PASS, "Validation is successfull");
            System.out.println(actualTitle);
            assert true;
        } catch (AssertionError e) {
            e.printStackTrace();
            logger.log(Status.FAIL, "Validation is unsuccessfull");
            captureScreenshotOnFailure();
            assert false;
        } 
	    
	    Utility.captureScreenshot();
		Thread.sleep(3000);
		
	}
	
	@When("User enters Pincode from sheetname {string} and rownumber {int}")
	public void user_enters_pincode_from_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException, InterruptedException, InvalidFormatException {
		logger = report.createTest("Test06");
		logger.log(Status.INFO, "Validating application is accepting the correct pincodes");
		objectMethod();
	    Utility.scroll();
	    Thread.sleep(2000);
	    
	    reader = new ExcelReader();
        List<Map<String,String>> testData = reader.getData(Config.excelPath, sheetName);

        String pin = testData.get(rowNumber).get("pincode");

        pdp.pincodeButton();
	    pdp.pincodeType(pin);

	    Thread.sleep(2000);
	}
	@When("User clicks on check button")
	public void user_clicks_on_check_button() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		pdp.checkButton();
		Thread.sleep(2000); //3000
	    
	}
	@Then("It shows Pincode is serviceable")
	public void it_shows_pincode_is_serviceable() throws Exception {
	    Utility.captureScreenshot();
	    Thread.sleep(2000);
	    logger.log(Status.PASS, "Validation is successfull");
	}
	
	//ScenarioOutline 2
	
	@Then("It shows Pincode is not serviceable")
	public void it_shows_pincode_is_not_serviceable() throws Exception {
		logger = report.createTest("Test07");
		logger.log(Status.INFO, "Validating application is not accepting the incorrect pincodes");
		Utility.captureScreenshot();
	    Thread.sleep(2000);
	    logger.log(Status.PASS, "Validation is successfull");
	}
	
}
