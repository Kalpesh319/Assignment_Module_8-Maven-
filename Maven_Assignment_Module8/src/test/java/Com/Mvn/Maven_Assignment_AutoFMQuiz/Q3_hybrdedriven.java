package Com.Mvn.Maven_Assignment_AutoFMQuiz;
/*
 * 
 *  W.a.framework program for hybrid driven framework
-given below keyword and Data both which you get from the Excel andcheck into you
website (http://automationpractice.com/index.php)
 */

import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class Q3_hybrdedriven {
	@DataProvider(name = "kalpesh")
	public Object[][] readExcel() throws InvalidFormatException, IOException, Exception {
		Object[][]data=null;
		
		//   1. to get filepath
		String filepath="C:\\Kalpesh_selenium\\11th_march_Poi.xlsx";
		//   2.  to make a file
		File file=new File(filepath);
		// to open aexcel file

		XSSFWorkbook workbook=new XSSFWorkbook(file);
		//  3.to get a sheet.
		Sheet sheet=workbook.getSheet("sheet3");
		//4.to get a no of row
		int n_row=sheet.getPhysicalNumberOfRows();
		System.out.println("total no of rows are: "+n_row);
		
		
		//5. to set no of row using jagged array.
		data=new Object[n_row][];
		
		
		for (int i = 0; i < data.length; i++) {
			//6. to select particular row
			Row row =sheet.getRow(i);
			//7. no of the colunm in each row
			int n_col=row.getPhysicalNumberOfCells();
			System.out.println("total no of column are: "+n_col);
			//8. set no of col in each row
			data[i]=new Object[n_col];
			
			for (int j = 0; j < data[i].length; j++) {
				//9. to select particular row
		Cell cell= row.getCell(j);
				
				//10.to set cell type
				cell.setCellType(CellType.STRING);
				//11. to get adata from particulare cell
				data[i][j]=cell.getStringCellValue();
			}
			}
			
		
		return data;
	}
	WebDriver driver= null;
	@Test(dataProvider = "kalpesh")
	public void test(String keyword,String data) throws Exception {
		System.setProperty("webdriver.edge.driver", "C:\\Kalpesh_selenium\\BrowserDrivers\\msedgedriver.exe");
		// Object[][] data1=readExcel();
		 
			if (keyword.equals("open browser")) {
				 driver=new EdgeDriver();
				 Thread.sleep(2000);
				
			}else if (keyword.equals("enter url")) {
				driver.get(data);
				Thread.sleep(2000);
				
				
			}else if (keyword.equals("enter username")) {
				driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(data);
				Thread.sleep(2000);
			}else if (keyword.equals("enter password")) {
				driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(data);
				Thread.sleep(2000);
				
			}else if (keyword.equals("click login ")) {
				driver.findElement(By.id("login-button")).click();
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
					
					driver.findElement(By.id("logout_sidebar_link")).click();
					Thread.sleep(2000); // 7 logout page
					
			}else if (keyword.equals("close browser")) {
		
				driver.close();
				Thread.sleep(2000);
				
			}
		
		  
		 }	
		


}
