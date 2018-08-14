package anviliqPackage;

import com.sun.jna.platform.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.Select;
import java.io.File;

/**
 * Created by Sakib on 10/3/2016.
 */
public class Billing {

    public void createBill(WebDriver driver,String assignment,String fee,String invoice1_date,String reminder1_date,String payment1_date,String invoice2_date,String reminder2_date,String payment2_date,String performance) throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[contains(@href, '#/billing')])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span.glyphicons.glyphicons-plus")).click();
        Thread.sleep(2000);
        new Select(driver.findElement(By.id("field_assignment"))).selectByVisibleText(assignment);
        Thread.sleep(1000);
        driver.findElement(By.id("field_fee")).clear();
        driver.findElement(By.id("field_fee")).sendKeys(fee);

        driver.findElement(By.id("field_invoice1Date")).clear();
        driver.findElement(By.id("field_invoice1Date")).sendKeys(invoice1_date);
        driver.findElement(By.id("field_reminder1Date")).clear();
        driver.findElement(By.id("field_reminder1Date")).sendKeys(reminder1_date);
        driver.findElement(By.id("field_payment1Date")).clear();
        driver.findElement(By.id("field_payment1Date")).sendKeys(payment1_date);

        driver.findElement(By.id("field_invoice2Date")).clear();
        driver.findElement(By.id("field_invoice2Date")).sendKeys(invoice2_date);
        driver.findElement(By.id("field_reminder2Date")).clear();
        driver.findElement(By.id("field_reminder2Date")).sendKeys(reminder2_date);
        driver.findElement(By.id("field_payment2Date")).clear();
        driver.findElement(By.id("field_payment2Date")).sendKeys(payment2_date);

        driver.findElement(By.id("field_performance")).clear();
        driver.findElement(By.id("field_performance")).sendKeys(performance);
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();


        Thread.sleep(5000);
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
        screenshot.renameTo(new File(".\\image\\billings.png"));

    }


}
