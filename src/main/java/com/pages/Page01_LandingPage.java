package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class Page01_LandingPage extends Utility {
	
	@FindBy(xpath="//div[@id='st_notification_modal']/iframe")
    private WebElement frame1;
	
	@FindBy(id="NC_CTA_TWO")
    private WebElement nothanksbutton;
	
	@FindBy(xpath="//*[@id='__st_fancy_popup']/iframe")
    private WebElement frame2;
	
	@FindBy(id="__st_bpn_no")
    private WebElement laterbutton;
	
	@FindBy(xpath="//button[text()='ACCEPT ALL COOKIES']") 
	private WebElement acceptCookiesButton;
	
	@FindBy(xpath="//img[@title = 'asian-paint-logo']")
	private WebElement asianpaintlogo;
	
	@FindBy(xpath="//h2[text()='Create your dream home with our painting experts']")
	private WebElement textcheck;
	
	@FindBy(xpath="//input[@class='commonTextComp track_search_click']")   //Change the Xpath
	private WebElement searchbutton;
	
	@FindBy(xpath="(//a[@class='iconTextLinks iconsWithText__wrap'])[1]")   //Change the xpath
    private WebElement texturebutton;
	
	public Page01_LandingPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	} 
	
	public String validateLandingPageTitle()
	{
		return validatePageTitle(); 
	} 
	
	public void noThanksButton() throws IOException
	{
        driver.switchTo().frame(frame1);
        nothanksbutton.click();
        driver.switchTo().defaultContent();
	}
	
	public void laterButton() throws IOException
	{
        driver.switchTo().frame(frame2);
        laterbutton.click();
        driver.switchTo().defaultContent();
	}
	
	public void acceptCookiesButtonValidation() throws IOException

    {
        acceptCookiesButton.click();
    }
	
	public boolean checkasianPaintLogo() throws IOException

    {
		 return asianpaintlogo.isDisplayed();
    }
	
	public String verifyText() throws IOException

    {
		 return textcheck.getText();
    }
	
	public void productListPageNavigation1() throws IOException
	{
		searchbutton.click();
		
	}
	
	public Page02_ProductListPage productListPageNavigation2() throws IOException
	{
		texturebutton.click();
		return new Page02_ProductListPage();
	}
	
	
}


