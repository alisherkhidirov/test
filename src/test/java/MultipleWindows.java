import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.Set;

public class MultipleWindows  {
       public static WebDriver driver;

    @Test(description = "Just testing")
    public void test1() throws InterruptedException {



        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");

        String currentWindow = driver.getWindowHandle();


        WebElement fa = driver.findElement(By.xpath("(//a[@class='social-button facebook'])[1]"));
        fa.click();

        Set<String> allWindows = driver.getWindowHandles();



        for (String facebook:allWindows) {
            if(!facebook.equals(currentWindow)) {
                driver.switchTo().window(facebook);
            }
            System.out.println(driver.getTitle());

            driver.close();

            driver.switchTo().window(currentWindow);

            Thread.sleep(2000);


            WebElement tw = driver.findElement(By.xpath("(//a[@class='social-button twitter'])[1]"));
            tw.click();

            allWindows = driver.getWindowHandles();

            for (String twitter:allWindows) {
                if (!twitter.equals(currentWindow)) {
                    driver.switchTo().window(twitter);
                }
            }
            System.out.println(driver.getTitle());

            driver.close();

            driver.switchTo().window(currentWindow);

            Thread.sleep(2000);

            WebElement gog = driver.findElement(By.xpath("(//a[@class='social-button google'])[1]"));
            gog.click();

            allWindows = driver.getWindowHandles();

            for (String google:allWindows) {
                if (!google.equals(currentWindow)) {
                    driver.switchTo().window(google);
                }

                System.out.println(driver.getTitle());

                driver.close();

                driver.switchTo().window(currentWindow);

            }
        }
    }

}
