package anviliqPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;


@Test
public class MainMethod {



    public void openBrowser() throws InterruptedException{
            WebDriver driver=new ChromeDriver();
            String url="http://192.168.11.54:8080/anviliq/";
            driver.get(url);
            Thread.sleep(1000);
            driver.manage().window().maximize();
            Reporter.log("Home page is launched");
            Thread.sleep(1000);
            }



}



/**
 * Created by Sakib on 10/2/2016.
 */





//    @Test(priority = 1)

//    public void chromeStart() {
//
//        WebDriver driver = new ChromeDriver();
//        String url = "https://www.google.com.bd";
//        driver.get(url);
//    }


