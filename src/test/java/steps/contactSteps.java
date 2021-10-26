package steps;




import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import object_repo.contact;
import utilities.Base;
import utilities.DataProvider;

import java.io.IOException;
import java.util.Map;

public class contactSteps extends Base {
	String verifyStatus;
	contact cObj;
    @Test
    public void submit_contact() throws IOException, InterruptedException {
        Map<String,String>mapObj=new DataProvider().getDetails();
        cObj=new contact(driver);
        cObj.enterContactDetails(mapObj);
        /*driver.findElement(By.xpath("//select[@name='your-state']")).click();
        Select state= new Select(driver.findElement(By.xpath("//select[@name='your-state']")));
        state.selectByVisibleText("Massachusetts");*/
      
       // cObj.submit();
        //Thread.sleep(10000);
        /*verifyStatus = driver.findElement(By.xpath("//p[contains(text(),\"Your request has been received, we will be in touch soon!\")]")).getText();
		Assert.assertEquals("Your request has been received, we will be in touch soon!", verifyStatus);*/
    }
}
