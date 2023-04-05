package selenium4features;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.network.Network;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InterceptNetworkTrafficLogsUsingCDP {
    @Test
	public void networkTrafficLogs() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		devtools.addListener(Network.requestWillBeSent(), 
				request -> {
		          	System.out.println(request.getRequest().getUrl());
			        System.out.println(request.getRequest().getMethod());
		});
		
		driver.get("https://the-internet.herokuapp.com/broken_images");
		driver.quit();
	}
}
