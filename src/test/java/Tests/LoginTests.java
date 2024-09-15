package Tests;

import com.sauceDemo.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
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
        boolean actualMessage = productsPage.isProductsHeaderDisplayed();
        Assert.assertTrue(actualMessage,"Product Header is displayed Correctly!!!");
    }
}
