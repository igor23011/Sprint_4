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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static locator.LocatorPageScooter.*;
import static org.junit.Assert.assertEquals;
import java.util.List;

@RunWith(Parameterized.class)
public class ListQuestionsTest {

    private static WebDriver driver;
    private final int questionNumber;
    private final String answerToQuestion;

    public ListQuestionsTest(int questionNumber, String answerToQuestion) {
        this.questionNumber = questionNumber;
        this.answerToQuestion = answerToQuestion;
    }

    @Parameterized.Parameters
    public static Object[][] getExpectedAnswers() {
        // Тестовые данные для проверки (номер кнопки и содержание текста под соответсвующей
        // кнопкой
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с " +
                        "друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня." +
                        " Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                        "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить " +
                        "в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь " +
                        "суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет," +
                        " объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @BeforeClass
    public static void initHomePage() {
        // Cоздали драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage", "--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    @Test
    public void checkAnswersToImportantQuestions() {
        // Получаем список элементов, содержащие ответы на вопросы и обращаемся к каждому элементу
        List<WebElement> list_elements = driver.findElements(buttonQuestionsText);
        WebElement element = list_elements.get(questionNumber);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        // Получаем Xpath каждого конктретного ответа
        String answerId = ("accordion__panel-" + questionNumber);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(answerId)));
        // Получаем текст ответа и сравниваем с тестовыми данными
        String tagText = driver.findElement(By.id(answerId)).getText();
        assertEquals(answerToQuestion, tagText);
    }
    @AfterClass
    public static void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
