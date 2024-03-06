package snapdeal;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverSetup 
{
	public static WebDriver driver;
	public static WebDriver LoadBrowser()
	{
	System.out.print("Enter 1 for Chrome \nEnter 2 for Edge");
	Scanner sc=new Scanner(System.in);
	int num=sc.nextInt();
	System.out.println("Browser Loading......");
	if(num==1)
	{
		 driver=new ChromeDriver();
	}
	else if(num==2)
	{
		 driver=new EdgeDriver();
	}
	System.out.println("Browser Opened Successfully");
	return driver;
	}
}
