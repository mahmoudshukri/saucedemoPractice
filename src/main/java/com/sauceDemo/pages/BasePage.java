package com.sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;
    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }
    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected void type (By locator, String text){
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click (By locator){
        find(locator).click();


    }
    // Wait for element visibility using FluentWait
    public WebElement waitForElementVisibility(By locator) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);

        return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
