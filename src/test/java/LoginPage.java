import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverUtils;

public class LoginPage {



    public LoginPage() {
        PageFactory.initElements(WebDriverUtils.getDriver(), this);
    }

    @FindBy(xpath = "(//a[text()='Learn more'])[2]")
    public WebElement text;
}
