package base;

import org.openqa.selenium.WebDriver;
import utils.WebDriverUtils;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Properties prop;

    public TestBase() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialization() {
        String browserName = prop.getProperty("browser");
        if(browserName.equals("chrome")){
            driver = WebDriverUtils.createWebDriver(prop.getProperty("driverPath"));
        }
        // Add other browsers here if needed
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("timeout")), TimeUnit.SECONDS);
        driver.get(prop.getProperty("baseUrl"));
    }
}
