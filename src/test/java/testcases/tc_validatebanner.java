package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import repository.LandingPageObjects;
import resources.base;
@Listeners(testcases.Listeners.class)
public class tc_validatebanner extends base{

	private static Logger log=LogManager.getLogger(tc_validatebanner.class.getClass());
	WebDriver driver;
	Properties prop=new Properties();

	@BeforeTest
	public void invokeBrowser() throws IOException{
		driver=initializebrowser();
		
	}
	@Test
	public void tc3_validateBanner() throws IOException{
		NavigateUrl();
		log.debug("Navigated to the URL successfully");
		LandingPageObjects landingp=new LandingPageObjects(driver);
		List<WebElement> bannereles=landingp.bannerElements();
		String[] expectedbannernames=getdata("Expected Banner Name");
		for (WebElement bannerelement : bannereles) {
			for(String expectedbannername:expectedbannernames)
				
			AssertJUnit.assertTrue(bannerelement.getText().contains(expectedbannername));
			
		}
	}
		@SuppressWarnings("deprecation")
		public String[] getdata(String expectedbanner) throws IOException{
			ArrayList data=new ArrayList();
			String[] expb = null;
			FileInputStream fis=new FileInputStream("C:\\Users\\Phani\\Documents\\selenium\\E2Eproject\\src\\main\\java\\resources\\TestData.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheet("Sheet1");
			Iterator<Row> rows=sheet.iterator();
			int k = 0;
			int column = 0;
			while(rows.hasNext()){
				Row row=rows.next();
				
				Iterator<Cell> cell=row.cellIterator();
				while(cell.hasNext()){
					Cell c=cell.next();
					if (c.getStringCellValue().equals("TestCase Name")) {
						column=k;
					System.out.println(column);
					}
					k++;
					
				}
			
				if (row.getCell(column).getStringCellValue().equalsIgnoreCase(expectedbanner)) {
					Iterator<Cell> cv=row.iterator();
					while(cv.hasNext()){
						cv.next();
						//if (cv.next().getCellType()==CellType.STRING) {
							
						
						data.add(cv.next().getStringCellValue());
						expb=((String) data.get(column)).split(",");
						
						//}
						/*else{
							data.add(NumberToTextConverter.toText(cv.next().getNumericCellValue()));
						}
						*/
						//data.get(cv.getColumnIndex()).split(",");
						}
				
					
				}
				
			}

			return expb;
			
		}
		
		@AfterTest
		public void closeBrowser(){
			driver.close();
		}
}
