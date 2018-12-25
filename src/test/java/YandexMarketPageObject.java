import org.openqa.selenium.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class YandexMarketPageObject extends Page<YandexMarketPageObject> {
    private String search = "//*[@id=\"header-search\"]";

    public YandexMarketPageObject checkFieldLaptop() {
        assertEquals(getWebElement(search).getAttribute("value"), "Ноутбуки");
        return createPage(YandexMarketPageObject.class);
    }

    public YandexMarketPageObject fillSearch(String value) {
        getWebElement(search).sendKeys(value);
        return createPage(YandexMarketPageObject.class);
    }

    public YandexMarketPageObject fillPrice(String where, String value) {
        getWebElement("//*[@name='"+ where +"']").sendKeys(value);
        return createPage(YandexMarketPageObject.class);
    }

    public YandexMarketPageObject checkPrice (String where, String value) {
        assertEquals(getWebElement("//*[@name='"+ where +"']").getAttribute("value"), value);
        return createPage(YandexMarketPageObject.class);
    }

    public YandexMarketPageObject clickButton(String s) {
        getWebElement("//span[.=\""+ s +"\"]").click();
        return this;
    }

    public YandexMarketPageObject checkTick(String s) {
        assertTrue(getWebElement("//*[@name=\"Производитель " + s + "\"]").isSelected());
        return this;
    }

    public YandexMarketPageObject clearSearch() {
        getWebElement(search).clear();
        return this;
    }

    public YandexMarketPageObject tabSweatshirt() {
        try {
            getWebElement("//strong[contains(.,'Толстовка')]").click();
        }catch (NoSuchElementException thrown){
            System.out.println("Упс, что-то пошло не так. 'Толстовка' не найдена");
        }
        return this;
    }
}