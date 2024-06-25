package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;
    private final By customerLoginButton = By.xpath("//button[@ng-click='customer()']");
    private final By titleText = By.xpath("//strong[@class='mainHeading']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        WebElement titleElement = driver.findElement(titleText);
        return titleElement.getText().trim();
    }

    public CustomerLoginPage clickCustomerLogin() {
        driver.findElement(customerLoginButton).click();
        return new CustomerLoginPage(driver);
    }
}
