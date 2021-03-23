package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OpRegistration {
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
		driver.findElement(By.xpath("//div[@class='sc-imapFV gzkuNb']//div[2]//div[2]//div[2]//div[2]")).click();
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
		Select bloodGroup = new Select(driver.findElement(By.id("custom_list3_value")));
		WebElement addDiagnosis = driver.findElement(By.id("btnAddDiagnosis"));
		WebElement diagnosisCode = driver.findElement(By.id("d_diagnosis_code"));
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
		bloodGroup.selectByVisibleText("A-");
		addDiagnosis.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement cancelButton = driver.findElement(By.id("d_diagnosis_cancel_btn"));
		WebElement addButton = driver.findElement(By.id("d_diagnosis_add_btn"));
		diagnosisCode.sendKeys("123.1");
		diagnosisCode.sendKeys(Keys.ENTER);
		driver.switchTo().alert().accept();
		addButton.click();
		driver.switchTo().alert().accept();
		diagnosisCode.sendKeys(Keys.ENTER);
		diagnosisCode.sendKeys(Keys.ENTER);
		driver.switchTo().alert().accept();
		cancelButton.click();
		registerButton.click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// checking if registration successful.

		WebElement header = driver.findElement(By.xpath("//div[@id='content']//h1[1]"));
		String title = header.getText();
		if (title.equals("Registration Success")) {
			System.out.println("Success");
		}

		driver.close();
		System.out.println("Assignment 2 Complete.");
	}
}