package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IpRegistration {
	public static void main(String[] args) throws InterruptedException {
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

		// going to OP registration page.

		driver.findElement(By.xpath("//div[@class='ui sc-ihiiSJ hHKVBm menu']//a[1]")).click();
		driver.findElement(By.xpath("//div[@class='sc-imapFV gzkuNb']//div[2]//div[2]//div[2]//div[1]//a[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// finding all mandatory fields.

		Select salutation = new Select(driver.findElement(By.id("salutation")));
		WebElement firstName = driver.findElement(By.id("patient_name"));
		WebElement lastName = driver.findElement(By.id("last_name"));
		WebElement phoneNumber = driver.findElement(By.id("patient_phone_national"));
		WebElement date = driver.findElement(By.name("dobDay"));
		WebElement month = driver.findElement(By.name("dobMonth"));
		WebElement year = driver.findElement(By.name("dobYear"));
		Select gender = new Select(driver.findElement(By.id("patient_gender")));
		Select category = new Select(driver.findElement(By.id("patient_category_id")));
		Select religion = new Select(driver.findElement(By.id("custom_list2_value")));
		Select race = new Select(driver.findElement(By.id("custom_list4_value")));
		WebElement emailId = driver.findElement(By.id("email_id"));
		Select ratePlan = new Select(driver.findElement(By.id("organization")));
		Select deptName = new Select(driver.findElement(By.id("dept_name")));
		WebElement doctorName = driver.findElement(By.id("doctor_name"));
		Select bedType = new Select(driver.findElement(By.id("bed_type")));
		Select wardId = new Select(driver.findElement(By.id("ward_id")));
		Select bedId = new Select(driver.findElement(By.id("bed_id")));
		Select dutyDoctor = new Select(driver.findElement(By.name("duty_doctor_id")));
		WebElement registerButton = driver.findElement(By.id("registerBtn"));

		// filling in details of patient.

		salutation.selectByVisibleText("Mr.");
		firstName.sendKeys("firstName1");
		lastName.sendKeys("lastName1");
		phoneNumber.sendKeys("512345678");
		date.sendKeys("10");
		month.sendKeys("10");
		year.sendKeys("1992");
		gender.selectByVisibleText("Male");
		category.selectByVisibleText("General");
		religion.selectByVisibleText("Islam");
		race.selectByVisibleText("AB");
		emailId.sendKeys("example1@example.org");
		ratePlan.selectByVisibleText("ABU DHABI PLAN");
		deptName.selectByVisibleText("22");
		doctorName.sendKeys("Aaa (22)(2323)");
		for (int i = 0; i < 5; i++) {
			doctorName.sendKeys(Keys.ENTER);
		}
		bedType.selectByVisibleText("GENERAL WARD");
		wardId.selectByVisibleText("DAY");
		bedId.selectByVisibleText("GENERAL WARD2");
		dutyDoctor.selectByVisibleText("Aaa");
		registerButton.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.close();
		System.out.println("Assignment 3 Complete.");
	}
}