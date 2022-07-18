import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void getDriver() {
       if (driver == null) {
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       }

    }

         @AfterMethod(alwaysRun = true)
         public  void killDriver() {
             if (driver != null) {
                 driver.quit();
             }
         }
}
