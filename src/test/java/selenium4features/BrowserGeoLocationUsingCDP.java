package selenium4features;

import java.util.Optional;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.emulation.Emulation;
import org.testng.annotations.Test;

public class BrowserGeoLocationUsingCDP {
	
	@Test
	public void changeGeoLocation() {
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Emulation.setGeolocationOverride(Optional.of(52.5043),
		                                               Optional.of(13.4501),
		                                               Optional.of(1)));
		driver.get("https://my-location.org/");
		driver.quit();	
	}
}
