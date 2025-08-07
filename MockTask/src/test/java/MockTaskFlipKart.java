import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
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
		for (WebElement name : names) {
			String fname = name.getText();

		}

		for (WebElement price : prices) {
			System.out.println(price.getText());
		}

		// FileInputStream fis= new
		// FileInputStream("./src/test/resources/flights.xlsx");
		// wb = WorkbookFactory.create(fis);
		// FileOutputStream fos= new
		// FileOutputStream("./src/test/resources/flights.xlsx");
		// Sheet sheet = wb.getSheet("Sheet1");
		// int rowcount=1;
		// for(WebElement name:names)
		// {
		//
		// Row row = sheet.getRow(rowcount);
		// Cell cell = row.createCell(0);
		// cell.setCellType(CellType.STRING);
		// cell.setCellValue(name.getText());
		// wb.write(fos);
		// wb.close();
		// rowcount++;
		//
		//
		// }
		//
		// for(WebElement price:prices) {
		// System.out.println(price.getText());
		//
		// }

	}

}
