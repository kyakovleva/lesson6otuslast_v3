package pages;

import org.openqa.selenium.support.FindBy;
import utils.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PersPage extends BaseComponent {

    @FindBy(xpath = "//p[contains(@class,'header2-menu__item-text__username')]")
    private WebElement authMenu;
@FindBy(xpath = "//b[contains(@class,'header2-menu__dropdown-text_name')]")
private WebElement profile;
    @FindBy(xpath = "//button[@title='Сохранить и заполнить позже']")
    private WebElement saveLaterButton;
@FindBy(xpath = "//span[contains(@class,'messages')]")
private WebElement messageSaveAlert;


    public PersPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        Actions actions = new Actions(driver);
        actions.moveToElement(authMenu).build().perform();
        actions.moveToElement(profile).build().perform();
        profile.click();
        logger.info("Открыта страница Персональные данные");
    }


    public void saveData() {
        Actions actions = new Actions(driver);
        actions.moveToElement(saveLaterButton);
        saveLaterButton.click();
        wait.waitUntilTextPresents(messageSaveAlert, "Данные успешно сохранены");
        logger.info("Данные сохранены");
    }
}
