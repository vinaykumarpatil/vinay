package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class ScreenShot {
	public static void tekeScreenShot(WebDriver driver,String name) throws IOException {
		String d=ScreenShot.date();
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    File destination= new File("D:\\Screenshot\\"+ name + d+".jpg");
		FileHandler.copy(source, destination);
}
	public static String date() {
		DateTimeFormatter dtf =DateTimeFormatter.ofPattern("yyyy-MMM-dd HH-mm-ss");//format the date time and reqired
		LocalDateTime currentTime =LocalDateTime.now();//return current time
		String d = dtf.format(currentTime);
		return d;
	}
}