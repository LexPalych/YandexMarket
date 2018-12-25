import org.openqa.selenium.WebDriver;
import java.lang.reflect.InvocationTargetException;

public class PageObjectFactory {
    private static WebDriver driver;

    public static void setWebDriver(WebDriver driver) {
        PageObjectFactory.driver = driver;
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
            field.set(pageObjectInstance, driver);

            return pageObjectInstance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        return null;
    }
}
