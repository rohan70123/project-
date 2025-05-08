package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class selenium {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","T:\\STC drivers\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://localhost/orangehrm/orangehrm-5.7/web/index.php/auth/login");
		WebElement username=driver.findElement(By.name("username"));
		WebElement password=driver.findElement(By.name("password"));
		sendkeys(driver,username,10,"admin");
		sendkeys(driver,password,20,"Rohan@321");
		WebElement Login = driver.findElement(By.xpath("//button[@type='submit']"));
		clickOn(driver,Login,10);
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input")).sendKeys("rohan");
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input")).sendKeys("madhu");
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/button")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")).click();
		WebElement firstName=driver.findElement(By.name("firstName"));
		WebElement lastName=driver.findElement(By.name("email"));
		sendkeys(driver,firstName,10,"123");
		sendkeys(driver,lastName,20,"321");
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	}
	private static void sendkeys(WebDriver driver1,WebElement element,int timeout,String value)
	{
		new WebDriverWait(driver1,timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	private static void clickOn(WebDriver driver1,WebElement element,int timeout)
	{
		new WebDriverWait(driver1,timeout).until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
}



