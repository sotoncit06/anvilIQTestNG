package anviliqPackage; /**
 * Created by Sakib on 10/2/2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ModuleList {
    String u_name, passwd;
    @Test
    public void SignIn(WebDriver driver,String u_name,String passwd) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("username")).sendKeys(u_name);
        driver.findElement(By.id("password")).sendKeys(passwd);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/button")).click();
        Thread.sleep(1000);
        Reporter.log(u_name + "User has logged in");
        System.out.println(u_name + " User has logged in");
        Assert.assertEquals("Anvil IQ", driver.getTitle(), "Title Does not matched");
    }


    @Test
    public void SignOut(WebDriver driver) throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='account-menu']/span/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='logout']/span[2]")).click();
        System.out.println("User has logged Out");
        Thread.sleep(1000);
        Reporter.log("Admin User has logged out");
    }

    @Test
    public void ForgetPassword(WebDriver driver) throws InterruptedException{
        driver.findElement(By.linkText("Forgot your password?")).click();
        Reporter.log("Forget Password page appears");
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys("tanim1@nilavodev.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Mail is sent for password recovery");
        Reporter.log("Mail is sent to tanim1@nilavodev.com");
        driver.navigate().back();
    }
}
