package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
    @Test
    public void testLoginErrorMessage(){
        loginPage.typeUserName("standard_user");
        loginPage.typePassword("xyz3400");
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("Epic sadface"));
    }
}
