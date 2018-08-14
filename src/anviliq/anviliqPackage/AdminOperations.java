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
 * Created by Sakib on 10/3/2016.
 */


public class AdminOperations {

    public List<ExcelOperation> anvilTypeList = new ArrayList<ExcelOperation>();
    public List<ExcelOperation> assignmentStatusList = new ArrayList<ExcelOperation>();
    public List<ExcelOperation> assignmentTypeList = new ArrayList<ExcelOperation>();
    public List<ExcelOperation> companyTypeList = new ArrayList<ExcelOperation>();
    public List<ExcelOperation> industryList = new ArrayList<ExcelOperation>();
    public List<ExcelOperation> peopleTitleList = new ArrayList<ExcelOperation>();
    public List<ExcelOperation> userManagementList = new ArrayList<ExcelOperation>();
    int totalNumberOfDataInAnvilTypeSheet;
    int totalNumberOfDataInAssignmentStatusSheet;
    int totalNumberOfDataInAssignmentTypeSheet;
    int totalNumberOfDataInCompanyTypeSheet;
    int totalNumberOfDataInIndustrySheet;
    int totalNumberOfDataInPeopleTitleSheet;
    int totalNumberOfDataInUserManagementSheet;

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

//Get iterator to all the rows in Anvil Type sheet
        XSSFSheet anvilTypesheet = workbook.getSheet("Anvil Type");
        Iterator<Row> anvilTypeSheetRowIterator = anvilTypesheet.iterator();
        totalNumberOfDataInAnvilTypeSheet = anvilTypesheet.getLastRowNum();
//Get iterator to all the rows in Assignment Status  sheet
        XSSFSheet assignmentStatusSheet = workbook.getSheet("Assignment Status");
        Iterator<Row> assignmentStatusSheetRowIterator = assignmentStatusSheet.iterator();
        totalNumberOfDataInAssignmentStatusSheet = assignmentStatusSheet.getLastRowNum();
//Get iterator to all the rows in Assignment Type  sheet
        XSSFSheet assignmentTypeSheet = workbook.getSheet("Assignment Type");
        Iterator<Row> assignmentTypeSheetRowIterator = assignmentTypeSheet.iterator();
        totalNumberOfDataInAssignmentTypeSheet = assignmentTypeSheet.getLastRowNum();

//Get iterator to all the rows in Company Type  sheet
        XSSFSheet companyTypeSheet = workbook.getSheet("Company Type");
        Iterator<Row> companyTypeSheetRowIterator = companyTypeSheet.iterator();
        totalNumberOfDataInCompanyTypeSheet = companyTypeSheet.getLastRowNum();

//Get iterator to all the rows in Company Type  sheet
        XSSFSheet industrySheet = workbook.getSheet("Industry");
        Iterator<Row> industrySheetRowIterator = industrySheet.iterator();
        totalNumberOfDataInIndustrySheet = industrySheet.getLastRowNum();

//Get iterator to all the rows in Company Type  sheet
        XSSFSheet peopleTitleSheet = workbook.getSheet("People Title");
        Iterator<Row> peopleTitleSheetRowIterator = peopleTitleSheet.iterator();
        totalNumberOfDataInPeopleTitleSheet = peopleTitleSheet.getLastRowNum();

//Get iterator to all the rows in User Management sheet
        XSSFSheet userManagementSheet = workbook.getSheet("User Management");
        Iterator<Row> userManagementSheetRowIterator = userManagementSheet.iterator();
        totalNumberOfDataInUserManagementSheet = userManagementSheet.getLastRowNum();


// Assign data to ExcelOperation object for Anvil Type leSheet
        ExcelOperation anvilTypeEx;

        while (anvilTypeSheetRowIterator.hasNext()) {
            Row anvilTypeRow = anvilTypeSheetRowIterator.next();

            if (anvilTypeRow.getRowNum() == 0) {
                continue;
            }
            anvilTypeEx = new ExcelOperation();
            anvilTypeEx.anvilType = anvilTypeRow.getCell(0) == null ? "" : anvilTypeRow.getCell(0).getStringCellValue();
            anvilTypeList.add(anvilTypeEx);
        }

// Assign data to ExcelOperation object for Assignment Status sheet

        ExcelOperation assignmentStatusEx;
        while (assignmentStatusSheetRowIterator.hasNext()) {
            Row assignmentStatusRow = assignmentStatusSheetRowIterator.next();

            if (assignmentStatusRow.getRowNum() == 0) {
                continue;
            }
            assignmentStatusEx = new ExcelOperation();
            assignmentStatusEx.assignmentStatus = assignmentStatusRow.getCell(0) == null ? "" : assignmentStatusRow.getCell(0).getStringCellValue();
            assignmentStatusList.add(assignmentStatusEx);
        }

// Assign data to ExcelOperation object for Assignment Type sheet

        ExcelOperation assignmentTypeEx;
        while (assignmentTypeSheetRowIterator.hasNext()) {
            Row assignmentTypeRow = assignmentTypeSheetRowIterator.next();

            if (assignmentTypeRow.getRowNum() == 0) {
                continue;
            }
            assignmentTypeEx = new ExcelOperation();
            assignmentTypeEx.assignmentType = assignmentTypeRow.getCell(0) == null ? "" : assignmentTypeRow.getCell(0).getStringCellValue();
            assignmentTypeList.add(assignmentTypeEx);
        }

// Assign data to ExcelOperation object for Company Type sheet

        ExcelOperation companyTypeEx;
        while (companyTypeSheetRowIterator.hasNext()) {
            Row companyTypeRow = companyTypeSheetRowIterator.next();

            if (companyTypeRow.getRowNum() == 0) {
                continue;
            }
            companyTypeEx = new ExcelOperation();
            companyTypeEx.assignmentType = companyTypeRow.getCell(0) == null ? "" : companyTypeRow.getCell(0).getStringCellValue();
            companyTypeList.add(companyTypeEx);
        }

// Assign data to ExcelOperation object for Industry sheet

