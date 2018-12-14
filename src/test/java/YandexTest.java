import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class YandexTest {

    private static ChromeDriver driver;
    private static String url = "https://yandex.ru/";

    @BeforeAll
    public static void beforeTest() {
        System.out.println("Запуск теста");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Alexandr\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();

        //Чтобы окошко развернулось на весь экран
        driver.manage().window().maximize();
    }

    @Test
    public void yandexTest() {
        YandexPageObjectTest test = new YandexPageObjectTest(driver);
        // Заходим на Яндекс => Яндекс.Маркет => Вводим "Ноутбуки" => Проверяем => Нажимаем "Найти"
        test
            .openSite(url, driver)
            .tabMarket()
            .fillLaptop()
            .checkFieldLaptop()
            .tabSearch()

        // Вводим минимум и максимум цены и проверяем их
            .fillMinPrice()
            .fillMaxPrice()
            .checkMinPrice()
            .checkMaxPrice()

        //Ставим галочки напротив нужных фирм
            .clickButton("Core i7")
            .clickButton("Apple")
            .clickButton("ASUS")
            .clickButton("HP")
            .clickButton("Xiaomi")

        // Проверяем, что нужные фирмы отмечены
            .checkTick("Apple")
            .checkTick("ASUS")
            .checkTick("HP")
            .checkTick("Xiaomi")

        // Очищаем поле поиска => Вводим "Зелёный слоник" => Нажимаем "Найти" => Ищем "Толстовка"
            .claerSearch()
            .fillGreenElephant()
            .tabSearch()
            .tabSweatshirt()
            .openSite(url, driver);
    }

    @AfterAll
    public static void afterTest() {
        System.out.println("Тест окончен");
        driver.quit();
    }
}