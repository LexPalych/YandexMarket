package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Page<T extends Page> {
    protected WebDriver driver;

    protected static final Logger logger = LogManager.getLogger(Page.class);

    public <D> D tabClick(String name, Class<D> expectedPage) {
        logger.warn(("Hello, World!"));
        logger.error(("Hello, World!"));
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
