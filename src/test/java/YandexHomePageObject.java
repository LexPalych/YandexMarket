import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class YandexHomePageObject {
    private WebDriver driver;

    public YandexHomePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public YandexHomePageObject openSite(String url, WebDriver webDriver) {
        webDriver.get(url);
        return this;
    }

    public YandexMarketPageObject tabClick(String s) {
        driver.findElement(By.xpath("//*[.='" + s + "']")).click();
        return new YandexMarketPageObject(driver);
    }
}