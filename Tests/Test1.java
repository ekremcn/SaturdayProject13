package Tests;

import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Test1 extends BaseDriver {


    @Test
    @Parameters({"username","password"})
    public void test1(String username, String password) {

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys(username);

        WebElement passwordIbput= driver.findElement(By.id("password"));
        passwordIbput.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.id("loginBtn"));
        loginBtn.click();

        wait.until(ExpectedConditions.titleIs("Dashboard Library"));

        WebElement kontaktButton=driver.findElement(By.xpath("(//a[@class='primary-link'])[2]"));
        kontaktButton.click();

        WebElement sub_kontakt = driver.findElement(By.xpath("(//a[@id='nav-secondary-contacts'])[1]"));
        sub_kontakt.click();

        WebElement kontaktErstellen = driver.findElement(By.cssSelector("span[data-key='contentToolbar.addContactButton']"));
        kontaktErstellen.click();

        WebElement emailInput = driver.findElement(By.id("UIFormControl-31"));
        emailInput.sendKeys("ilhan15@gmail.com");

        WebElement vorName = driver.findElement(By.id("UIFormControl-33"));
        vorName.sendKeys("ahmet");

        WebElement lastName = driver.findElement(By.id("UIFormControl-37"));
        lastName.sendKeys("berke");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement createButton = driver.findElement(By.xpath("(//li[@class='uiListItem private-list__item p-bottom-1'])[1]"));
        createButton.click();

        wait.until(ExpectedConditions.titleContains("berke"));

        String emailAdresse = driver.findElement(By.cssSelector("div[data-selenium-test='property-input-email']")).getText();
        System.out.println(emailAdresse);

        Assert.assertTrue(emailAdresse.equalsIgnoreCase("ilhan15@gmail.com"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement firstNameElement = driver.findElement(By.cssSelector("div[class='private-form__input-wrapper'] input"));
        String firstName = firstNameElement.getAttribute("value");

        System.out.println(firstName);

        Assert.assertTrue(firstName.equalsIgnoreCase("ahmet"));

        WebElement actions = driver.findElement(By.xpath("(//div[@class='settings'])[2]"));
        actions.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("(//ul[@class='uiList private-list--unstyled']/li)[10]")).click();


        WebElement accept = driver.findElement(By.cssSelector("button[data-selenium-test='delete-dialog-confirm-button']"));
        accept.click();


    }

    /*

        https://app.hubspot.com/login

        Enter username and password
        Click on login button
        Click on contacts dropdown (on left top)
        Click on contacts button
        Click on create contact button
        Enter email
        Enter First name
        Enter Last name
        Click on Create Contact button
        Verify email and first name as entered
        Click on actions dropdown
        Click on delete button
        Click on Delete contact button

     */


}
