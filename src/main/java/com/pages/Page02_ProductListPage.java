package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;
public class Page02_ProductListPage extends Utility {
	
	@FindBy(xpath="//section[@class='color-palettes-main-wrapper']//li[1]//a[1]//span[1]")  //Change xpath
	private WebElement clickonitem;

	public Page02_ProductListPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	} 
	
	public String validateProductListPageTitle()
	{
		return validatePageTitle();
	}
	
	
	
	public Page03_ProductDetailsPage clickOnItem() throws IOException {
		clickonitem.click();
		return new Page03_ProductDetailsPage();
	}
    
	
}
