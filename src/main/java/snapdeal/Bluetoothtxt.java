package snapdeal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Bluetoothtxt 
{
	private TakesScreenshot driver;
	@Test
	public void snapf(WebDriver driver)
	{
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	public void Headphone(WebDriver driver) throws IOException
	{
		// Enter the Text in Search Box
		
		WebElement textbox =driver.findElement(By.name("keyword"));
		textbox.sendKeys("Bluetooth Headphone");
	    TakesScreenshot ts=((TakesScreenshot)driver);
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		File trgfile= new File("C:\\Users\\2303985\\eclipse-workspace\\snapdeal\\Screenshot\\searchtext.png");
		FileUtils.copyFile(srcfile, trgfile);
		WebElement searchbutton = driver.findElement(By.className("searchTextSpan"));
	    searchbutton.click();

	}
	public void sortf(WebDriver driver) throws IOException
	{
		
		WebElement sortby = driver.findElement(By.xpath("//*[@id='content_wrapper']/div[7]/div[5]/div[3]/div[1]/div/div[2]/div/i"));
		sortby.click();
		WebElement pop = driver.findElement(By.xpath("//*[@id='content_wrapper']/div[7]/div[5]/div[3]/div[1]/div/div[2]/ul/li[2]"));
		pop.click();
		TakesScreenshot ts=((TakesScreenshot)driver);
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		File trgfile= new File("C:\\Users\\2303985\\eclipse-workspace\\snapdeal\\Screenshot\\Sortby.png");
		FileUtils.copyFile(srcfile, trgfile);
	}	
		
	public void lowf(WebDriver driver)
	{
		WebElement lowp=driver.findElement(By.name("fromVal"));
		lowp.clear();
		lowp.sendKeys("700");
		String lowprint=driver.findElement(By.name("fromVal")).getAttribute("value");
		System.out.print("Starting Price :"+lowprint+"\n");
	}
	
	public void highf(WebDriver driver) throws IOException
	{
		WebElement highp=driver.findElement(By.name("toVal"));
		highp.clear();
		highp.sendKeys("1400");
		String highprint=driver.findElement(By.name("toVal")).getAttribute("value");
		System.out.print("Ending Price :"+highprint+"\n");
		
		
		TakesScreenshot ts=((TakesScreenshot)driver);
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		File trgfile= new File("C:\\Users\\2303985\\eclipse-workspace\\snapdeal\\Screenshot\\Price.png");
		FileUtils.copyFile(srcfile, trgfile);
	}
	
	public void gof(WebDriver driver) throws IOException, InterruptedException
	{
		WebElement go=driver.findElement(By.xpath("//*[@id='content_wrapper']/div[7]/div[4]/div/div[1]/div[2]/div[2]/div[3]/div/div[5]"));
		go.click();
		
		Thread.sleep(10000);
		String resulttext=driver.findElement(By.className("nnn")).getText();
		System.out.print(resulttext);
		System.out.print("\n");
		
		
		JavascriptExecutor js1=(JavascriptExecutor) driver;
		List<WebElement> prices=(driver.findElements(By.xpath("//p[contains(@class,'product-title')]")));
		List<WebElement> names=(driver.findElements(By.xpath("//span[contains(@class,'lfloat product-price')]")));
		String[] name=new String[20];
		String[] price=new String[5];
		
		
		for(int i=0;i<5;i++)
		{
			String text =(String)js1.executeScript("return arguments[0].innerText;", prices.get(i));
			name[i]=text;
			
			String text1 =(String)js1.executeScript("return arguments[0].innerText;", names.get(i));
			price[i]=text1;
			
			System.out.print(price[i]+" "+name[i]+" "+"\n");
			
		}
		
		TakesScreenshot ts=((TakesScreenshot)driver);
		File srcfile1=ts.getScreenshotAs(OutputType.FILE);
		File trgfile1= new File("C:\\Users\\2303985\\eclipse-workspace\\snapdeal\\Screenshot\\Final.png");
		FileUtils.copyFile(srcfile1, trgfile1);
		FileOutputStream exe=new FileOutputStream(System.getProperty("user.dir")+"\\target\\MiniProject.xlsx");
		XSSFWorkbook book=new XSSFWorkbook();
		XSSFSheet sheet=book.createSheet("sheet1");
		for(int i=0;i<5;i++)
		{
			XSSFRow row=sheet.createRow(i);
			XSSFCell cell=row.createCell(0);
			XSSFCell cell1=row.createCell(1);
			cell1.setCellValue(name[i]);
			cell.setCellValue(price[i]);
		}
		book.write(exe);
		book.close();
		exe.close();
		
	}
	
		
}
	
