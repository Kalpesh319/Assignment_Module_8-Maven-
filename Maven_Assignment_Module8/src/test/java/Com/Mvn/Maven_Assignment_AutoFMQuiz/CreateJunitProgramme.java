package Com.Mvn.Maven_Assignment_AutoFMQuiz;
/*
 * 
 *Q: create j unit webdriver programme:-
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateJunitProgramme {
WebDriver driver= null;  //declare webdriver global
	
	@Before
	
	public void before() {
		System.setProperty("webdriver.edge.driver", "C:\\Kalpesh_selenium\\BrowserDrivers\\msedgedriver.exe");
		
		
		 driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
			
	}
	@Test
	public void Login() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	Thread.sleep(1000);
	
	}
	
	
	
	
	@After
	public void after() throws InterruptedException{
		Thread.sleep(2000);
		driver.close();
	

	}

}



