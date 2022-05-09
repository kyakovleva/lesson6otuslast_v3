package perspageblocks;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalBlock extends BaseComponent {

        @FindBy(css = "input[type='text'][name='fname']")
    private WebElement nameField;
    @FindBy(css = "input[type='text'][name='fname_latin']")
    private WebElement nameEngField;
    @FindBy(css = "input[type='text'][name='lname']")
    private WebElement surnameField;
    @FindBy(css = "input[type='text'][name='blog_name']")
    private WebElement surnameEngField;
    @FindBy(css = "input[type='text'][name='blog_name']")
    private WebElement nickNameField;
    @FindBy(css = "input[name='date_of_birth']")
    private WebElement dateOfBirthField;
    @FindBy(xpath = "//label[contains(text(),'Дата рождения')]")
    private WebElement dateOfBirthArea;

    public PersonalBlock(WebDriver driver) {
        super(driver);
    }

    public void fillName() {
        nameField.clear();
        nameField.click();
        nameField.sendKeys(serverConfig.name());
    }

    public void fillEngName() {
        nameEngField.clear();
        nameEngField.click();
        nameEngField.sendKeys(serverConfig.name());
    }

    public void fillSurname() {
        surnameField.clear();
        surnameField.click();
        surnameField.sendKeys(serverConfig.surname());
    }

    public void fillEngSurname() {
        surnameEngField.clear();
        surnameEngField.click();
        surnameEngField.sendKeys(serverConfig.surname());
    }

    public void fillNickName() {
        nickNameField.clear();
        nickNameField.click();
        nickNameField.sendKeys(serverConfig.name());
    }

    public void fillBirthDate() {
        dateOfBirthField.clear();
        dateOfBirthField.click();
        dateOfBirthField.sendKeys(serverConfig.birth());
        dateOfBirthArea.click();
    }

    public void fillPersonalData() {
        fillName();
        fillEngName();
        fillSurname();
        fillEngSurname();
        fillNickName();
        fillBirthDate();
    }
}
