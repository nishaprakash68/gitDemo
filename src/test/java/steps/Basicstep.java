package steps;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basicstep {
	
	public static WebDriver driver;
	 @BeforeTest
	
	public void login() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.get("http://demo.guru99.com/test/selenium-xpath.html");
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;
        driver.findElement(By.xpath(null)).sendKeys("testing");
        driver.findElement(By.xpath(null)).submit();
        Reporter.log("this is for testing");
        driver.findElement(By.xpath("//input[@value='Option 1']")).click();
        driver.findElement(By.xpath("//input[@value='checkbox1']")).click();
        int a=5;
        Assert.assertEquals(5, a);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        ArrayList<String> handles=new ArrayList<String>(driver.getWindowHandles());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        js.executeScript("window.scrollBy(0,1000)"); //Scroll vertically down by 1000 pixels
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(null)));
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        
	}
	
	  @Test
      public void verifyHomepageTitle() {
         System.out.println("we arelearning");
         Actions mousehover= new Actions(driver);
         mousehover.moveToElement(null).build().perform();
         
     }
	  
	  @AfterTest
      public void terminateBrowser(){
          driver.close();
      }
	

}
