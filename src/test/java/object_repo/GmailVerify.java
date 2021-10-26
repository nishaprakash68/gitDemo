package object_repo;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailVerify {
	WebDriver driver;
    String username,password;
    JavascriptExecutor jsObj;
    public GmailVerify(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        jsObj = (JavascriptExecutor)driver;
    }
    
    @FindBy(xpath = "//input[@id=\"identifierId\"]")
    WebElement emailTxtField;
    @FindBy(xpath = "//input[contains(@name,\"password\")]")
    WebElement pwdTxtField;
    @FindBy(xpath = "//span[contains(text(),\"Next\")]")
    WebElement nextBtn;
    @FindBy(xpath = "//input[@placeholder=\"State\"]")
    WebElement stateTxtField;
    @FindBy(xpath = "//input[@placeholder=\"Country\"]")
    WebElement countryTxtField;
 

    @FindBy(xpath = "//input[@id=\"gform_submit_button_3\"]")
    WebElement submitButton;

    public void enterLoginDetails(Map<String,String> mapObj) throws InterruptedException{
    	emailTxtField.clear();
    	emailTxtField.sendKeys(mapObj.get("email0"));
    	nextBtn.click();
    	Thread.sleep(9000);
    	pwdTxtField.clear();
        pwdTxtField.sendKeys(mapObj.get("password0"));
        nextBtn.click();
    }

    public void submit(){
        submitButton.click();
    }
}
