package selenium4features;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PrintOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintPageToPDF {
	@Test
	public void printPDF() throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--headless");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com");
		
		Pdf pdf=driver.print(new PrintOptions());
		Files.write(Paths.get("./PDFPrint.pdf"), OutputType.BYTES.convertFromBase64Png(pdf.getContent()));
		driver.quit();
	}

}
