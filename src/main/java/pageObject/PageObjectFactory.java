package pageObject;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;

public class PageObjectFactory {
    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public static void setWebDriver(final WebDriver driver) {
        PageObjectFactory.webDriverThreadLocal.set(driver);
    }

    public static WebDriver getWebDriver() {
        return webDriverThreadLocal.get();
    }

    public static <T> T createPage(Class<T> pageClass) {
        try {
            /**
             * Создание объекта страницы с дефолтным конструктором
             */
            var pageObjectInstance = pageClass.getConstructor().newInstance();

            /**
             * Получение поля с именем driver
             */
            var field = pageClass.getSuperclass().getDeclaredField("driver");
            field.setAccessible(true);

            /**
             * Инициализация поля driver
             */
            var driver = webDriverThreadLocal.get();
            field.set(pageObjectInstance, driver);

            return pageObjectInstance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        return null;
    }
}
