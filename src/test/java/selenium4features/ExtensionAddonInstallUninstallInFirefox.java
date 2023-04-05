package selenium4features;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtensionAddonInstallUninstallInFirefox {

	public void extenionInstallUninstall() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		Thread.sleep(5000);

		Path path = Paths.get("C://User//Mandeep//path_like_selenium-ide-firefox.xpi");
		String extensionid = driver.installExtension(path);
		driver.uninstallExtension(extensionid);

		driver.quit();
	}

}
