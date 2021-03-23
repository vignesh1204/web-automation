package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String baseUrl = "http://172.16.18.24/instahms1203/";
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement hospitalName = driver.findElement(By.name("hospital"));
		WebElement username = driver.findElement(By.name("userId"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.id("login"));

		hospitalName.sendKeys("gcc");
		username.sendKeys("sateesh");
		password.sendKeys("1234");

		login.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.close();
		System.out.println("First Test Complete.");
	}
}