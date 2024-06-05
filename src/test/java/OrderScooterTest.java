import org.hamcrest.MatcherAssert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjectScooter.OrderPageScooter;
import pageObjectScooter.RentPageScooter;

import static locator.LocatorPageScooter.*;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class OrderScooterTest {

    private static WebDriver driver;
    private final By button;
    private final String username;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String numberPhone;
    private final String deliveryDate;
    private final int days;
    private final String colour;
    private final String comment;

    public OrderScooterTest(By button, String username, String lastName, String address, String metroStation, String numberPhone, String deliveryDate, int days,String colour, String comment) {
        this.button = button;
        this.username = username;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.numberPhone = numberPhone;
        this.deliveryDate = deliveryDate;
        this.days = days;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        // Тестовые данные для проверки
        return new Object[][]{
                {topOrderButton, "Иван", "Иванов", "г.Москва, Ярославское шоссе д.125", "Лубянка", "+79102225544", "08.07.2024", 4, "grey", "Обычный комментарий"},
                {lowerOrderButton, "Анна", "Сидорова", "г.Серпухов, ул.Новая 90, кв.36", "Измайлово", "+79991115588", "10.08.2024", 2,"grey", "Необычный комментарий"},
                {topOrderButton, "Виктория", "Соловьева", "Москва, улица Пушкина, дом 132 корп 1 кв 87", "Арбатская", "+79442227788", "26.07.2024", 1, "black", "Необычный комментарий - проверка"},
                {lowerOrderButton, "Артем", "Лоек", "г.Химки, ул.Перспективная 120, кв.99", "Новокузнецкая", "+79602115555", "15.08.2024", 7,"black", "Обычный комментарий - доставку организовать до 12:00 мск"},
        };
    }

    @BeforeClass
    public static void initHomePage() {
        // Cоздали драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage", "--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Согласие с куки
        WebElement element = driver.findElement(buttonApprovalCookie);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
    @Test
    public void checkOrderHeaderButton() {
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        RentPageScooter objRentPage = new RentPageScooter(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        objOrderPage.createdOrder(
                button,
                username,
                lastName,
                address,
                metroStation,
                numberPhone);
        objOrderPage.clickNextButton();
        objRentPage.aboutRent(
                deliveryDate,
                days,
                colour,
                comment);
        objRentPage.clickButtonOrderNext();
        objRentPage.clickButtonOrderYes();
        String actualResult = driver.findElement(modalWindow).getText();
        String textOrder = "Заказ оформлен\n" + "Номер заказа:";
        MatcherAssert.assertThat(actualResult, containsString(textOrder));
        objRentPage.clickOnButtonCheckStatus();
    }
    @AfterClass
    public static void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}







