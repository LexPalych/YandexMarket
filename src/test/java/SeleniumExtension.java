import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SeleniumExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
    private WebDriver driver;

    @BeforeEach
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        var url = "https://yandex.ru/";
        System.out.println("Запуск теста");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alexandr\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();

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
        homePageObject.openSite(url, YandexHomePageObject.class);

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
            driver.quit();
    }
}