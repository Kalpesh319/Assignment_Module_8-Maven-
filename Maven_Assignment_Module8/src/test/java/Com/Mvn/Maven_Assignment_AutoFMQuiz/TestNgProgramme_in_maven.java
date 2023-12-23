package Com.Mvn.Maven_Assignment_AutoFMQuiz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * 
 * Q::-W.a.maven program to create TestNG with Webdriver Progra
 */

public class TestNgProgramme_in_maven {
	WebDriver driver;
	@Test
	public void openurl() throws InterruptedException {
		driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		
		
		
		
	}
	@Test
	public void closeurl() {
		driver.close();
		
	}

}
