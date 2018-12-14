import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class YandexPageObjectTest {
    private ChromeDriver driver;

    @FindBy(xpath = "//*[@data-id='market']")
    private WebElement market;

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

    public YandexPageObjectTest(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public YandexPageObjectTest openSite(String url, ChromeDriver chromeDriver) {
        chromeDriver.get(url);
        return this;
    }

    public YandexPageObjectTest tabMarket() {
        market.click();
        return this;
    }

    public YandexPageObjectTest fillLaptop() {
        search.sendKeys("Ноутбуки");
        return this;
    }

//    public YandexPageObjectTest fillField(String s) {
//        switch (s) {
//            case "Ноутбуки" : search.sendKeys("Ноутбуки");
//            case "100000" : minPrice.sendKeys("100000");
//            case "200000" : maxPrice.sendKeys("200000");
//            case "Зеленый слоник" : search.sendKeys("Зеленый слоник");
//        }
//        return this;
//    }

//    public YandexPageObjectTest checkField(String s) {
//        switch (s) {
//            case "Ноутбуки" : assertEquals(search.getAttribute("value"), "Ноутбуки");
//            case "100000" : assertEquals(minPrice.getAttribute("value"), "100000");
//            case "200000" : assertEquals(maxPrice.getAttribute("value"), "200000");
//        }
//        return this;
//    }

    public YandexPageObjectTest checkFieldLaptop() {
        assertEquals(search.getAttribute("value"), "Ноутбуки");
        return this;
    }

    public YandexPageObjectTest tabSearch() {
        searchButton.click();
        return this;
    }

    public YandexPageObjectTest fillMinPrice() {
        minPrice.sendKeys("100000");
        return this;
    }

    public YandexPageObjectTest fillMaxPrice() {
        maxPrice.sendKeys("200000");
        return this;
    }

    public YandexPageObjectTest checkMinPrice() {
        assertEquals(minPrice.getAttribute("value"), "100000");
        return this;
    }

    public YandexPageObjectTest checkMaxPrice() {
        assertEquals(maxPrice.getAttribute("value"), "200000");
        return this;
    }

    public YandexPageObjectTest clickButton(String s) {
        driver.findElement(By.xpath("//span[.=\""+ s +"\"]")).click();
        return this;
    }

//    public YandexPageObjectTest tabIntelCore() {
//        intelCore.click();
//        return this;
//    }
//
//    public YandexPageObjectTest tabApple() {
//        companyApple.click();
//        return this;
//    }
//
//    public YandexPageObjectTest tabASUS() {
//        companyASUS.click();
//        return this;
//    }
//
//    public YandexPageObjectTest tabHP() {
//        companyHP.click();
//        return this;
//    }
//
//    public YandexPageObjectTest tabXiaomi() {
//        companyXiaomi.click();
//        return this;
//    }

    public YandexPageObjectTest checkTick(String s) {
        //System.out.println("//*[@name=\"Производитель" + s + "\"]");
        assertTrue(driver.findElement(By.xpath("//*[@name=\"Производитель " + s + "\"]")).isSelected());
        return this;
    }

//    public YandexPageObjectTest checkApple() {
//        assertTrue(companyApple.isEnabled());
//        return this;
//    }
//
//    public YandexPageObjectTest checkASUS() {
//        assertTrue(companyASUS.isEnabled());
//        return this;
//    }
//
//    public YandexPageObjectTest checkHP() {
//        assertTrue(companyHP.isEnabled());
//        return this;
//    }
//
//    public YandexPageObjectTest checkXiaomi() {
//        assertTrue(companyXiaomi.isEnabled());
//        return this;
//    }

    public YandexPageObjectTest claerSearch() {
        search.clear();
        return this;
    }

    public YandexPageObjectTest fillGreenElephant() {
        search.sendKeys("Зеленый слоник");
        return this;
    }

    public YandexPageObjectTest tabSweatshirt() {
        try {
            sweatshirt.click();
        }catch (NoSuchElementException thrown){
            System.out.println("Упс, что-то пошло не так. 'Толстовка' не найдена");
        }
        return this;
    }
}