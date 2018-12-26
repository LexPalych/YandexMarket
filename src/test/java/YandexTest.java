import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

/**
 * Подключение расширения
 */
@ExtendWith(SeleniumExtension.class)
/**
 * Разрешение параллельного выполнения тестов
 */
@Execution(CONCURRENT)
public class YandexTest {
    /**
     * Инициализация происходит в SeleniumExtension
     */
    private YandexHomePageObject yandexHomePageObject;

    @DisplayName("Сейчас как прогоним разок-другой этот тестик")
    @ParameterizedTest(name = "{index} => Цена от {0} до {1}")
    @MethodSource("stringIntAndListProvider")
    public void yandexTest(String priceMin, String priseMax) {

        // Заходим на Яндекс => Яндекс.Маркет => Вводим "Ноутбуки" => Проверяем => Нажимаем "Найти"
        yandexHomePageObject
            .tabClick("Маркет", YandexMarketPageObject.class)
            .fillSearch("Ноутбуки")
            .checkFieldLaptop()
            .tabClick("Найти", YandexMarketPageObject.class)

            // Вводим минимум и максимум цены и проверяем их
            .fillPrice("Цена от", priceMin)
            .fillPrice("Цена до", priseMax)
            .checkPrice("Цена от", priceMin)
            .checkPrice("Цена до", priseMax)

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
            .clearSearch()
            .fillSearch("Зеленый слоник")
            .tabClick("Найти", YandexMarketPageObject.class)
            .tabSweatshirt();
    }

    private static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                Arguments.of("100000", "150000"),
                Arguments.of("150000", "200000"),
                Arguments.of("200000", "250000"));
    }
}