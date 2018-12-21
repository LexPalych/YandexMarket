import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelentiumExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
    private WebDriver driver;

    @BeforeEach
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        var url = "https://yandex.ru/";
        System.out.println("Запуск теста");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alexandr\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();

        //Чтобы окошко развернулось на весь экран
        driver.manage().window().maximize();
        var homePageObject = new YandexHomePageObject(driver);
        homePageObject.openSite(url, driver);

        var testInstance = context.getRequiredTestInstance();
        var testInstanceClass = testInstance.getClass();

        var testField = testInstanceClass.getDeclaredField("yandexHomePageObject");
        testField.setAccessible(true);
        testField.set(testInstance, homePageObject);
    }

    @AfterEach
    public void afterTestExecution(ExtensionContext context) throws Exception {
            System.out.println("Тест окончен");
            driver.quit();
    }
}