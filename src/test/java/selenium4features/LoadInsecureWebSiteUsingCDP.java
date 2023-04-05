package selenium4features;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.security.Security;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoadInsecureWebSiteUsingCDP {

	@Test
	public void loadInsecureWebSite() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		
		devtools.send(Security.enable());
		devtools.send(Security.setIgnoreCertificateErrors(true));

		driver.get("https://www.expired.badssl.com");
		Thread.sleep(5000);

		driver.quit();
	}

}
