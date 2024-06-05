package pageObjectScooter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static locator.LocatorPageScooter.*;

public class HomePageScooter {

    private static WebDriver driver;

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //  Метод поиска кнопки "Заказать" в хедере страницы и нажатия на неё
    public void clickOnMiddleOrderButton() {
        WebElement element = driver.findElement(topOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    //  Метод поиска кнопки "Заказать" в нижней части страницы и нажатия на неё
    public void clickLowerOrderButton(){
        WebElement elementLowerButton = driver.findElement(lowerOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementLowerButton);
        elementLowerButton.click();
    }

    //  Метод для получения списка вопросов на главной странице
    public static void listToImportantQuestions(int questionNumber) {
        List<WebElement> list_elements = driver.findElements(buttonQuestionsText);
        WebElement element = list_elements.get(questionNumber);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
}





















