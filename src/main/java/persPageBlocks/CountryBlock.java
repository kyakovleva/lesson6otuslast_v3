package persPageBlocks;


import enums.Cities;
import enums.Countries;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BaseComponent;

public class CountryBlock extends BaseComponent {

    @FindBy(xpath = "//input[@name='country']/following-sibling::div")
    private WebElement countryField;
    @FindBy(xpath = "//div[contains(@class,'lk-cv-block__select-scroll_country')]")
    private WebElement countrySelectField;
    @FindBy(xpath = "//input[@name='city']/following-sibling::div")
    private WebElement cityField;
    @FindBy(xpath = "//div[contains(@class,'lk-cv-block__select-scroll_city')]")
    private WebElement citySelectField;

    public CountryBlock(WebDriver driver) {
        super(driver);
    }

    public void fillCountryData() {
        Countries configCountry = serverConfig.country();
        Cities configCity = serverConfig.city();
        assert configCountry.equals(configCity.getCountry()) : "Заданный в конфиге город не принадлежит заданной стране";
        countryField.click();
        countrySelectField.findElement(By.xpath(String.format("button[@title='%s']", configCountry.getTranslate()))).click();
        wait.waitUntilTextPresents(cityField, "Город");
        cityField.click();
        citySelectField.findElement(By.xpath(String.format("button[@title='%s']", configCity.getTranslate()))).click();
    }


    public void checkCountryData() {
        Countries configCountry = serverConfig.country();
        Cities configCity = serverConfig.city();
        String getCountry = countryField.getText();
        String getCity = cityField.getText();

        assert configCountry.getTranslate().equals(getCountry) : "Страна не корректна";
        assert configCity.getTranslate().equals(getCity) : "Город не корректен";

        logger.info("Данные сохраненных страны и города отображаются корректно");
    }
}
