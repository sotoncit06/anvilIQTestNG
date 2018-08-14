package anviliqPackage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Date;

public class Company {
	String Company_name, Client_type, Client_no, Industry, Status, Refered_by, Primary_contact, Investors, Notes;
	String Prospect_date, Company_type;

	public void CreateCompany_Client(WebDriver driver,String Company_name, String Client_type, String Client_no, String Industry, String Status, String Refered_by, String Primary_contact, String Investors, String Notes ) throws InterruptedException{

		//System.out.println("Inside company");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/nav/div/div[2]/ul/li[2]/a/span[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("span.glyphicons.glyphicons-plus")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("field_companyName")).sendKeys(Company_name);
		Thread.sleep(1000);
		driver.findElement(By.id("field_anvilType")).sendKeys(Client_type);
		Thread.sleep(1000);
		driver.findElement(By.id("field_clientNo")).sendKeys(Client_no);
		Thread.sleep(1000);
		driver.findElement(By.id("field_industry")).sendKeys(Industry);
		Thread.sleep(1000);
		driver.findElement(By.id("field_status")).sendKeys(Status);
		Thread.sleep(1000);
		if(Refered_by.equals("")){
			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Refered_by);
			Thread.sleep(1000);
		}
		else{
			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Refered_by);
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.sendKeys(driver.findElement(By.xpath("//input[@type='search']")), Keys.ENTER).build().perform();
			Thread.sleep(1000);
		}
		driver.findElement(By.id("field_primaryContact")).sendKeys(Primary_contact);
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.sendKeys(driver.findElement(By.id("field_primaryContact")), Keys.ENTER).build().perform();
		Thread.sleep(1000);
		if(Investors.equals("")){
			driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Investors);
			Thread.sleep(1000);
		}
		else {
			driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Investors);
			Thread.sleep(1000);
			action.sendKeys(driver.findElement(By.xpath("(//input[@type='search'])[2]")), Keys.ENTER).build().perform();
		}

		driver.findElement(By.id("field_notes")).sendKeys(Notes);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		Assert.assertEquals(Company_name, Company_name, "anviliqPackage.Company exists");
		System.out.println(Company_name + " created");
		Reporter.log(Company_name + " created");
		Thread.sleep(4000);
	}


	public void CreateCompany_Prospect(WebDriver driver,String Company_name, String Client_type, String Prospect_date, String Industry, String Status, String Refered_by, String Primary_contact, String Notes ) throws InterruptedException{
		//System.out.println("Inside company");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/nav/div/div[2]/ul/li[2]/a/span[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("span.glyphicons.glyphicons-plus")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("field_companyName")).sendKeys(Company_name);
		Thread.sleep(1000);
		driver.findElement(By.id("field_anvilType")).sendKeys(Client_type);
		Thread.sleep(1000);
		driver.findElement(By.id("field_prospectDate")).sendKeys(Prospect_date);
		Thread.sleep(1000);
		driver.findElement(By.id("field_industry")).sendKeys(Industry);
		Thread.sleep(1000);
		driver.findElement(By.id("field_status")).sendKeys(Status);
		Thread.sleep(1000);
		if(Refered_by.equals("")){
			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Refered_by);
			Thread.sleep(2000);
		}
		else{
			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Refered_by);
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			action.sendKeys(driver.findElement(By.xpath("//input[@type='search']")), Keys.ENTER).build().perform();
			Thread.sleep(1000);
		}
		driver.findElement(By.id("field_primaryContact")).sendKeys(Primary_contact);
		Thread.sleep(1000);
		driver.findElement(By.id("field_notes")).sendKeys(Notes);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

/*		Thread.sleep(5000);
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		screenshot.renameTo(new File(".\\image\\Company.png"));*/

		Assert.assertEquals(Company_name, Company_name, "anviliqPackage.Company exists");
		System.out.println(Company_name + " created");
		Reporter.log(Company_name + " created");
		Thread.sleep(5000);
	}

	public void CreateCompany_other(WebDriver driver,String Company_name, String Client_type,String Company_type,String Primary_contact,String Notes) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/nav/div/div[2]/ul/li[2]/a/span[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("span.glyphicons.glyphicons-plus")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("field_companyName")).sendKeys(Company_name);
		Thread.sleep(1000);
		driver.findElement(By.id("field_anvilType")).sendKeys(Client_type);
		Thread.sleep(1000);
		driver.findElement(By.id("field_companyType")).sendKeys(Company_type);
		Thread.sleep(1000);
		driver.findElement(By.id("field_primaryContact")).sendKeys(Primary_contact);
		Thread.sleep(1000);
		driver.findElement(By.id("field_notes")).sendKeys(Notes);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

/*		Thread.sleep(5000);
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		screenshot.renameTo(new File(".\\image\\Company.png"));*/

		Assert.assertEquals(Company_name, Company_name, "anviliqPackage.Company exists");
		System.out.println(Company_name + " created");
		Reporter.log(Company_name + " created");
		Thread.sleep(4000);
	}

	public void EditCompany(WebDriver driver){

	}
}
