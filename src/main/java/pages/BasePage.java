package pages;

import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.JsOperations;
import utils.WaitMethods;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final WaitMethods wait;
    protected final JsOperations js;
    protected final ServerConfig serverConfig = ConfigFactory.create(ServerConfig.class);
    protected final Logger logger = LogManager.getLogger(PersPage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitMethods(driver, 10, 5);
        this.js = new JsOperations(driver);
        PageFactory.initElements(driver,this);
    }
}
