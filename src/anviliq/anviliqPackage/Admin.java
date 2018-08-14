package anviliqPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Reporter;

import java.io.File;
import java.util.Date;


/**
 * Created by Sakib on 10/3/2016.
 */
public class Admin {



    public void anvilType(WebDriver driver,String anvil_type)throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span > span.hidden-sm.ng-scope")).click();
        driver.findElement(By.xpath("//li[7]/ul/li/a/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span.glyphicons.glyphicons-plus")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("field_name")).clear();
        driver.findElement(By.id("field_name")).sendKeys(anvil_type);
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

        Thread.sleep(5000);
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
        screenshot.renameTo(new File(".\\image\\anvilType.png"));

    }

    public void assignmentStatus(WebDriver driver,String assignment_status)throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#admin-menu > span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[7]/ul/li[2]/a/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span.glyphicons.glyphicons-plus")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("field_name")).clear();
        driver.findElement(By.id("field_name")).sendKeys(assignment_status);
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

        Thread.sleep(5000);
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
        screenshot.renameTo(new File(".\\image\\assignmentStatus.png"));

    }

    public void assignmentType(WebDriver driver,String assignment_type)throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span > span.hidden-sm.ng-scope")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[7]/ul/li[3]/a/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span.glyphicons.glyphicons-plus")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("field_name")).clear();
        driver.findElement(By.id("field_name")).sendKeys(assignment_type);
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

        Thread.sleep(5000);
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
        screenshot.renameTo(new File(".\\image\\assignmentType.png"));
    }

    public void companyTypes(WebDriver driver,String company_type)throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span > span.hidden-sm.ng-scope")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[7]/ul/li[4]/a/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span.glyphicons.glyphicons-plus")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("field_name")).clear();
        driver.findElement(By.id("field_name")).sendKeys(company_type);
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

        Thread.sleep(5000);
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
        screenshot.renameTo(new File(".\\image\\companyType.png"));
    }

    public void industries(WebDriver driver,String industry_name)throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span > b.caret")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[7]/ul/li[5]/a/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span.glyphicons.glyphicons-plus")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("field_name")).clear();
        driver.findElement(By.id("field_name")).sendKeys(industry_name);
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

        Thread.sleep(5000);
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
        screenshot.renameTo(new File(".\\image\\industries.png"));
    }

    public void people(WebDriver driver,String people_name)throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.id("admin-menu")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[7]/ul/li[6]/a/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span.glyphicons.glyphicons-plus")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("field_name")).clear();
        driver.findElement(By.id("field_name")).sendKeys(people_name);
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

        Thread.sleep(5000);
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
        screenshot.renameTo(new File(".\\image\\people.png"));

    }

    public void createAdmin(WebDriver driver,String login_name, String first_name, String last_name, String password, String conf_passwd, String email)throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span > span.hidden-sm.ng-scope")).click();
        driver.findElement(By.xpath("//li[7]/a/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span.glyphicons.glyphicons-plus")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys(login_name);
        driver.findElement(By.name("firstName")).clear();
        driver.findElement(By.name("firstName")).sendKeys(first_name);
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys(last_name);
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirmPassword")).click();
        driver.findElement(By.name("confirmPassword")).clear();
        driver.findElement(By.name("confirmPassword")).sendKeys(conf_passwd);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

        Thread.sleep(5000);
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
        screenshot.renameTo(new File(".\\image\\createAdmin.png"));
    }

    public void createUser(WebDriver driver,String login_name, String first_name, String last_name, String password, String conf_passwd, String email)throws InterruptedException{
        driver.findElement(By.cssSelector("span > span.hidden-sm.ng-scope")).click();
        driver.findElement(By.xpath("//li[7]/a/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span.glyphicons.glyphicons-plus")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys(login_name);
        driver.findElement(By.name("firstName")).clear();
        driver.findElement(By.name("firstName")).sendKeys(first_name);
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys(last_name);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirmPassword")).clear();
        driver.findElement(By.name("confirmPassword")).sendKeys(conf_passwd);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

        Thread.sleep(5000);
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
        screenshot.renameTo(new File(".\\image\\createUser.png"));
    }

}
