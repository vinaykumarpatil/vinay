package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaLoginPage {
	
		@FindBy(xpath="//input[@id='userid']")private WebElement userId;
		@FindBy(xpath="//input[@id='password']")private WebElement password;
		@FindBy(xpath="//button[@class='button-orange wide']")private WebElement login;
		@FindBy(xpath="//a[text()='Forgot user ID or password?']")private WebElement forgot;
		@FindBy(xpath="//a[@class='text-light']")private WebElement signUp;
		@FindBy(xpath="//input[@id='pin']")private WebElement pin;
		@FindBy(xpath="//button[@class='button-orange wide']")private WebElement submit;
		@FindBy(xpath="//a[@class='text-light forgot-link']")private WebElement forgotPass;
		@FindBy(xpath="//img [@src='/static/images/kite-logo.svg\']")private WebElement logo;
		
		public  ZerodhaLoginPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		public void EnterUserId(String UserId) {
			userId.sendKeys(UserId);
		}
		public void EnterPassword(String pass) {
			password.sendKeys(pass);
		}
		public void ClickOnLogin() {
			login.click();
		}
		public void ClickOnForgotLink() {
			forgot.click();
	    }
		public void ClickOnSignUp() {
			signUp.click();
		}
		public void enterPin(String pinNumber,WebDriver driver) {
			//WebDriverWait wait= new WebDriverWait(driver,Duration.ofMillis(2000));
		  //  wait.until(ExpectedConditions.visibilityOf(pin));
			FluentWait<WebDriver> wait= new FluentWait<WebDriver>(driver);
			wait.withTimeout(Duration.ofMillis(50000));
			wait.pollingEvery(Duration.ofMillis(1000));
			wait.ignoring(Exception.class);
			wait.until(ExpectedConditions.visibilityOf(pin));
			pin.sendKeys(pinNumber);
		}
		public void ClickOnContinue() {
			submit.click();
			
		}
		public boolean isImageDisplayed() {
			
			return logo.isDisplayed();
		}


}
