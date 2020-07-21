package Utils;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseDriver {

    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeMethod

    public void BeforeMethod() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ekrem\\OneDrive\\Masaüstü\\TechnoStudy\\Selenium\\SeleniumDependency\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver,10);
        driver.get("https://app.hubspot.com/login");

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);



    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}