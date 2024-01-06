import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
public class AutomationTest {

	@Test
	public void scenario()
	{System.setProperty(
            "webdriver.chrome.driver",
            "C:\\Users\\ADMIN\\Documents\\chromedriver.exe");
  
        WebDriver driver = new ChromeDriver();
  
        // Maximize the browser
        // using maximize() method
        driver.manage().window().maximize();
  
        // Launching website
        driver.get("https://www.geeksforgeeks.org/");}
}
