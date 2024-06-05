package locator;

import org.openqa.selenium.By;

public class LocatorPageScooter {

    // локатор кнопки ответа на вопросы
    public static final By buttonQuestionsText = By.xpath(".//div[@class='accordion__button']");

    // локатор кнопки согласия Куки
    public static final By buttonApprovalCookie =By.xpath(" .//button[@id='rcc-confirm-button']");

    // локатор верхней кнопки "Заказать"
    public static final By topOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");

    // локатор нижней кнопки "Заказать"
    public static final By lowerOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    // локатор поля "Имя" в форме подачи заявки на шаге "Для кого самокат"
    public static final By nameFieldOrder = By.xpath(".//input[@placeholder='* Имя']");

    // локатор поля "Фамилия" в форме подачи заявки на шаге "Для кого самокат"
    public static final By lastNameFieldOrder = By.xpath(".//input[@placeholder='* Фамилия']");

    // локатор поля "Адрес: куда привезти заказ" в форме подачи заявки на шаге "Для кого самокат"
    public static final By addressFieldOrder = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // локатор поля "Станция метро" в форме подачи заявки на шаге "Для кого самокат"
    public static final By metroFieldOrder =  By.className("select-search__input");

    // локатор списка "Станция метро" в форме подачи заявки на шаге "Для кого самокат"
    public static final By metroListFieldOrder =  By.className("select-search__select");

    // локатор поля "Телефон: на него позвонит курьер" в форме подачи заявки на шаге "Для кого самокат"
    public static final By numberFieldOrder = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // локатор кнопки Далее в форме подачи заявки на шаге "Для кого самокат"
    public static final By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");

    // Локатор поля "Когда привезти самокат" на шаге "Про аренду"
    public static final By fieldDeliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // локатор поля "Срок аренды" в форме подачи заявки на шаге "Про аренду"
    public static final By fieldOfRentalPeriod = By.className("Dropdown-arrow");

    // Локатор списка "Срок аренды" на странице "Про аренду"
    public static final By listOfRentalPeriod = By.className("Dropdown-option");

    // локатор поля "Комментарии для курьера" в форме подачи заявки на шаге "Про аренду"
    public static final  By commentFieldOrder = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // локатор кнопки "Заказать" в форме подачи заявки на шаге "Про аренду"
    public static final By buttonOrderNext = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[2]");

    // локатор кнопки "Да" в форме подачи заявки на шаге Подтверждение заказа
    public static final By buttonOrderYes = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[2]/button[2]");

    // локатор кнопки Модального окна успешного заказа
    public static final By modalWindow = By.cssSelector("html body div#root div.App_App__15LM- div.Order_Content__bmtHS div.Order_Modal__YZ-d3");

    // локатор кнопки "Посмотреть статус" в модальном окне "Заказ оформлен"
    public static final By statusOrder = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[2]/button[1]");
}
