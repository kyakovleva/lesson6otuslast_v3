import org.junit.Before;
import persPageBlocks.LanguageBlock;
import utils.DriverManager;
import enums.WebDriverName;
import exceptions.DriverNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.PersPage;
import persPageBlocks.ContactsBlock;
import persPageBlocks.CountryBlock;
import persPageBlocks.PersonalBlock;

import java.util.List;

public class MainTest {
    private WebDriver driver;
    private static final WebDriverName webDriverName = WebDriverName.valueOf(System.getProperty("driverName")); //chrome

    @BeforeClass
    public static void startUpDriver() throws DriverNotFoundException {
        DriverManager.startUp(WebDriverName.valueOf(System.getProperty("driverName")));
    }

    @Before
    public void startInitBrowser() throws DriverNotFoundException {
       driver = DriverManager.initDriver(webDriverName, List.of(System.getProperty("browser.mode")));
    }

    @After
    public void end() {
        DriverManager.end(driver);
    }


    @Test
    public void testPersPageFillandCheck() throws DriverNotFoundException {
        persPageFill();
        persPageCheck();
    }

    private void persPageCheck() throws DriverNotFoundException{
        startInitBrowser();
        MainPage mainPage = new MainPage(driver);
        PersPage persPage = new PersPage(driver);
        CountryBlock countryBlock = new CountryBlock(driver);
        ContactsBlock contactsBlock = new ContactsBlock(driver);
        LanguageBlock languageBlock = new LanguageBlock(driver);

        mainPage.open();
        mainPage.auth();
        persPage.open();
        countryBlock.checkCountryData();
        contactsBlock.checkContactsData();
        languageBlock.checkLanguageLevel();
    }

    private void persPageFill() {
        MainPage mainPage = new MainPage(driver);
        PersPage persPage = new PersPage(driver);
        PersonalBlock personalData = new PersonalBlock(driver);
        CountryBlock countryData = new CountryBlock(driver);
        ContactsBlock contactsBlock = new ContactsBlock(driver);
        LanguageBlock languageBlock = new LanguageBlock(driver);

        mainPage.open();
        mainPage.auth();

        persPage.open();

        personalData.fillPersonalData();

        countryData.fillCountryData();

        languageBlock.fillLanguageLevel();

        contactsBlock.addContacts();


        persPage.saveData();

        DriverManager.close(driver);
    }
}








