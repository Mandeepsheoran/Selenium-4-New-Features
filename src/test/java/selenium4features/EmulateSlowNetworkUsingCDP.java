package selenium4features;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.model.ConnectionType;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.devtools.v107.network.Network;

public class EmulateSlowNetworkUsingCDP {
	
	public void setUpDevTool() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();	
		
		DevTools devtools=driver.getDevTools();
		devtools.createSession();
		
		Integer aa = 100;
		Number nn = (Number) aa;
		boolean value = false;
		Boolean bb = (Boolean) value;
		
		devtools.send(Network.emulateNetworkConditions(
                bb,
                nn,
                nn,
                nn,
                Optional.of(ConnectionType.CELLULAR2G)
        ));
		driver.get("http://www.google.com");	
		driver.quit();
	}
}
