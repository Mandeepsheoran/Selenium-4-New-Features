package selenium4features;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZoomInZoomOutSelenium4 {
	
	public void zoomFeature() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='200%';");
		Thread.sleep(3000);
		js.executeScript("document.body.style.zoom='50%';");
		Thread.sleep(3000);
		js.executeScript("document.body.style.zoom='250%';");
		Thread.sleep(3000);
	}

}
