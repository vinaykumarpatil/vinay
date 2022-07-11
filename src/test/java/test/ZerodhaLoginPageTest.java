package test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.ZerodhaLoginPage;
import utility.Excel;

public class ZerodhaLoginPageTest {
	WebDriver driver;
	@BeforeMethod
	public void OpenBrowser() {
		driver=Browser.chromeBrowser();
	}
	
	@Test
	public void LoginTest() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaLoginPage zerodhaLoginPage =new ZerodhaLoginPage(driver);
		String userId=Excel.getData("testdata", 0, 0);
		String pass=Excel.getData("testdata", 1, 0);
		String pin=Excel.getData("testdata", 2, 0);
		boolean status =zerodhaLoginPage.isImageDisplayed();
		Assert.assertTrue(status);//hard assert
		zerodhaLoginPage.EnterUserId(userId);
		zerodhaLoginPage.EnterPassword(pass);
		zerodhaLoginPage.ClickOnLogin();	
		zerodhaLoginPage.enterPin(pin ,driver);
		zerodhaLoginPage.ClickOnContinue();
	}
	@Test
	public void forgotTest() {
		ZerodhaLoginPage zerodhaLoginPage =new ZerodhaLoginPage(driver);
		zerodhaLoginPage.ClickOnForgotLink();
		
	}

}
