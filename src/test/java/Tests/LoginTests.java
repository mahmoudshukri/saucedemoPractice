package Tests;

import com.sauceDemo.pages.ProductsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
    private static final Logger log = LoggerFactory.getLogger(LoginTests.class);
    String userName ="standard_user";
    String inValidPassword="xyz3400";
    String validPassword="secret_sauce";
    ProductsPage productsPage;
    @Test
    public void testLoginErrorMessage(){
        loginPage.typeUserName(userName);
        loginPage.typePassword(inValidPassword);
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("Epic sadface"));
    }
    @Test
    public void testLoginSuccessMessage(){
        loginPage.typeUserName(userName);
        loginPage.typePassword(validPassword);
        loginPage.clickLoginButton();
        productsPage=new ProductsPage();
        String actualMessage = productsPage.getProductsHeaderDisplayed();
        Assert.assertTrue(actualMessage.contains("Products"));
    }
}
