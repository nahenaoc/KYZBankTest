package tests;

import base.TestBase;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.pages.HomePage;
import org.pages.CustomerLoginPage;
import org.pages.AccountPage;
import org.pages.TransactionPage;

public class KYZBankTest extends TestBase {

    HomePage homePage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;
    TransactionPage transactionPage;

    public KYZBankTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage(driver);
        customerLoginPage = new CustomerLoginPage(driver);
        accountPage = new AccountPage(driver);
        transactionPage = new TransactionPage(driver);
    }

    @Test
    public void testBankingApp() throws InterruptedException {
        // Navigate to the home page and check the title
        String expectedTitle = "XYZ Bank";
        String actualTitle = homePage.getTitle();
        Assert.assertEquals("Title verification failed", expectedTitle, actualTitle);

        // Sign in as a customer
        customerLoginPage = homePage.clickCustomerLogin();
        customerLoginPage.selectUser("Albus Dumbledore");
        accountPage = customerLoginPage.clickLogin();

        // Verify username after login
        String expectedUsername = "Albus Dumbledore";
        String actualUsername = accountPage.getUsername();
        Assert.assertEquals("Username verification failed", expectedUsername, actualUsername);

        // Check currency type
        String expectedCurrency = "Dollar";
        String actualCurrency = accountPage.getCurrency();
        Assert.assertEquals("Currency verification failed", expectedCurrency, actualCurrency);

        // Make a deposit and check the "deposit successful" message
        accountPage.clickDeposit();
        accountPage.enterDepositAmount("999");
        accountPage.confirmDeposit();
        String expectedDeposit = "Deposit Successful";
        String actualDeposit = accountPage.getDepositStatus();
        Assert.assertEquals("Deposit verification failed", expectedDeposit, actualDeposit);
        Thread.sleep(2000);

        // Navigate to the transactions page and verify the amount deposited
        transactionPage = accountPage.clickTransactions();
        String expectedTranAmount = "999";
        String actualTranAmount = transactionPage.getTransactionAmount();
        Assert.assertEquals("Amount verification failed", expectedTranAmount, actualTranAmount);

        // Navigate to the withdrawal page and check the “transaction successful” message
        transactionPage.clickBackButton();
        accountPage.clickWithdrawl();
        accountPage.enterWithdrawlAmount("999");
        accountPage.confirmWithdrawl();
        String expectedTransact = "Transaction successful";
        String actualTransact = accountPage.getWithdrawlStatus();
        Assert.assertEquals("Transaction verification failed", expectedTransact, actualTransact);
        Thread.sleep(2000);

        // Navigate to the transactions page and verify that the new transaction type is "debit"
        transactionPage = accountPage.clickTransactions();
        String expectedNewTranType = "Debit";
        String actualNewTranType = transactionPage.getNewTransactionType();
        Assert.assertEquals("debitSit verification failed", expectedNewTranType, actualNewTranType);

        // Print new transaction type
        System.out.println("New Transaction Type: " + transactionPage.getNewTransactionType());

        // Click the Logout button
        transactionPage.clickLogoutButton();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
