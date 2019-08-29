package hooks;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import basePackage.DriverContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.LogHelpers;

public class BeforeAfter {
	Scenario scenario;

	@Before
	public void setUp(Scenario scenario) throws FileNotFoundException, IOException {

		this.scenario = scenario;
		LogHelpers.startLog(
				"-----------------" + scenario.getName() + " --------------------------------------------------------");
		LogHelpers.info("In Hooks setUp Method");

		String user_home_path = System.getProperty("user.home");
		String os = System.getProperty("os.name");

		String Browser =  "Chrome"; //System.getProperty("browser");
		LogHelpers.info("Browser seleced is: " + Browser);

		if (Browser.equals("headlessChrome") && DriverContext.Driver == null) {

			System.setProperty("webdriver.chrome.driver",Paths.get(user_home_path, "drivers", "chromedriver.exe").toString());
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--disable-gpu");
			chromeOptions.addArguments("--window-size=1920,1200");
			chromeOptions.addArguments("--start-maximized");
			chromeOptions.addArguments("--ignore-certificate-errors");
			DriverContext.Driver = new ChromeDriver(chromeOptions);

			Driver_functions();
		} else {

			System.setProperty("webdriver.chrome.driver",
			Paths.get(user_home_path, "drivers", "chromedriver.exe").toString());
			DriverContext.Driver = new ChromeDriver();
			Driver_functions();

		}

	}

	
	private void Driver_functions() {
		DriverContext.Driver.manage().deleteAllCookies();
		DriverContext.Driver.manage().window().maximize();
		DriverContext.Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void cleanUp(Scenario scenario) {
		this.scenario = scenario;
		LogHelpers.info("In Hooks cleanUp Method");

		if (scenario.isFailed()) {
			LogHelpers.info("Capturing screen shot as Scenario Failed:  " + scenario.getName());
			try {
				final byte[] screenshot = ((TakesScreenshot) DriverContext.Driver).getScreenshotAs(OutputType.BYTES);
				String testName = scenario.getName();
				scenario.embed(screenshot, "image/png");
				scenario.write(testName);
			} catch (WebDriverException wde) {
				System.err.println(wde.getMessage());
			} catch (ClassCastException cce) {
				cce.printStackTrace();
			}
		}
		if (DriverContext.Driver == null) {
			return;
		}
		DriverContext.Driver.quit();
		DriverContext.Driver = null;
	}
}
