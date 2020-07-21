package Tests;


import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test2 extends BaseDriver {


    @Test
    @Parameters({"username", "password"})
    public void test2(String username, String password) throws InterruptedException {

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys(username);

        WebElement passwordIbput = driver.findElement(By.id("password"));
        passwordIbput.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.id("loginBtn"));
        loginBtn.click();

        wait.until(ExpectedConditions.titleIs("Dashboard Library"));

        WebElement kontaktButton = driver.findElement(By.xpath("(//a[@class='primary-link'])[2]"));
        kontaktButton.click();

        WebElement sub_companies = driver.findElement(By.xpath("(//a[@id='nav-secondary-companies'])[1]"));
        sub_companies.click();

        WebElement companyErstellen = driver.findElement(By.cssSelector("span[data-key='contentToolbar.addCompanyButton']"));
        companyErstellen.click();

        By domainInformation = By.cssSelector("input[data-selenium-test='property-input-domain']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(domainInformation));

        WebElement domainName = driver.findElement(domainInformation);
        domainName.sendKeys("https://techno.study/");

        WebElement element = driver.findElement(By.cssSelector("input[data-selenium-test='property-input-name']"));
        Thread.sleep(2000);
        element.clear();
        element.sendKeys("Technology");

        Thread.sleep(2000);
        By confirmButton=By.cssSelector("button[data-selenium-test='base-dialog-confirm-btn']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmButton));
        driver.findElement(confirmButton).click();

        wait.until(ExpectedConditions.titleContains("Techno"));

        Assert.assertEquals("techno.study", driver.findElement(By.cssSelector("div[class='p-x-0 col-xs-12']>div>span>span")).getText());
        driver.findElement(By.cssSelector("#uiabstractdropdown-button-9")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i18n-string[text()='Löschen']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[data-selenium-test*=delete]>i18n-string")).click();

    /*
        https://app.hubspot.com/login

        Enter username and password
        Click on login button
        Click on contacts dropdown (on left top)
        Click on companies button
        Click on create companies button
        Enter the company domain
        Enter the name
        Click on Create company button
        Verify company domain as entered
        Click on actions dropdown
        Click on delete button
        Click on Delete contact button

     */


    }
}