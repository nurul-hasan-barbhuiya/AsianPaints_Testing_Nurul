package com.pages;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class Page03_ProductDetailsPage extends Utility{
	
	@FindBy(xpath="//*[@id=\"shop-visualiser\"]/div[2]")
    private WebElement quantitybutton;
	
	@FindBy(xpath="//*[@id=\"shop-visualiser\"]/div[2]/div[1]/ul/li[2]/a")
    private WebElement selectbutton;
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div/div[2]/div/div[8]/div/form/div[1]/label")  //Change Xpath
    private WebElement pincodebutton;
	
	@FindBy(xpath="//input[@id='checkPincode']")
    private WebElement pincodetype;
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div/div[2]/div/div[8]/div/form/div[1]/div[1]/button")  //Xpath change
    private WebElement checkbutton;
	
	
	public Page03_ProductDetailsPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	} 
	
	public String validateProductDetailsPageTitle()
	{
		return validatePageTitle();
	}
	
	public void quantityButton(){
		
		quantitybutton.click();
	}
	
	public void selectButton(){
		
		selectbutton.click();
	}
	
	public void pincodeButton(){
		
		pincodebutton.click();
	}
	
	public void pincodeType(String pincode) throws IOException{
		
		pincodetype.sendKeys(pincode);
	}
	
	public void checkButton() {
		
		checkbutton.click();
	}
	


}
