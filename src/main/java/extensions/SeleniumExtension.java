package extensions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.PageObjectFactory;
import pageObject.YandexHomePageObject;

import java.util.concurrent.TimeUnit;

public class SeleniumExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
    @BeforeEach
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        System.out.println("Запуск теста");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alexandr\\IdeaProjects\\chromedriver.exe");
        var driver = new ChromeDriver();

        /**
         * Установка неявного ожидания
         */
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /**
         * Чтобы окошко развернулось на весь экран
         */
        driver.manage().window().maximize();

        /**
         * Инициализация фабрики
         */
        PageObjectFactory.setWebDriver(driver);

        /**
         * Создание начальной страницы
         */
        var homePageObject = PageObjectFactory.createPage(YandexHomePageObject.class);

        /**
         * Заход на главную страницу
         */

        /**
         * Получение объекта теста
         */
        var testInstance = context.getRequiredTestInstance();
        var testInstanceClass = testInstance.getClass();

        /**
         * Поиск поля
         */
        var testField = testInstanceClass.getDeclaredField("yandexHomePageObject");
        testField.setAccessible(true);

        /**
         * Инициализация поля
         */
        testField.set(testInstance, homePageObject);
    }

    @AfterEach
    public void afterTestExecution(ExtensionContext context) throws Exception {
        System.out.println("Тест окончен");
        PageObjectFactory.getWebDriver().quit();
    }
}