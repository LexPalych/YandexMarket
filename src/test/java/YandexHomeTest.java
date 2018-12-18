import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexHomeTest extends YandexMarketTest {
    private ChromeDriver driver;

    @FindBy(xpath = "//*[@data-id='market']")
    private WebElement market;

    public YandexHomeTest(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public YandexHomeTest openSite(String url, ChromeDriver chromeDriver) {
        chromeDriver.get(url);
        return this;
    }

    public YandexMarketTest tabClick(String s) {
        driver.findElement(By.xpath("//*[.='" + s + "']")).click();
        return new YandexMarketTest(driver);
    }
}