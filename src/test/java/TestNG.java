import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
public class TestNG extends Driver {



//    @DataProvider(name = "data")
//    public Object[][] set() {
//        Object[][] data = new Object[3][1];
//        data[0][0] = "Mango";
//        data[1][0] = "Apple";
//        data[2][0] = "Pineapple";
//        return data;
//    }

    @Test(dataProvider = "data", dataProviderClass = DataProviders.class)
    public void test1(String data) {
        driver.get("http://google.com");


    }

    @Test(testName = "test", description = "Assert")
    public void test2() {

    }

}
