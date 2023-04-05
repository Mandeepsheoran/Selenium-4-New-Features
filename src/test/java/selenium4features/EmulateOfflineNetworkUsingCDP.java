package selenium4features;

import java.util.Optional;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.*;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EmulateOfflineNetworkUsingCDP {
	@Test
	public void offlineNetworkMode() { 
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();	
		
		DevTools devtools=driver.getDevTools();
		devtools.createSession();
		
		Integer aa = 100;
		Number nn = (Number) aa;
		boolean value = true;
		Boolean bb = (Boolean) value;
		
		devtools.send(Network.emulateNetworkConditions( 
				bb,
                nn,
                nn,
                nn,
                Optional.of(ConnectionType.WIFI)));
		try {
		driver.get("http://www.google.com");	
		} catch(Exception e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
