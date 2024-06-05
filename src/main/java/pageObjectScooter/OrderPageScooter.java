package pageObjectScooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static locator.LocatorPageScooter.*;

public class OrderPageScooter {
    private static WebDriver driver;

    public OrderPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для нажатия кнопки "Заказать"
    public void clickOnMakeOrderButton(By button) {
        WebElement element = driver.findElement(button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
    // Метод для заполнения поля Имя
    public void setNameFieldOrder(String username) {
        driver.findElement(nameFieldOrder).sendKeys(username);
    }

    // Метод для заполнения поля Фамилия
    public void setLastName(String lastName) {
        driver.findElement(lastNameFieldOrder).sendKeys(lastName);
    }

    // Метод для заполнения поля "Адрес: куда привезти заказ"
    public void setAddressFieldOrder(String address) {
        driver.findElement(addressFieldOrder).sendKeys(address);
    }

    // Метод для заполнения поля "Станция метро"
    public void setMetroFieldOrder(String metroStation) {
        driver.findElement(metroFieldOrder).sendKeys(metroStation);
        WebElement optionsCont = driver.findElement(metroListFieldOrder);
        optionsCont.click();
    }

    // Метод для заполнения поля "Телефон: на него позвонит курьер"
    public void setNumberFieldOrder(String numberPhone) {
        driver.findElement(numberFieldOrder).sendKeys(numberPhone);
    }

    // Метод для нажатия кнопки Далее
    public void clickNextButton() {
        WebElement element = driver.findElement(nextButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    // Метод для всех заполнения полей на шаге "Для кого самокат"
    public void createdOrder(By button, String username, String lastName, String address, String metroStation, String numberPhone) {
        clickOnMakeOrderButton(button);
        setNameFieldOrder(username);
        setLastName(lastName);
        setAddressFieldOrder(address);
        setMetroFieldOrder(metroStation);
        setNumberFieldOrder(numberPhone);
    }
}

