package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Page<T extends Page> {
    protected WebDriver driver;

    public <D> D tabClick(String name, Class<D> expectedPage) {
        getWebElement(getString(name)).click();
        return createPage(expectedPage);
    }

    public WebElement getWebElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public String getString(String xpath) {
        return "//*[.='" + xpath + "']";
    }

    public List<WebElement> getWebElements(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    public <D> D createPage(Class<D> expectedPage) {
        return PageObjectFactory.createPage(expectedPage);
    }

    public <D> D openSite(String url, Class<D> pageClass) {
        driver.get(url);
        return createPage(pageClass);
    }
}
