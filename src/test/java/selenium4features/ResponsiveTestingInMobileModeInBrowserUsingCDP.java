package selenium4features;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ResponsiveTestingInMobileModeInBrowserUsingCDP {
	@Test
	public void responsiveMode() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		
		//Configuration for iPhone 11 Pro dimensions
		Map<String,Object> map = new HashMap<>();
		map.put("width", 390);
		map.put("height",844);
		map.put("deviceScaleFactor", 100);
		map.put("mobile", true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", map);
		
		driver.get("https://the-internet.herokuapp.com");	
		Thread.sleep(9000);
		driver.quit();
	}
}
