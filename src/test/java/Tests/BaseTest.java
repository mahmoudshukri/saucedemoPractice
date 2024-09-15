package Tests;

import com.sauceDemo.pages.BasePage;
import com.sauceDemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    private  String url = "https://www.saucedemo.com";
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        basePage = new BasePage();
        basePage.setDriver(driver);
        loginPage=new LoginPage();

    }



    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
