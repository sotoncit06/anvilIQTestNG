package anviliqPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class People {


	public void CreatePeople(WebDriver driver, String first_name, String last_name, String company, String title, String startDate, String email, String phone, String exCompany, String notes ) throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[4]/a/span[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("span.glyphicons.glyphicons-plus")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("field_first_name")).sendKeys(first_name);
		Thread.sleep(1000);
		driver.findElement(By.id("field_last_name")).sendKeys(last_name);
		driver.findElement(By.id("field_company")).sendKeys(company);
		driver.findElement(By.id("field_title")).sendKeys(title);
        //driver.findElement(By.id("field_startDate")).sendKeys(startDate);
		driver.findElement(By.id("field_email")).sendKeys(email);
		driver.findElement(By.id("field_phone")).sendKeys(phone);
		driver.findElement(By.id("field_notes")).sendKeys(notes);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		System.out.println("New anviliqPackage.People"+ first_name + last_name + " is created");
		Reporter.log("\n New anviliqPackage.People"+ first_name + last_name + " is created");
		
	}
	
	public void EditPeople(WebDriver driver) throws InterruptedException{
		
	}
}
