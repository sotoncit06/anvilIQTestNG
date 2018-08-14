package anviliqPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FirstTestNGFile {
	//private WebDriver driver;
	public static String url="http://192.168.11.54:8080/anviliq/";
	public String title;
	public static WebDriver driver=new ChromeDriver();
/*	@Test
	public void GeneralTest() throws InterruptedException{
	
		driver.get(url);
		anviliqPackage.PeopleOperations object= new anviliqPackage.PeopleOperations(driver);

}*/
	
/*	@Parameters({ "browser" })
	@BeforeTest
public void openBrowser(String browser) {
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.firefox.driver",
						"C:/Driver/firefox/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:/Driver/Chrome/chromedriver.exe");
				driver = new ChromeDriver();
			}else if (browser.equalsIgnoreCase("opera")) {
				System.setProperty("webdriver.opera.driver",
						"C:/Driver/Opera/operadriver.exe");
					driver = new OperaDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						"C:/Driver/Internet explorer/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}
*/

	public void openBrowser() throws InterruptedException{
	driver.get(url);
	Thread.sleep(1000);
	driver.manage().window().maximize();
	Reporter.log("Home page is launched");
	Thread.sleep(1000);
	}
	@Test(priority=1)
	public void ForgetPassword() throws InterruptedException{
		Functions object= new Functions();
		object.ForgetPassword(driver);	
	}
	@Test(priority=1)
	public void SignIn() throws InterruptedException{
		String user_name = "admin";
		String password = "admin";
		Functions object= new Functions();
		object.SignIn(driver, user_name, password);
	  
	}
	
/*	@Test(priority=2)
	public void CreateCompany() throws InterruptedException{
		String Company_name="Company3", Client_type="Client", Client_no="1221B", Industry="Internet", Status="Active", Refered_by="tanim1 hasan", Primary_contact="tanim1 hasan", Investors="", Notes="";
		Company object= new Company();
		object.CreateCompany(driver, Company_name, Client_type, Client_no, Industry, Status, Refered_by, Primary_contact, Investors, Notes);
	}*/

	@Test(priority=3)
	public void SignOut() throws InterruptedException{
		Functions object= new Functions();
		object.SignOut(driver);
	}

}
