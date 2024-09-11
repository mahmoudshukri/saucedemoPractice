package com.sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage{
    private final By userNameField = By.id("user-name");
    private final By PassWordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]");

    public void typeUserName (String username){
    type(userNameField,username);
    }

    public void  typePassword (String password){
        type(PassWordField,password);
    }

    public ProductsPage clickLoginButton(){
        click(loginButton);
        return new ProductsPage();
    }

    public ProductsPage logIntoApplication(String username, String password){
        typeUserName(username);
        typePassword(password);
        return clickLoginButton();
    }

    public String getErrorMessage(){
        waitForElementVisibility(errorMessage);
        return  find(errorMessage).getText();
    }


}

