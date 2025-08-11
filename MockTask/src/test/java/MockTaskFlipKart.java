import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MockTaskFlipKart {
	WebElement names;
	Workbook wb;

	@Test
	public void flightBooking()
			throws InterruptedException, EncryptedDocumentException, IOException

	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//a[.='Flight Bookings']")).click();
		driver.findElement(By.xpath("//input[@name='0-departcity']")).click();
		driver.findElement(By.xpath("//input[@name='0-departcity']"))
				.sendKeys("Bengaluru");
		driver.findElement(By.xpath("//span[.='Bengaluru']")).click();
		driver.findElement(By.xpath("//input[@name='0-arrivalcity']")).click();
		driver.findElement(By.xpath("//input[@name='0-arrivalcity']"))
				.sendKeys("Mumbai");
		driver.findElement(By.xpath("(//span[.='Mumbai'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='0-datefrom']")).click();
		driver.findElement(By.xpath("(//button[.='13'])[1]")).click();
		driver.findElement(By.xpath("//span[.='SEARCH']")).click();
		List<WebElement> names = driver.findElements(By.xpath(
				"//div[@class='eivht0']/descendant::div[@class='jvoo4s']"));
		List<WebElement> prices = driver.findElements(By.xpath(
				"//div[@class='eivht0']/descendant::div[@class='O+irE2']"));
		int rowcoutn = 1;
		// for (WebElement name : names) {
		// String fname = name.getText();
		//
		// }
		//
		// for (WebElement price : prices) {
		// System.out.println(price.getText());
		// }

		FileInputStream fis = new FileInputStream(
				"./src/test/resources/flights.xlsx");
		wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		
		for (WebElement name : names) {

			Row row = sheet.getRow(rowcoutn);
			Cell cell = row.createCell(0);
			cell.setCellType(CellType.STRING);
			cell.setCellValue(name.getText());
			rowcoutn++;

		}

		FileOutputStream fos = new FileOutputStream(
				"./src/test/resources/flights.xlsx");
		wb.write(fos);
		wb.close();
	}

}
