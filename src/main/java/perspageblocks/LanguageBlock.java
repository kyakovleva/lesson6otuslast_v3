package perspageblocks;

import enums.EnglishLevels;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguageBlock extends BaseComponent {

    @FindBy(xpath = "//input[@name='english_level']/following-sibling::div")
    private WebElement engLevelField;

    public LanguageBlock(WebDriver driver) {
        super(driver);
    }

    public void fillLanguageLevel(){
        engLevelField.click();
        WebElement languageLevel = driver.findElement(By.xpath(String.format("//button[contains(text(),'%s')]",serverConfig.engLevel().getLanguageDescr())));
        languageLevel.click();
    }
    public void checkLanguageLevel(){
        EnglishLevels englishLevel = serverConfig.engLevel();
        String getEngLevel = engLevelField.getText();
        assert englishLevel.getLanguageDescr().equals(getEngLevel) : "Уровень языка не корректен";
        logger.info("Данные сохраненного языка отображаются корректно");
    }
}
