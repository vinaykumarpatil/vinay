package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.ZerodhaLoginPage;
import pom.ZerodhaSignUpPage;
import utility.Excel;

public class ZerothaSignUpPageTest {
	WebDriver driver;
	@BeforeMethod
	
	public void OpenBrowser() {
		driver= Browser.chromeBrowser();
	}
	@Test
	public void  SignUpTest() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaSignUpPage zerodhaSignUpPage= new ZerodhaSignUpPage(driver);
		zerodhaSignUpPage.ClickOnSignUpPage();
		zerodhaSignUpPage.SwitchHandle(driver);
		String mobile=Excel.getData("testdata", 3, 0);
		zerodhaSignUpPage.EnterUserMobile(mobile);
		//zerodhaSignUpPage.ClickOnContinue();
		
		
	}
	
}
