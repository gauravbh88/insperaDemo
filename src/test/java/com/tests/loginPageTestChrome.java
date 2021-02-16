package com.tests;

import com.inspera.pages.*;
import com.tests.BaseTest;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import java.io.File;
import java .io.FileInputStream;
import java.io.IOException;



public class loginPageTestChrome extends BaseTest{

    protected XSSFWorkbook Workbook;
    protected XSSFSheet sheet;
    protected XSSFCell cell;



    @Test
    public void registrationPage() throws InterruptedException, IOException {

        File file = new File("src/main/resources/UserDetails.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        Workbook testDataWorkBook = new XSSFWorkbook(inputStream);
        Sheet testDataSheet = testDataWorkBook.getSheet("Sheet1");

        for  (int i = 1; i< testDataSheet.getLastRowNum()+1; i++){

            cell = (XSSFCell) testDataSheet.getRow(i).getCell(0);
            DataFormatter formatter = new DataFormatter();
            String username = formatter.formatCellValue(cell);
            cell= (XSSFCell) testDataSheet.getRow(i).getCell(1);
            String password = formatter.formatCellValue(cell);

            loginPage loginPage = new loginPage(driver);


            loginPage.goTo();
            loginPage.loginWithLocalUserLink();
            loginPage.fillLoginDetails(username,password);
            System.out.println("chrome Test with username" + username+ " and password "+ password  );
            loginPage.clickSubmit();
            loginPage.clickSetting();

        }


    }

}
