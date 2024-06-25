package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
    private final WebDriver driver;
    private final By depositButton = By.xpath("//button[@ng-click='deposit()']");
    private final By transactionsButton = By.xpath("//button[@ng-click='transactions()']");
    private final By usernameDisplay = By.xpath("//span[@class='fontBig ng-binding']");
    private final By currencyDisplay = By.xpath("//strong[contains(text(), 'Dollar')]");
    private final By depositAmountInput = By.xpath("//input[@placeholder='amount']");
    private final By depositSubmitButton = By.xpath("//button[@type='submit']");
    private final By depositStatusMessage = By.xpath("//span[@class='error ng-binding']");
    private final By withdrawlButton = By.xpath("//button[@ng-click='withdrawl()']");
    private final By withdrawlAmountInput = By.xpath("//input[@placeholder='amount']");
    private final By withdrawlSubmitButton = By.xpath("//button[@type='submit']");
    private final By withdrawlStatusMessage = By.xpath("//span[@class='error ng-binding']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUsername() {
        WebElement usernameElement = driver.findElement(usernameDisplay);
        return usernameElement.getText().trim();
    }

    public void clickDeposit() {
        driver.findElement(depositButton).click();
    }

    public void enterDepositAmount(String amount) {
        WebElement amountInput = driver.findElement(depositAmountInput);
        amountInput.sendKeys(amount);
    }

    public void confirmDeposit() {
        driver.findElement(depositSubmitButton).click();
    }

    public String getDepositStatus() {
        WebElement statusElement = driver.findElement(depositStatusMessage);
        return statusElement.getText().trim();
    }

    public TransactionPage clickTransactions() {
        driver.findElement(transactionsButton).click();
        return new TransactionPage(driver);
    }

    public void clickWithdrawl() {
        driver.findElement(withdrawlButton).click();
    }

    public void enterWithdrawlAmount(String amount) {
        WebElement amountInput = driver.findElement(withdrawlAmountInput);
        amountInput.sendKeys(amount);
    }

    public void confirmWithdrawl() {
        driver.findElement(withdrawlSubmitButton).click();
    }

    public String getWithdrawlStatus() {
        WebElement statusElement = driver.findElement(withdrawlStatusMessage);
        return statusElement.getText().trim();
    }

    public String getCurrency() {
        WebElement currencyElement = driver.findElement(currencyDisplay);
        return currencyElement.getText().trim();
    }
}
