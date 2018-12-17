import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.stream.Stream;


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
//    @DisplayName("Сейчас как прогоним разок-другой этот тестик")
//    @ParameterizedTest(name = "{index} => Цена от {0} до {1}")
//    @CsvSource({
//            "100000, 150000",
//            "150000, 200000",
//            "200000, 250000"
//    })
//    @MethodSource("stringIntAndListProvider")
    public void yandexTest(String priceMin, String priseMax) {
        YandexPageObjectTest test = new YandexPageObjectTest(driver);
        // Заходим на Яндекс => Яндекс.Маркет => Вводим "Ноутбуки" => Проверяем => Нажимаем "Найти"
        test
            .openSite(url, driver)
            .tabClick("Маркет")
            .fillField("Ноутбуки")
            .checkFieldLaptop()
            .tabClick("Найти")

        // Вводим минимум и максимум цены и проверяем их
//            .fillPrice("Цена от", priceMin)
//            .fillPrice("Цена до", priseMax)
//            .checkPrice("Цена от", priceMin)
//            .checkPrice("Цена до", priseMax)
            .fillPrice("Цена от", "100000")
            .fillPrice("Цена до", "200000")
            .checkPrice("Цена от", "100000")
            .checkPrice("Цена до", "200000")

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
            .fillField("Зеленый слоник")
            .tabClick("Найти")
            .tabSweatshirt()
            .openSite(url, driver);
    }

    @AfterAll
    public static void afterTest() {
        System.out.println("Тест окончен");
        driver.quit();
    }

//    static Stream<Arguments> stringIntAndListProvider() {
//        return Stream.of(
//                Arguments.of("100000", "150000"),
//                Arguments.of("150000", "200000"),
//                Arguments.of("200000", "250000")
//        );
//    }
}