        ExcelOperation industryEx;
        while (industrySheetRowIterator.hasNext()) {
            Row industryRow = industrySheetRowIterator.next();

            if (industryRow.getRowNum() == 0) {
                continue;
            }
            industryEx = new ExcelOperation();
            industryEx.industryName = industryRow.getCell(0) == null ? "" : industryRow.getCell(0).getStringCellValue();
            industryList.add(industryEx);
        }

// Assign data to ExcelOperation object for People Title sheet

        ExcelOperation peopleTitleEx;
        while (peopleTitleSheetRowIterator.hasNext()) {
            Row peopleTitleRow = peopleTitleSheetRowIterator.next();

            if (peopleTitleRow.getRowNum() == 0) {
                continue;
            }
            peopleTitleEx = new ExcelOperation();
            peopleTitleEx.peopleTitle = peopleTitleRow.getCell(0) == null ? "" : peopleTitleRow.getCell(0).getStringCellValue();
            peopleTitleList.add(peopleTitleEx);
        }

// Assign data to ExcelOperation object for User Management sheet

        ExcelOperation userManagementEx;
        while (userManagementSheetRowIterator.hasNext()) {
            Row userManagementRow = userManagementSheetRowIterator.next();

            if (userManagementRow.getRowNum() == 0) {
                continue;
            }
            userManagementEx = new ExcelOperation();
            userManagementEx.login = userManagementRow.getCell(0) == null ? "" : userManagementRow.getCell(0).getStringCellValue();
            userManagementEx.userFname = userManagementRow.getCell(1) == null ? "" : userManagementRow.getCell(1).getStringCellValue();
            userManagementEx.userLname = userManagementRow.getCell(2) == null ? "" : userManagementRow.getCell(2).getStringCellValue();
            userManagementRow.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
            userManagementEx.passwordForUser = userManagementRow.getCell(3) == null ? "" : userManagementRow.getCell(3).getStringCellValue();
            userManagementRow.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
            userManagementEx.confirmPasswordForUser = userManagementRow.getCell(4) == null ? "" : userManagementRow.getCell(4).getStringCellValue();
            userManagementEx.email = userManagementRow.getCell(5) == null ? "" : userManagementRow.getCell(5).getStringCellValue();
            userManagementEx.profile = userManagementRow.getCell(6) == null ? "" : userManagementRow.getCell(6).getStringCellValue();
            userManagementList.add(userManagementEx);
        }


    }


    @Test(priority = 1)
    public void SignIn() throws InterruptedException {
        String user_name = "lan@anvilanalytics.com";
        String password = "anviliq";
        Functions object = new Functions();
        object.SignIn(driver, user_name, password);
    }

    //@Test(priority = 13)
    public void createAnvilType() throws InterruptedException {

        for (int i = 0; i <= totalNumberOfDataInAnvilTypeSheet - 1; i++) {
            String anvilType = anvilTypeList.get(i).getAnvilType();
            Admin obj = new Admin();
            obj.anvilType(driver, anvilType);
        }
    }

    //@Test(priority = 12)
    public void createAsignmentStatus() throws InterruptedException {

        for (int i = 0; i <= totalNumberOfDataInAssignmentStatusSheet - 1; i++) {
            String anvilAssigmentStatus = assignmentStatusList.get(i).getAssignmentStatus();
            Admin obj = new Admin();
            obj.assignmentStatus(driver, anvilAssigmentStatus);
        }
    }


    //@Test(priority = 5)
    public void createAsignmentType() throws InterruptedException {

        for (int i = 0; i <= totalNumberOfDataInAssignmentTypeSheet - 1; i++) {
            String anvilAssigmentType = assignmentTypeList.get(i).getAssignmentType();
            Admin obj = new Admin();
            obj.assignmentType(driver, anvilAssigmentType);
        }
    }

    //@Test(priority = 8)
    public void createCompanyType() throws InterruptedException {

        for (int i = 0; i <= totalNumberOfDataInCompanyTypeSheet - 1; i++) {
            String companyType = companyTypeList.get(i).getAssignmentType();
            Admin obj = new Admin();
            obj.companyTypes(driver, companyType);
        }
    }

    //@Test(priority = 9)
    public void createIndustry() throws InterruptedException {

        for (int i = 0; i <= totalNumberOfDataInIndustrySheet - 1; i++) {
            String industry = industryList.get(i).getIndustryName();
            Admin obj = new Admin();
            obj.industries(driver, industry);
        }
    }

    @Test(priority = 1)
    public void createPeopleTitle() throws InterruptedException {

        for (int i = 0; i <= totalNumberOfDataInPeopleTitleSheet - 1; i++) {
            String peopleTitle = peopleTitleList.get(i).getPeopleTitle();
            Admin obj = new Admin();
            obj.people(driver, peopleTitle);
        }
    }
    //@Test(priority = 11)
    public void createAdminUser() throws InterruptedException {

        for (int i = 0; i <= totalNumberOfDataInUserManagementSheet - 1; i++) {
            String login_name = userManagementList.get(i).getLogin();
            String first_name = userManagementList.get(i).getUserFname();
            String last_name=userManagementList.get(i).getUserLname();
            String password=userManagementList.get(i).getPasswordForUser();
            String conf_passwd=userManagementList.get(i).getConfirmPasswordForUser();
            String email=userManagementList.get(i).getEmail();
            Admin obj = new Admin();
            obj.createAdmin(driver,login_name, first_name, last_name, password,conf_passwd,email);
        }
    }

}
