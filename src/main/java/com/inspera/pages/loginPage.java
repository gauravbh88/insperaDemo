package com.inspera.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class loginPage {

    private WebDriver driver;
    private WebDriverWait wait;



    @FindBy(xpath = "//*[@id='loginWithLocalUserTrigger']")
    private WebElement loginWithLocalUserTriggerLink;

    @FindBy(name = "userName")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-primary login-btn']/span")
    private WebElement submit;

    @FindBy(css = ".user-dropdown.settings-menu-item-link")
    private WebElement setting;

    @FindBy(css = "mtl")
    private WebElement logout;



    public loginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo() throws InterruptedException {
        this.driver.manage().deleteAllCookies();
        this.driver.navigate().refresh();
        this.driver.get("https://demo.inspera.no/");
        this.wait.until(ExpectedConditions.visibilityOf(this.loginWithLocalUserTriggerLink));
    }

    public void loginWithLocalUserLink() throws InterruptedException {
        this.loginWithLocalUserTriggerLink.click();



    }

    public void fillLoginDetails(String username,String password){
        this.userName.sendKeys(username);
        this.password.sendKeys((password));
    }

    public void clickSubmit() throws InterruptedException {
        this.submit.click();

    }

    public void clickSetting() throws InterruptedException {
        this.wait.until(ExpectedConditions.visibilityOf(this.setting));
        this.setting.click();

    }


    public void clickLogout() throws InterruptedException {
        this.wait.until(ExpectedConditions.visibilityOf(this.logout));
        this.logout.click();

    }
}
