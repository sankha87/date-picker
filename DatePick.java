package datePicker;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IRCTC{
	public static void main(String[] args) throws InterruptedException {
		String month = "December";
		System.setProperty("webdriver.chrome.driver", "C:\\browser drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.id("jDate")).click();
		Thread.sleep(3000);
		while(true) {
		try {
				driver.findElement(By.xpath("//span[text()='"+month+
						"']/../../following-sibling::div/table/tbody/tr/td/a[text()='31']")).click();
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("//span[contains(@class,'ui-datepicker-next')]")).click();
		}
		}		
	}
}
