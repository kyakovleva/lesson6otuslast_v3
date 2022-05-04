package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BaseComponent;

public class MainPage extends BaseComponent {

    @FindBy(xpath = "//span[@class='header2__auth-reg']")
    private WebElement authButton;
    @FindBy(xpath = "//div[@class='new-log-reg__body']//input[@name='email']")
    private WebElement emailField;
    @FindBy(xpath = "//div[@class='new-log-reg__body']//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//div[@class='new-log-reg__body']//button")
    private WebElement loginButton;
    @FindBy(xpath = "//p[contains(@class,'header2-menu__item-text__username')]")
    private WebElement loginName;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(System.getProperty("base.url"));
    }

    public void auth() {
        authButton.click();
        emailField.sendKeys(System.getProperty("base.email"));
        passwordField.sendKeys(System.getProperty("base.password"));
        loginButton.click();

        String newUserName = loginName.getText();
        Assert.assertEquals("Пользователь не верен", "toyey", newUserName);
        logger.info("Пользователь авторизован");
    }
}
