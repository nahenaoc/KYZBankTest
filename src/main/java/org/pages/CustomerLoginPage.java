package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomerLoginPage {
    private final WebDriver driver;
    private final By userSelectDropdown = By.id("userSelect");
    private final By loginButton = By.xpath("//button[@type='submit']");

    public CustomerLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectUser(String userName) {
        Select userSelect = new Select(driver.findElement(userSelectDropdown));
        userSelect.selectByVisibleText(userName);
    }

    public AccountPage clickLogin() {
        driver.findElement(loginButton).click();
        return new AccountPage(driver);
    }
}

