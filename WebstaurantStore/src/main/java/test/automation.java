package test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;

public class automation {

	@Test
	public void scenario()
	{
		System.setProperty(
            "webdriver.chrome.driver",
            "C:\\chromedriver\\chromedriver.exe");
  
        WebDriver driver = new ChromeDriver();
  
        // Maximize the browser
        // using maximize() method
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		try 
		{
  
	        // Launching website
	        driver.get("https://www.webstaurantstore.com/");
	        driver.findElement(By.id("searchval")).sendKeys("stainless work table");
	        driver.findElement(By.xpath("//button[@Value='Search']")).click();
	        List<WebElement> elements = driver.findElements(By.xpath("//a/p[contains(@class,'bold')]"));
	        int count = elements.size();
	        int flag=0;
	        
	        
	        System.out.println("Total count is: "+ count);
	
	        for (WebElement element : elements) {
	            flag++;
	            if(element.getText().contains("Table")){
	        		System.out.println("Table is available");
	        	}
	        	else
	        	{
	        		System.out.println("Table is not available");
	        	}
	            if(flag == count){
	                element.click();
	            }
	        }
	        System.out.println("Table verification completed");
	        List<WebElement> cartElements = driver.findElements(By.xpath("//input[@value='Add to Cart']"));
	        System.out.println("Total cart :"+cartElements.size());
	        try {
		        for (WebElement element : cartElements) {		        	
		           element.click();
		        }    
	        }
	        catch(Exception ee) {
	        	
	        }
	        System.out.println("Added to cart");
	        driver.navigate().refresh();
	        Thread.sleep(6000);
	        WebElement elementViewCart = driver.findElement(By.xpath("//a[contains(@aria-label,'View your cart')]"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementViewCart);
	        elementViewCart.click();
	        System.out.println("Clicked on View cart");
	
	        List<WebElement> decreaseElements = driver.findElements(By.xpath("//button[@title='Decrease Quantity']"));
	         
	         
	        for (WebElement element : decreaseElements) {
	
	           element.click();
	
	        }
	        System.out.println("Cart is empty");
		}
		catch(Exception e) 
		{
			System.out.println("Failed at: "+e.getMessage());
		}
        driver.quit();
     }
}
