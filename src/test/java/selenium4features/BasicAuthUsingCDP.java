package selenium4features;

import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.testng.annotations.Test;

public class BasicAuthUsingCDP extends BaseTest {
	
	@Test
	public void basicAuthCDPTest() throws InterruptedException {
		Predicate<URI> uriPredicate = uri -> uri.getHost().contains("https://the-internet.herokuapp.com/");

		((HasAuthentication) driver).register(uriPredicate, UsernameAndPassword.of("admin", "admin"));
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		Thread.sleep(5000);
	}
}
