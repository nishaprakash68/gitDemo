package steps;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import object_repo.GmailVerify;
import utilities.DataProvider;

public class GmailVerifyStep extends utilities.Base {
	GmailVerify cObj;
	WebDriverWait wait;
	String verifyStatus;
	String verifyDeleteStatus;
	@Test(priority = 0)
	public void gmail_login() throws IOException, InterruptedException{
		Map<String, String> mapObj = new DataProvider().getGmailDetails();
		cObj = new GmailVerify(driver);
		cObj.enterLoginDetails(mapObj);
		Thread.sleep(10000);
		
	}

	@Test(dependsOnMethods = "gmail_login")
	public void contact_form_verify() throws IOException, InterruptedException {
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		Date dateobj = new Date();
		
		System.out.println(df.format(dateobj));
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@aria-label=\"Advanced search options\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span/label[contains(text(),\"From\")]/ancestor::span/following-sibling::span/input[@type=\"text\"]")).sendKeys("noreply@pulsetechsolutions.com.au");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span/label[contains(text(),\"Has the words\")]/ancestor::span/following-sibling::span/input[@type=\"text\"]")).sendKeys("Name: John Doe");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@aria-label=\"Date\"]")).sendKeys(df.format(dateobj),Keys.ENTER);
		Thread.sleep(10000);
		java.util.List<WebElement> a = driver.findElements(By.xpath("//*[@class='yW']/span/span"));
		System.out.println(a.size());
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i).getText());		
			if (a.get(i).getText().equals("Pulse Tech Solutions")) {	
				Thread.sleep(1000);
				a.get(i).click();
			}
		}
		verifyStatus = driver.findElement(By.xpath("//h2[contains(text(),\"Get in touch\")]/ancestor::div/h2")).getText();
		Assert.assertEquals("Get in touch", verifyStatus);
	}
	@Test(dependsOnMethods = "contact_form_verify")
	public void delete_contact_form_email() throws IOException, InterruptedException {
		
		
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[@class='iH bzn']//div[@class='T-I J-J5-Ji nX T-I-ax7 T-I-Js-Gs mA']//div[@class='asa']")).click();
		Thread.sleep(500);
		if(driver.findElement(By.xpath("//span[contains(text(),\"Conversation moved to Trash.\")]"))!= null){

			verifyDeleteStatus="Element is Present";

			}else{

				verifyDeleteStatus="Element is Absent";

			}
		Assert.assertEquals("Element is Present", verifyDeleteStatus);
	}
}
