package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiku\\Music\\automation-assessment\\Demo\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

}
