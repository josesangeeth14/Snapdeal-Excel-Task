package org.snapdeal.excel.test.SnapdealExcel;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel extends Excel
{	
	private void snapdeal() throws Throwable
	{
		//To set the Driver Properties
    	System.setProperty("webdriver.chrome.driver","G:\\Workspace\\SnapdealExcel\\drivers\\chromedriver.exe");
    	WebDriver d = new ChromeDriver();
    	//To launch the Browser
    	d.get("https://www.snapdeal.com/");
    	//To pass the Product name and search
    	WebElement product = d.findElement(By.id("inputValEnter"));
    	product.sendKeys(getData(1,0));
    	WebElement search = d.findElement(By.xpath("//button[@class='searchformButton col-xs-4 rippleGrey']"));
    	search.click();
    	//To click the particular product
    	WebElement pclick = d.findElement(By.xpath("//p[text()='JBL JBL JR 300 Over Ear Wired Headphones With Mic']"));
    	pclick.click();
    	
    	//product description and add to cart will be opened in another window
    	//Windows Handling to switch to that window
    	String parid = d.getWindowHandle();
    	Set<String> allid = d.getWindowHandles();
    	for(String x:allid)
    	{
    		if(!x.equals(parid))
    		{
    			d.switchTo().window(x);
    		}
    	}
    	
    	//To click the Add to Cart Button
    	Thread.sleep(4000);
    	WebElement addcart = d.findElement(By.xpath("//span[text()='add to cart']"));
    	addcart.click();
    	
    	//To click the cart button
    	Thread.sleep(4000);
    	WebElement cart = d.findElement(By.xpath("//i[@class='sd-icon sd-icon-cart-icon-white-2']"));
    	cart.click();
    	
    	//To increase cart Product Quantity
    	Thread.sleep(4000);
    	WebElement quantity = d.findElement(By.xpath("//div[@id='CS2']"));
    	quantity.click();
    	
    	//To click Proceed 
    	//WebElement checkout = d.findElement(By.xpath("//a[text()='Proceed To Checkout']"));
    	//checkout.click();
	}
	
    public static void main( String[] args ) throws Throwable
    {
    	Sel obj = new Sel();
    	obj.snapdeal();
    }
}
