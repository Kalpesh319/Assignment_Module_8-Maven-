package Com.Mvn.Maven_Assignment_AutoFMQuiz;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

/*
 *  W.a.framework program for data driven framework
-to get value from the excel and check into your website
(http://automationpractice.com/index.php?controller=authentication&back=myaccount) 
Direct check with login which emaild through login successful or not
 * 
 * 
 * 
 */
public class Q1Datadriven {
	@Test
	public String[][] readExcel() throws InvalidFormatException, IOException {
		String[][]data=null;
		
		
		
		//   1. to get filepath
		String filepath="C:\\Kalpesh_selenium\\11th_march_Poi.xlsx";
		
		
		
		
		//   2.  to make a file
		File file=new File(filepath);
		
		
		//3 to open aexcel file
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		
		//  4.to get a sheet.
		Sheet sheet=workbook.getSheet("Sheet1");
		
		
		//5.to get a no of row
		int n_row=sheet.getPhysicalNumberOfRows();
		System.out.println("total no of rows are: "+n_row);
		
		
		//6. to set no of row using jagged array.
		data=new String[n_row][];
		
		
		for (int i = 0; i < data.length; i++) {
			
			//7. to select particular row
			Row row =sheet.getRow(i);
			
			
			//8. no of the colunm in each row
			int n_col=row.getPhysicalNumberOfCells();
			System.out.println("total no of column are: "+n_col);
			
			
			//9. set no of col in each row
			data[i]=new String[n_col];
			
			for (int j = 0; j < data[i].length; j++) {
				
				
		    //10. to select particular row
		    Cell cell= row.getCell(j);
				
		    //11.to set cell type
		    cell.setCellType(CellType.STRING);
				
		    //11. to get adata from particulare cell
			data[i][j]=cell.getStringCellValue();
			}
			}
			
		
		return data;
	}
	WebDriver driver= null;
	@Test
	public void test() throws InterruptedException, InvalidFormatException, IOException {
		System.setProperty("webdriver.edge.driver", "C:\\Kalpesh_selenium\\BrowserDrivers\\msedgedriver.exe");
		 String[][] data=readExcel();
		 for (int i = 0; i < data.length; i++) {
			
		
		  driver=new EdgeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://www.saucedemo.com/");
		  Thread.sleep(2000);
		  
		
		  
		  
		  
		   driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(data[i][0]);
			Thread.sleep(2000);  //1 username
			
			
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(data[i][1]);
			Thread.sleep(2000);//2 password
			
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(2000); //3 loginbutton
			
			if (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html ")) {
			System.out.println("this test is passed");	
			}else {
				System.out.println("this test is fail!!!!!");
			}
			
			
			
			
			
			
			driver.findElement(By.id("react-burger-menu-btn")).click();
			Thread.sleep(2000); //4 menubutton
			
			driver.findElement(By.id("inventory_sidebar_link")).click();
			Thread.sleep(2000);//5 all items
			
			driver.findElement(By.id("about_sidebar_link")).click();
			Thread.sleep(2000);//6about page
			
			//driver.findElement(By.id("logout_sidebar_link")).click();
			Thread.sleep(2000); // 7 logout page
			

			driver.close();
			
		  
		  
		 }	
		
	}
 

		
		
	}


