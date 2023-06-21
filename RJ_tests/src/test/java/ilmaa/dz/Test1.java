package ilmaa.dz;

import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Test1 {
	
	private static WebDriver webDriver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dzafe\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		webDriver= new ChromeDriver();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
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
		
		
		WebElement text= webDriver.findElement(By.xpath("/html/body/nav/div/a"));
		assertTrue(text.getText().contains("The Reading Journal"));
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/nav/div/div/button")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/nav/div/div/div/a[3]")).click();
		Thread.sleep(2000);
		WebElement text1= webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/h5"));
		assertTrue(text1.getText().contains("It Ends With Us"));
		Thread.sleep(2000);
		webDriver.navigate().back();
        Thread.sleep(2000);
		
		webDriver.close();
	}

}
