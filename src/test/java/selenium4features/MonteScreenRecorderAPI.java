package selenium4features;

import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MonteScreenRecorderAPI {
	@Test
	public void monteAPI(Method m) throws Exception {
		ScreenRecorderUtil.startRecord(m.getName());
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='content']/div/button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='elements']/button")).click();
		Thread.sleep(5000);
		ScreenRecorderUtil.stopRecord();
		driver.quit();
	}
}
