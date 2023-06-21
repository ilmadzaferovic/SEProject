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

class Test2 {
	
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
		webDriver.findElement(By.xpath("/html/body/nav/div/div/div/a[1]")).click();
		Thread.sleep(2000);
		WebElement title= webDriver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[2]/div[2]/input"));
		title.sendKeys("Anna Karenina");
		WebElement author= webDriver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[2]/div[3]/input"));
		author.sendKeys("Leo Tolstoy");
		WebElement genre= webDriver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[2]/div[4]/input"));
		genre.sendKeys("Drama");
		WebElement date= webDriver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[2]/div[5]/input"));
		date.sendKeys("01/01/2001");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[3]/button[2]")).click();
		Thread.sleep(2000);
		
		
		webDriver.close();
	}

}
