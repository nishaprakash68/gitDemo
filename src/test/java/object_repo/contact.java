package object_repo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.Map;

public class contact {
	
    WebDriver driver;
    String username,password;
    JavascriptExecutor jsObj;
    public contact(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        jsObj = (JavascriptExecutor)driver;
    }

    @FindBy(xpath = "//input[@name='YourName']")
    WebElement fNameTxtField;
    @FindBy(xpath = "//input[@name='YourEmail']")
    WebElement emailTxtField;
   
    @FindBy(xpath = "//textarea[@name='Describemoredetails']")
    WebElement detailsTxtField;
   /* @FindBy(xpath = "//input[@name='your-company']")
    WebElement companyTxtField;*/
    
    @FindBy(xpath = "//input[@name='YourContactNumber']")
    WebElement contactTxtField;
   
   


    @FindBy(xpath = "//input[@value='Schedule a free consultation']")
    WebElement submitButton;

    public void enterContactDetails(Map<String,String> mapObj) throws InterruptedException{
    	
    	JavascriptExecutor jse=(JavascriptExecutor)driver;
    	Thread.sleep(2000);
    	jse.executeScript("window.scrollBy(0,500)");
    	fNameTxtField.clear();
    	fNameTxtField.sendKeys(mapObj.get("name0"));
        emailTxtField.clear();
        contactTxtField.clear();
        Thread.sleep(1000);
        Reporter.log("email has been entered");
        contactTxtField.sendKeys(mapObj.get("phone0"));  
        emailTxtField.sendKeys(mapObj.get("email0"));
        Thread.sleep(2000);
      
        detailsTxtField.clear();
        Thread.sleep(1000);
       // phoneTxtField.sendKeys(mapObj.get("phone0"));
        detailsTxtField.sendKeys(mapObj.get("details0"));
        Thread.sleep(1000);
       // companyTxtField.clear();
       // faxTxtField.sendKeys(mapObj.get("company0"));
       // companyTxtField.sendKeys(mapObj.get("company0"));
        
            
    }

    public void submit(){
    	//submitButton.click();
    }
}
