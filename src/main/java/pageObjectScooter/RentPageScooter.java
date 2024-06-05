package pageObjectScooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static locator.LocatorPageScooter.*;

public class RentPageScooter {
    private static WebDriver driver;

    public RentPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для заполнения поля "Когда привезти самокат"
    public void setFieldDeliveryDate(String deliveryDate) {
        driver.findElement(fieldDeliveryDate).sendKeys(deliveryDate);
    }

    // Метод для выбора поля "Срок аренды"
    public void clickRentalPeriod() {
        driver.findElement(fieldOfRentalPeriod).click();
    }

    // Метод для заполнения поля "Срок аренды"
    public void selectRentalPeriod(int days) {
        int maxDays = 7;
        int dayIndex;
        if (days > 0 && days <= maxDays) {
            dayIndex = days - 1;
            List<WebElement> dropdownOptions = driver.findElements(listOfRentalPeriod);
            dropdownOptions.get(dayIndex).click();
        }
    }

    // Метод для заполнения поля "Цвет самоката"
    public void selectColour(String colour) {
        driver.findElement(By.id(colour)).click();
    }

    // Метод для заполнения поля "Комментарии курьеру"
    public void setCommentFieldOrder(String comment) {
        driver.findElement(commentFieldOrder).sendKeys(comment);
    }

    // Метод для нажатия кнопки "Заказать" в форме подачи заявки на шаге "Про аренду"
    public void clickButtonOrderNext() {
        driver.findElement(buttonOrderNext).click();
    }

    // Метод для заполнения полей на шаге "Про аренду"
    public void aboutRent (String deliveryDate,int days,String colour,String comment) {
        setFieldDeliveryDate(deliveryDate);
        clickRentalPeriod();
        selectRentalPeriod(days);
        selectColour(colour);
        setCommentFieldOrder(comment);
    }

    // Метод для подтверждения заказа на шаге "Про аренду"
    public void clickButtonOrderYes() {
        driver.findElement(buttonOrderYes).click();
    }
    // Метод для нажатия кнопки Статус
    public void clickOnButtonCheckStatus() {
        driver.findElement(statusOrder).click();
    }
}

