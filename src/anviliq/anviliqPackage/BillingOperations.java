package anviliqPackage;

import org.apache.poi.ss.usermodel.Cell;
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
 * Created by Sakib on 10/5/2016.
 */
public class BillingOperations {
    public List<ExcelOperation> billList = new ArrayList<ExcelOperation>();
    public List<ExcelOperation> loginCredentialList = new ArrayList<ExcelOperation>();
    int totalNumberOfDataInBillingSheet;
    int totalNumberOfDdataInLoginSheet;

    public WebDriver driver;

    @BeforeSuite
    public void openBrowser() throws InterruptedException {
        driver = new ChromeDriver();
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

        //Get Login info sheet from the workbook
        XSSFSheet loginSheet = workbook.getSheet("Login info");

        //Get iterator to all the rows in loginSheet
        Iterator<Row> loginSheetRowIterator = loginSheet.iterator();
        totalNumberOfDdataInLoginSheet = loginSheet.getLastRowNum();

//Get iterator to all the rows in Anvil Type sheet
        XSSFSheet billingSheet = workbook.getSheet("Billing");
        Iterator<Row> billingSheetRowIterator = billingSheet.iterator();
        totalNumberOfDataInBillingSheet = billingSheet.getLastRowNum();


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
            loginCredentialList.add(loginUser);

        }

        // Assign data to ExcelOperation object for Billing sheet

        ExcelOperation billingEx;
        while (billingSheetRowIterator.hasNext()) {
            Row billingRow = billingSheetRowIterator.next();

            if (billingRow.getRowNum() == 0) {
                continue;
            }
            billingEx = new ExcelOperation();
            billingEx.assignment = billingRow.getCell(0) == null ? "" : billingRow.getCell(0).getStringCellValue();
            billingRow.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
            billingEx.fee = billingRow.getCell(1) == null ? "" : billingRow.getCell(1).getStringCellValue();
            billingRow.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
            billingEx.invoice1 = billingRow.getCell(2) == null ? "" : billingRow.getCell(2).getStringCellValue();
            billingRow.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
            billingEx.reminder1 = billingRow.getCell(3) == null ? "" : billingRow.getCell(3).getStringCellValue();
            billingRow.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
            billingEx.payment1 = billingRow.getCell(4) == null ? "" : billingRow.getCell(4).getStringCellValue();
            billingRow.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
            billingEx.invoice2 = billingRow.getCell(5) == null ? "" : billingRow.getCell(5).getStringCellValue();
            billingRow.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
            billingEx.reminder2 = billingRow.getCell(6) == null ? "" : billingRow.getCell(6).getStringCellValue();
            billingRow.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
            billingEx.payment2 = billingRow.getCell(7) == null ? "" : billingRow.getCell(7).getStringCellValue();
            billingEx.performance = billingRow.getCell(8) == null ? "" : billingRow.getCell(8).getStringCellValue();
            billList.add(billingEx);
        }


    }

    @Test(priority = 1)
    public void SignIn() throws InterruptedException{
        String user_name = loginCredentialList.get(0).getLoginUserName();
        String password = loginCredentialList.get(0).getPasswordForUser();
        Functions object= new Functions();
        object.SignIn(driver, user_name, password);
    }

    @Test(priority = 1)
    public void createBillings() throws InterruptedException {

        for (int i = 0; i <= totalNumberOfDataInBillingSheet - 1; i++) {
            String assignment = billList.get(i).getAssignment();
            String fee=billList.get(i).getFee();
            String invoice1_date=billList.get(i).getInvoice1();
            String reminder1_date=billList.get(i).getReminder1();
            String payment1_date=billList.get(i).getPayment1();
            String invoice2_date=billList.get(i).getInvoice2();
            String reminder2_date=billList.get(i).getReminder2();
            String payment2_date=billList.get(i).getPayment2();
            String performance=billList.get(i).getPerformance();
            Billing obj = new Billing();
            obj.createBill(driver, assignment, fee, invoice1_date, reminder1_date, payment1_date, invoice2_date, reminder2_date, payment2_date, performance);
            }
    }


}
