package productdetails_stepdefinition_1;

import com.utility.Utility;


import com.pages.Page01_LandingPage;
import com.aventstack.extentreports.Status;

import com.pages.Page02_ProductListPage;
import com.pages.Page03_ProductDetailsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetails_StepDefinition_1 extends Utility{
	
	public Page01_LandingPage  lp;
	public Page02_ProductListPage plp;
	public Page03_ProductDetailsPage pdp;
	
	
	public void objectMethod() throws IOException {

		lp = new Page01_LandingPage();
		plp = new Page02_ProductListPage();
		pdp = new Page03_ProductDetailsPage();
	
	}
		//Scenario1
	
		//Landing Page Starts
	
		@Given("Chrome is opened and Asianpaints app is opened")
		public void chrome_is_opened_and_asianpaints_app_is_opened() throws IOException, InterruptedException {
			objectMethod();
			Utility.implicitWait();
			Thread.sleep(5000);
			lp.noThanksButton();
			Thread.sleep(2000);
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
			logger.log(Status.INFO, "Validating user is able to search the product");
			objectMethod();
			Utility.implicitWait();
			lp.productListPageNavigation1();
			Thread.sleep(2000);
			logger.log(Status.PASS, "Validation is successfull");
		    
		}
		
		@When("User clicks on the product")
		public void user_clicks_on_the_product() throws InterruptedException, IOException {
			logger.log(Status.INFO, "Validating user is able to click on the product");
			objectMethod();
			Utility.implicitWait();
	        lp.productListPageNavigation2();
	        logger.log(Status.PASS, "Validation is successfull");
	        
		}
		
		//Landing Page work is finished
		
		//ProductList Page Starts
		
		@Then("User navigates onto the ProductList page")
		public void user_navigates_onto_the_product_list_page() throws InterruptedException, IOException {
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
		
	
		//Scenario2
	
		
		@Then("User clicks on any listed item")
		public void user_clicks_on_any_listed_item() throws IOException, InterruptedException {
			logger = report.createTest("Test02");
			logger.log(Status.INFO, "Validating user is able to click on any of the selected item");
		    objectMethod();
		    Utility.implicitWait();
		    Utility.scroll();
		    Thread.sleep(2500);
		    plp.clickOnItem();
		    logger.log(Status.PASS, "Validation is successfull");
		  
		}
		
		//ProductList Page work is finished
		
		//ProductDetails Page starts
		
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
		
		
		//Scenario3
	
	
		@When("User changes the quantity of the product")
		public void user_changes_the_quantity_of_the_product() throws IOException, InterruptedException {
			logger = report.createTest("Test03");
			logger.log(Status.INFO, "Validating user is able to change the quantity of the product");
	    		objectMethod();
	    		Utility.implicitWait();
	    		Utility.scroll();
	    		Thread.sleep(2000);
	    		pdp.quantityButton();
	    		Thread.sleep(4000); 
	    		logger.log(Status.PASS, "Validation is successfull");
		}
		
		
		@Then("Application selects the correct quantity")
		public void application_selects_the_correct_quantity() throws Exception {
			logger.log(Status.INFO, "Validating if the quantity is successfully changed");
			objectMethod();
			Utility.implicitWait();
			Thread.sleep(2000);
			pdp.selectButton();
			Thread.sleep(2000);
			Utility.captureScreenshot();
			logger.log(Status.PASS, "Validation is successfull");
		}
		
		//ProductDetails Page work is finished
		
}
