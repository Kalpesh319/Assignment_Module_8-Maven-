package Com.Mvn.Maven_Assignment_AutoFMQuiz;
/*
 * 
 * Q: create simple programme in maven .
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateSimpleP {
	WebDriver driver;
	@Test
public void namecreate() throws InterruptedException {
		driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
	driver.manage().window().maximize();
	driver.get("  https://www.facebook.com/");
	
	driver.close();
	
	
	
}
}
