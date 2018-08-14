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

/**
 * Created by stn on 10/4/2016.
 */
public class AssignmentOperations {
    public List<ExcelOperation> Assignmentlist = new ArrayList<ExcelOperation>();
    int totalNumberOfdata;
    public  WebDriver driver;
    //WebDriver driver= CompanyOperations.driver;

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
        XSSFSheet sheet = workbook.getSheet("Assignment");

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
            user.Code = row.getCell(0) == null ? "" : row.getCell(0).getStringCellValue();
            user.Company = row.getCell(1) == null ? "" : row.getCell(1).getStringCellValue();
            user.Type = row.getCell(2) == null ? "" : row.getCell(2).getStringCellValue();
            user.Hire_date = row.getCell(3) == null ? "" : row.getCell(3).getStringCellValue();
            user.Company_Status = row.getCell(4) == null ? null : row.getCell(4).getStringCellValue();
            user.Completion_date = row.getCell(5) == null ? "" : row.getCell(5).getStringCellValue();
            user.Reminder_date = row.getCell(6) == null ? "" : row.getCell(6).getStringCellValue();
            user.Valuation_date = row.getCell(7) == null ? "" : row.getCell(7).getStringCellValue();
            user.Invoice = row.getCell(8) == null ? "" : row.getCell(8).getStringCellValue();
            user.Legal_counsel= row.getCell(9) == null ? "" : row.getCell(9).getStringCellValue();
            user.Auditor= row.getCell(10) == null ? "" : row.getCell(10).getStringCellValue();
            user.Lead= row.getCell(11) == null ? "" : row.getCell(11).getStringCellValue();
            user.Support= row.getCell(12) == null ? "" : row.getCell(12).getStringCellValue();
            user.Company_Primary_contact= row.getCell(13) == null ? "" : row.getCell(13).getStringCellValue();
            user.Other_contact= row.getCell(14) == null ? "" : row.getCell(14).getStringCellValue();
            user.Company_Notes= row.getCell(15) == null ? "" : row.getCell(15).getStringCellValue();
            Assignmentlist.add(user);
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
    public void AssignmnetCreation() throws InterruptedException{
        for(int i=0; i<=totalNumberOfdata-1; i++){
            String Code=Assignmentlist.get(i).Code;
            String Company=Assignmentlist.get(i).Company;
            String Type=Assignmentlist.get(i).Type;
            String Hire_date=Assignmentlist.get(i).Hire_date;
            String Company_Status=Assignmentlist.get(i).Company_Status;
            String Completion_date=Assignmentlist.get(i).Completion_date;
            String Reminder_date=Assignmentlist.get(i).Reminder_date;
            String Valuation_date=Assignmentlist.get(i).Valuation_date;
            String Invoice=Assignmentlist.get(i).Invoice;
            String Legal_counsel=Assignmentlist.get(i).Legal_counsel;
            String Auditor=Assignmentlist.get(i).Auditor;
            String Lead=Assignmentlist.get(i).Lead;
            String Support=Assignmentlist.get(i).Support;
            String Company_Primary_contact=Assignmentlist.get(i).Company_Primary_contact;
            String Other_contact=Assignmentlist.get(i).Other_contact;
            String Company_Notes=Assignmentlist.get(i).Company_Notes;


            Assignment object= new Assignment();
            object.CreateAssignment(driver, Code, Company, Type, Hire_date, Company_Status, Completion_date, Reminder_date, Valuation_date, Invoice, Legal_counsel,
                    Auditor, Lead, Support, Company_Primary_contact, Other_contact, Company_Notes);
        }

    }

    @Test(priority=3)
    public void SignOut() throws InterruptedException{
        Functions object= new Functions();
        object.SignOut(driver);
    }

}
