package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaHomePage {
	@FindBy(xpath="//input[@icon='search']")private WebElement search;
	@FindBy(xpath="//span[@class='nice-name']")private List<WebElement> shares;
	@FindBy(xpath="//button[@class='button-blue buy']")private WebElement watchListBuy;
	
	@FindBy(xpath="//span[@class='tradingsymbol']")private List<WebElement> searchListshares;
	@FindBy(xpath="(//button[@class='button-blue'])[1]")private WebElement searchListBuy;
	//@FindBy(xpath="//button[@class='button-orange']")private WebElement sell;

	
	
	@FindBy(xpath="//button[@class='button-orange sell']")private WebElement sell;
	@FindBy(xpath="(//button[@class='button-outline'])[1]")private WebElement marketDepth;
	@FindBy(xpath="(//button[@class='button-outline'])[2]")private WebElement chart;
	@FindBy(xpath="(//button[@class='button-outline'])[3]")private WebElement delete;
	@FindBy(xpath="//button[@data-balloon='more']")private WebElement more;
	@FindBy(xpath="//span[text()='Dashboard']")private WebElement dashbord;
	@FindBy(xpath="//span[text()='Orders']")private WebElement orders;
	@FindBy(xpath="//span[text()='Positions']")private WebElement positions;
	@FindBy(xpath="//span[text()='Funds']")private WebElement funds;
	@FindBy(xpath="//span[text()='Apps']")private WebElement apps;
	@FindBy(xpath="//span[text()='OKP335']")private WebElement userId;
	@FindBy(xpath="//a[@class='button button-blue']")private WebElement activate;
	@FindBy(xpath="(//button[@class='button-blue'])[1]")private WebElement startInvesting;
	@FindBy(xpath="(//button[@class='button-blue'])[1]")private WebElement getStarted;
	@FindBy(xpath="(//span[@class='exchange'])[1]")private WebElement add;

	
	
	public ZerodhaHomePage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	public void enterStockToSearch(String stockName) {
		
		search.sendKeys(stockName);
		
	}
	
	public void SelectShareFromWatchlistAndBuy(String shareName , WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(search));
		System.out.println(shares.size());
		for(int i=0; i<shares.size(); i++)
		{
			WebElement stock=shares.get(i);
			String stockName=stock.getText();
			System.out.println(stockName);
			if(stockName.equals(shareName))
			{
			   Actions action=new Actions(driver);
			   WebDriverWait wait1=new WebDriverWait(driver,Duration.ofMillis(3000));
			   wait1.until(ExpectedConditions.visibilityOf(stock));
			   action.moveToElement(stock);
			   action.perform();
			   watchListBuy.click();
			}
		}
	}
	public void SelectShareFromSearchlistAndBuy(String shareName , WebDriver driver) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(search));
	  //  search.sendKeys("BANKBARODA");
		System.out.println(searchListshares.size());
		for(int i=0; i<searchListshares.size(); i++)
		{
			WebElement stock=searchListshares.get(i);
			String stockName=stock.getText();
			WebDriverWait wait2=new WebDriverWait(driver,Duration.ofMillis(3000));
			wait2.until(ExpectedConditions.visibilityOf(stock));
			if(stockName.equals(shareName))
			{
			   Actions action=new Actions(driver);
			   WebDriverWait wait1=new WebDriverWait(driver,Duration.ofMillis(3000));
			   wait1.until(ExpectedConditions.visibilityOf(stock));
			   
			   action.moveToElement(stock);
	
			   action.perform();
			   searchListBuy.click();
			}
		}
	}
	
	

	
	
	
	
	
}

