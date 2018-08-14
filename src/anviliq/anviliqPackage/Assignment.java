package anviliqPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment {
	String Code, Company,Type, Hire_date, Status, Completion_date,Reminder_type, Valuation_date,Invoice, Legal_counsel, Auditor, Lead, Support,Primary_contact, Other_contact, Notes;
	public void CreateAssignment(WebDriver driver, String Code, String Company, String Type, String Hire_date, String Status, String Completion_date, String Reminder_date, String Valuation_date, String Invoice, String Legal_counsel, String Auditor, String Lead, String Support, String Primary_contact, String Other_contact, String Notes ) throws InterruptedException{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[3]/a/span[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("span.glyphicons.glyphicons-plus")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("field_assignmentCode")).sendKeys(Code);
		Thread.sleep(1000);
		driver.findElement(By.id("field_company")).sendKeys(Company);
		Thread.sleep(1000);
		driver.findElement(By.id("field_assignmentType")).sendKeys(Type);
		Thread.sleep(1000);
		driver.findElement(By.id("field_hireDate")).sendKeys(Hire_date);
		Thread.sleep(1000);
		driver.findElement(By.id("field_assignmentStatus")).sendKeys(Status);
		driver.findElement(By.id("field_completionDate")).sendKeys(Completion_date);
		if (Completion_date.equals("")){
			driver.findElement(By.id("field_completionDate")).sendKeys(Completion_date);
			Thread.sleep(1000);
		}
		else{

			driver.findElement(By.id("field_completionDate")).sendKeys(Completion_date);
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.sendKeys(driver.findElement(By.id("field_completionDate")), Keys.ENTER).build().perform();
			Thread.sleep(1000);
		}

		Actions action = new Actions(driver);
		driver.findElement(By.id("field_reminderType")).sendKeys(Reminder_date);
		Thread.sleep(1000);
		action.sendKeys(driver.findElement(By.id("field_reminderType")), Keys.ENTER).build().perform();
		Thread.sleep(1000);


		if (Valuation_date.equals("")){
			driver.findElement(By.id("field_valuationDate")).sendKeys(Valuation_date);
			Thread.sleep(1000);
		}
		else{

			driver.findElement(By.id("field_valuationDate")).sendKeys(Valuation_date);
			Thread.sleep(1000);
			action.sendKeys(driver.findElement(By.id("field_valuationDate")), Keys.ENTER).build().perform();
			Thread.sleep(1000);
		}

		driver.findElement(By.id("field_invoiceType")).sendKeys(Invoice);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Legal_counsel);
		Thread.sleep(1000);

		action.sendKeys(driver.findElement(By.xpath("//input[@type='search']")), Keys.ENTER).build().perform();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Auditor);
		Thread.sleep(1000);

		action.sendKeys(driver.findElement(By.xpath("(//input[@type='search'])[2]")), Keys.ENTER).build().perform();
		Thread.sleep(1000);

		driver.findElement(By.id("field_lead")).sendKeys(Lead);
		Thread.sleep(1000);
		if(Support.equals("")) {
			driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys(Support);
			Thread.sleep(1000);
		}
		else{
			driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys(Support);
			Thread.sleep(1000);
			action.sendKeys(driver.findElement(By.xpath("(//input[@type='search'])[3]")), Keys.ENTER).build().perform();
		}
		driver.findElement(By.id("field_primaryContact")).sendKeys(Primary_contact);
		Thread.sleep(1000);
		if(Other_contact.equals("")){
			driver.findElement(By.xpath("(//input[@type='search'])[4]")).sendKeys(Other_contact);
			Thread.sleep(1000);
		}
		else{
			driver.findElement(By.xpath("(//input[@type='search'])[4]")).sendKeys(Other_contact);
			Thread.sleep(1000);
			action.sendKeys(driver.findElement(By.xpath("(//input[@type='search'])[4]")), Keys.ENTER).build().perform();
		}
		driver.findElement(By.id("field_notes")).sendKeys(Notes);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		Thread.sleep(2000);
		System.out.println(Code + " Assignment created");
/*		WebDriver augmentedDriver = new Augmenter().augment(driver);
		File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		screenshot.renameTo(new File(".\\image\\People.png"));*/
	}

	public void EditAssignment(WebDriver driver) throws InterruptedException{

	}
}
