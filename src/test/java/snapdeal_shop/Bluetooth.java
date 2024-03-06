package snapdeal_shop;

import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import snapdeal.Bluetoothtxt;
import snapdeal.DriverSetup;

public class Bluetooth {
	

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub	
		
		DriverSetup DS=new DriverSetup();
		WebDriver driver=DS.LoadBrowser();
		Bluetoothtxt blu = new Bluetoothtxt();
		blu.snapf(driver);
		blu.Headphone(driver);
		blu.sortf(driver);
		blu.lowf(driver);
		blu.highf(driver);
		blu.gof(driver);
		
		driver.quit();	
		
	}

}
