//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;
//
//public class PageObject<T extends PageObject> {
//    private WebDriver driver;
//
//    public PageObject(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//        this.driver = driver;
//    }
//
//    public T openSite(String url, WebDriver webDriver, Class classClass) {
//        classClass.cast();
//        webDriver.get(url);
//        return classClass;
//    }
//
//    public YandexMarketPageObject tabClick(String s) {
//        driver.findElement(By.xpath("//*[.='" + s + "']")).click();
//        return new YandexMarketPageObject(driver);
//    }
//
////    public YandexHomePageObject openSite(String url, WebDriver WebDriver) {
////        WebDriver.get(url);
////        return new YandexHomePageObject(driver);
////    }
//
////    public YandexMarketPageObject tabClick(String s) {
////        driver.findElement(By.xpath("//*[.='" + s + "']")).click();
////        return this;
////    }
//}
