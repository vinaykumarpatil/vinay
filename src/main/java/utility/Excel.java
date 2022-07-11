package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static String  getData(String SheetName,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream File=new FileInputStream("C:\\Users\\SWAPNALI\\eclipse-workspace\\KiteZerodha\\src\\test\\resources\\testdata.xlsx");
		String value=WorkbookFactory.create(File).getSheet(SheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;
		
	}

}
