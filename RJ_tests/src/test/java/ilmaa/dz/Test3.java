package ilmaa.dz;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class Test3 {
	
	private static WebDriver webDriver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dzafe\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		webDriver= new ChromeDriver();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws InterruptedException {
		webDriver.get("https://ilma-readingjournal.onrender.com/");
		webDriver.manage().window().maximize();
		Thread.sleep(2000);
		
		
		webDriver.findElement(By.xpath("/html/body/nav/div/div/button")).click();
		webDriver.findElement(By.xpath("/html/body/nav/div/div/div/a[2]")).click();
		Thread.sleep(2000);
		WebElement desc= webDriver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div[1]/form/div/input"));
		desc.sendKeys("100 books in a year");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div[1]/form/div/button")).click();
		Thread.sleep(2000);
		
		webDriver.close();
	}

}