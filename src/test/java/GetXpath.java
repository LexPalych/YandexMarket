import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetXpath {
//    private WebElement driver;
//
//    public GetXpath(WebElement driver) {
//        this.driver = driver;
//    }

    public WebElement get(String string, WebDriver driver) {
        return driver.findElement(By.xpath(string));
    }

    public List<WebElement> gets(String string, WebDriver driver) {
        return driver.findElements(By.xpath(string));
    }
}
