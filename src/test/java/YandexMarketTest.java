import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class YandexMarketTest {
    private ChromeDriver driver;

    @FindBy(xpath = "//*[@id=\"header-search\"]")
    private WebElement search;

    @FindBy(xpath = "//*[@class=\"search2__button\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@name='Цена от']")
    private WebElement minPrice;

    @FindBy(xpath = "//*[@name='Цена до']")
    private WebElement maxPrice;

    @FindBy(xpath = "//span[.=\"Apple\"]")
    private WebElement companyApple;

    @FindBy(xpath = "//span[.=\"ASUS\"]")
    private WebElement companyASUS;

    @FindBy(xpath = "//span[.=\"HP\"]")
    private WebElement companyHP;

    @FindBy(xpath = "//span[.=\"Xiaomi\"]")
    private WebElement companyXiaomi;

    @FindBy(xpath = "//span[.=\"Core i7\"]")
    private WebElement intelCore;

    @FindBy(xpath = "//strong[contains(.,'Толстовка')]")
    private WebElement sweatshirt;

    public YandexMarketTest(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public YandexMarketTest openSite(String url, ChromeDriver chromeDriver) {
        chromeDriver.get(url);
        return this;
    }

    public YandexMarketTest tabClick(String s) {
        driver.findElement(By.xpath("//*[.='" + s + "']")).click();
        return this;
    }

    public YandexMarketTest fillField(String s) {
        search.sendKeys(s);
        return this;
    }

    public YandexMarketTest checkFieldLaptop() {
        assertEquals(search.getAttribute("value"), "Ноутбуки");
        return this;
    }

    public YandexMarketTest fillPrice(String where, String value) {
        driver.findElement(By.xpath("//*[@name='"+ where +"']")).sendKeys(value);
        return this;
    }

    public YandexMarketTest checkPrice (String where, String value) {
        assertEquals(driver.findElement(By.xpath("//*[@name='"+ where +"']")).getAttribute("value"), value);
        return this;
    }

    public YandexMarketTest clickButton(String s) {
        driver.findElement(By.xpath("//span[.=\""+ s +"\"]")).click();
        return this;
    }

    public YandexMarketTest checkTick(String s) {
        assertTrue(driver.findElement(By.xpath("//*[@name=\"Производитель " + s + "\"]")).isSelected());
        return this;
    }

    public YandexMarketTest claerSearch() {
        search.clear();
        return this;
    }

    public YandexMarketTest tabSweatshirt() {
        try {
            sweatshirt.click();
        }catch (NoSuchElementException thrown){
            System.out.println("Упс, что-то пошло не так. 'Толстовка' не найдена");
        }
        return this;
    }
}