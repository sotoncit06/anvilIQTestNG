package anviliqPackage;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeopleOperations{


    public List<ExcelOperation> peopleList = new ArrayList<ExcelOperation>();
    public List<ExcelOperation> loginCredenbtialList = new ArrayList<ExcelOperation>();
    int totalNumberOfDdataInPeopleSheet;
    int totalNumberOfDdataInLoginSheet;
	public WebDriver driver;

    @BeforeSuite
	public void openBrowser() throws InterruptedException{
        driver=new ChromeDriver();
		//String url="http://192.168.11.54:8080/anviliq/";
        String url="https://sft.tractable.com/anviliq/#/login";
		driver.get(url);
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Reporter.log("Home page is launched");
		Thread.sleep(1000);
	}

    @BeforeTest
    public void readExcel() throws IOException {
        InputStream file = this.getClass().getResourceAsStream("/excel/Anvil.xlsx");

//Get the workbook instance for XLS file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

//Get People sheet from the workbook
        XSSFSheet peopleSheet = workbook.getSheet("People");

//Get Login info sheet from the workbook
        XSSFSheet loginSheet = workbook.getSheet("Login info");

//Get iterator to all the rows in people Sheet
        Iterator<Row> peopleSheetRowIterator = peopleSheet.iterator();
        totalNumberOfDdataInPeopleSheet = peopleSheet.getLastRowNum();

//Get iterator to all the rows in loginSheet
        Iterator<Row> loginSheetRowIterator = loginSheet.iterator();
        totalNumberOfDdataInLoginSheet = loginSheet.getLastRowNum();

// Assign data to ExcelOperation object for PeopleSheet
        ExcelOperation people;
        while (peopleSheetRowIterator.hasNext()) {
            Row peopleRow = peopleSheetRowIterator.next();
            if (peopleRow.getRowNum() == 0) {
                continue;
            }

            people = new ExcelOperation();
            people.userFname = peopleRow.getCell(0) == null ? "" : peopleRow.getCell(0).getStringCellValue();
            people.userLname = peopleRow.getCell(1) == null ? "" : peopleRow.getCell(1).getStringCellValue();
            people.companyName = peopleRow.getCell(2) == null ? "" : peopleRow.getCell(2).getStringCellValue();
            people.title = peopleRow.getCell(3) == null ? "" : peopleRow.getCell(3).getStringCellValue();
            people.startDate = peopleRow.getCell(4) == null ? null : peopleRow.getCell(4).getDateCellValue();
            people.email = peopleRow.getCell(5) == null ? "" : peopleRow.getCell(5).getStringCellValue();

            if(peopleRow.getCell(6) != null){

                peopleRow.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
            }

            people.phone = peopleRow.getCell(6) == null ? "" : peopleRow.getCell(6).getStringCellValue();
            people.exCompany = peopleRow.getCell(7) == null ? "" : peopleRow.getCell(7).getStringCellValue();
            people.note = peopleRow.getCell(8) == null ? "" : peopleRow.getCell(8).getStringCellValue();
            peopleList.add(people);

        }

// Assign data to ExcelOperation object for Login sheet
        ExcelOperation loginUser;
        while (loginSheetRowIterator.hasNext()) {
            Row loginInfoRow = loginSheetRowIterator.next();
            if (loginInfoRow.getRowNum() == 0) {
                continue;
            }

            loginUser = new ExcelOperation();
            loginUser.loginUserName = loginInfoRow.getCell(0).getStringCellValue(); // for admin user
            loginUser.passwordForUser = loginInfoRow.getCell(1).getStringCellValue(); // for admin user
            loginCredenbtialList.add(loginUser);

        }


    }


	@Test(priority = 1)
	public void SignIn() throws InterruptedException{
		String user_name = loginCredenbtialList.get(0).getLoginUserName();
		String password = loginCredenbtialList.get(0).getPasswordForUser();
		Functions object= new Functions();
		object.SignIn(driver, user_name, password);
	  }


	@Test (priority = 2)
	public void CreatePeople() throws InterruptedException{
		for (int i = 0; i <= totalNumberOfDdataInPeopleSheet -1; i++) {

			String f_name = peopleList.get(i).getUserFname();
			String l_name = peopleList.get(i).getUserLname();
			String company = peopleList.get(i).getCompanyName();
            String title = peopleList.get(i).getTitle();
            String startDate =  "";
            if (peopleList.get(i).getStartDate() != null) {
               Format formatter = new SimpleDateFormat("dd-MM-yyyy");
                startDate = formatter.format(peopleList.get(i).getStartDate());
           }

			String email = peopleList.get(i).getEmail();
            String phone = peopleList.get(i).getPhone();
            String exCompany = peopleList.get(i).getExCompany();
            String notes = peopleList.get(i).getNote();
			People people = new People();
			people.CreatePeople(driver, f_name, l_name, company, title, startDate, email, phone, exCompany, notes);

            WebDriver augmentedDriver = new Augmenter().augment(driver);
            File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
            screenshot.renameTo(new File(".\\image\\createdPeople.png"));
		}
	}
////
//	@Test(priority=3)
//	public void SignOut() throws InterruptedException{
//		Functions object= new Functions();
//		object.SignOut(driver);
//	}
}

