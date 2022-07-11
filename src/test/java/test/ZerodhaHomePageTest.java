package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.ZerodhaHomePage;
import pom.ZerodhaLoginPage;
import utility.Excel;

public class ZerodhaHomePageTest {
	WebDriver driver;
	@BeforeMethod
	public void OpenBrowser() throws EncryptedDocumentException, IOException, InterruptedException {
		driver=Browser.chromeBrowser();
		ZerodhaLoginPage zerodhaLoginPage =new ZerodhaLoginPage(driver);
		String userId=Excel.getData("testdata", 0, 0);
		String pass=Excel.getData("testdata", 1, 0);
		String pin=Excel.getData("testdata", 2, 0);
		zerodhaLoginPage.EnterUserId(userId);
		zerodhaLoginPage.EnterPassword(pass);
		zerodhaLoginPage.ClickOnLogin();	
		zerodhaLoginPage.enterPin(pin ,driver);
		zerodhaLoginPage.ClickOnContinue();
	}
	@Test(priority=0)
	public void buyFromWatchListTest() {
		ZerodhaHomePage zerodhaHomePage= new ZerodhaHomePage(driver);
		zerodhaHomePage.SelectShareFromWatchlistAndBuy("GOLDBEES", driver);
	}
	@Test
	public void buyFromSearchListTest() {
		ZerodhaHomePage zerodhaHomePage= new ZerodhaHomePage(driver);
		zerodhaHomePage.enterStockToSearch("BANKBARODA");
		zerodhaHomePage.SelectShareFromSearchlistAndBuy("BANKBARODA", driver);
	}
	
}
