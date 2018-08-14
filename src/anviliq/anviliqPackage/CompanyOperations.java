package anviliqPackage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompanyOperations {
	public List<ExcelOperation> companylist = new ArrayList<ExcelOperation>();
	int totalNumberOfdata;
	public  WebDriver driver;

	@BeforeSuite
	public void openBrowser() throws InterruptedException{
		driver=new ChromeDriver();
		String url="http://192.168.11.54:8080/anviliq/";
		//String url="https://sft.tractable.com/anviliq/#/login";
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

//Get  sheet from the workbook
		XSSFSheet sheet = workbook.getSheet("Companies");

//Get iterator to all the rows in current sheet
		Iterator<Row> rowIterator = sheet.iterator();
		totalNumberOfdata = sheet.getLastRowNum();

		ExcelOperation user;

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			if (row.getRowNum() == 0) {
				continue;
			}
			user = new ExcelOperation();
			user.Company_name = row.getCell(0) == null ? "" : row.getCell(0).getStringCellValue();
			user.Client_type = row.getCell(1) == null ? "" : row.getCell(1).getStringCellValue();
			user.Client_no = row.getCell(2) == null ? "" : row.getCell(2).getStringCellValue();
			user.Industry = row.getCell(3) == null ? "" : row.getCell(3).getStringCellValue();
			user.Status = row.getCell(4) == null ? null : row.getCell(4).getStringCellValue();
			user.Refered_by = row.getCell(5) == null ? "" : row.getCell(5).getStringCellValue();
			user.Primary_contact = row.getCell(6) == null ? "" : row.getCell(6).getStringCellValue();
			user.Investors = row.getCell(7) == null ? "" : row.getCell(7).getStringCellValue();
			user.Notes = row.getCell(8) == null ? "" : row.getCell(8).getStringCellValue();
			user.ProspctDate= row.getCell(9) == null ? "" : row.getCell(9).getStringCellValue();
			user.Company_type=row.getCell(10) == null ? "" : row.getCell(10).getStringCellValue();
			companylist.add(user);
		}

	}
	@Test(priority=1)
	public void SignIn() throws InterruptedException{
		String user_name = "admin";
		String password = "admin";
		Functions object= new Functions();
		object.SignIn(driver, user_name, password);

	}

	@Test(priority=2)
	public void CreateCompany() throws InterruptedException{
		for (int i = 0; i <= totalNumberOfdata-1; i++) {
			String Company_name = companylist.get(i).Company_name;
			String Client_type = companylist.get(i).Client_type;
			String Client_no = companylist.get(i).Client_no;
			String Industry = companylist.get(i).Industry;
			String Status = companylist.get(i).Status;
			String Refered_by = companylist.get(i).Refered_by;
			String Primary_contact = companylist.get(i).Primary_contact;
/*			String Refered_by = "";
			String Primary_contact = "";*/
			String Investors = companylist.get(i).Investors;
			String Notes = companylist.get(i).Notes;
			String Prospect_date=companylist.get(i).ProspctDate;
			String Company_type=companylist.get(i).Company_type;
			if (Client_type.equals("Client")){
				Company object = new Company();
				object.CreateCompany_Client(driver, Company_name, Client_type, Client_no, Industry, Status, Refered_by, Primary_contact, Investors, Notes);
			}
			else if (Client_type.equals("Prospect")){
				Company object1 = new Company();
				object1.CreateCompany_Prospect(driver, Company_name, Client_type, Prospect_date, Industry, Status, Refered_by, Primary_contact, Notes);
			}
			else{
				Company object2 = new Company();
				object2.CreateCompany_other(driver, Company_name, Client_type, Company_type, Primary_contact, Notes);
			}
		}
	}


	@Test(priority=3)
	public void SignOut() throws InterruptedException{
		Functions object= new Functions();
		object.SignOut(driver);
	}


}
