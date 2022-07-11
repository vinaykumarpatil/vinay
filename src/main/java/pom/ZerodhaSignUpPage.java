package pom;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaSignUpPage {
	@FindBy(xpath="//a[@class='text-light']")private WebElement signUp;
	@FindBy(xpath="//input[@id='user_mobile']") private WebElement userMobile;
	@FindBy(xpath="//button[@id='open_account_proceed_form']") private WebElement continueLink;


public ZerodhaSignUpPage(WebDriver driver) {
	PageFactory.initElements( driver,this);
}
public void ClickOnSignUpPage() {
	signUp.click();
}
public void SwitchHandle(WebDriver driver) throws InterruptedException {
	   String homepage=driver.getWindowHandle();
	   Set<String> handles =driver.getWindowHandles();
	   Iterator<String> i=handles.iterator();
	   while(i.hasNext())
	   {
	   Thread.sleep(3000);
	   String handle=i.next();
	   driver.switchTo().window(handle);
	   String title=driver.getTitle();
	   System.out.println(title);
	   if(title.equals("Kite - Zerodha's fast and elegant flagship trading platform\r\n"
	   		+ "Signup and open a Zerodha trading and demat account online and start investing – Zerodha"))
	   {
	   }	   
	   }	      
}

public void EnterUserMobile(String number) {
	userMobile.sendKeys(number);
}
public  void ClickOnContinue() {
	continueLink.click();
}
}