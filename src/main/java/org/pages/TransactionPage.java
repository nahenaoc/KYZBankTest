package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransactionPage {
    private final WebDriver driver;
    private final By backButton = By.xpath("//button[@ng-click='back()']");
    private final By transactionType = By.xpath("//td[@class='ng-binding' and text()='Credit']");
    private final By transactionAmount = By.xpath("//td[@class='ng-binding' and text()='999']");
    private final By newTransactionType = By.xpath("//td[@class='ng-binding' and text()='Debit']");
    private final By LogoutButton = By.xpath("//button[@ng-click='byebye()']");


    public TransactionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBackButton() {
        driver.findElement(backButton).click();
    }

    public String getTransactionType() {
        WebElement typeElement = driver.findElement(transactionType);
        return typeElement.getText().trim();
    }

    public String getNewTransactionType() {
        WebElement typeElement = driver.findElement(newTransactionType);
        return typeElement.getText().trim();
    }

    public String getTransactionAmount() {
        WebElement amountElement = driver.findElement(transactionAmount);
        return amountElement.getText().trim();
    }

    public void clickLogoutButton() {
        driver.findElement(LogoutButton).click();
    }

}
