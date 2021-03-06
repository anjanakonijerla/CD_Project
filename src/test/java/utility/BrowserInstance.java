package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserInstance {


	private static String browserDriverPath = null;
	public static WebDriver driver = null;


	public static WebDriver getBrowser(String browserType, int browserVersion, String browserOS) {

		if (null != browserType) {
			if ("Chrome".equalsIgnoreCase(browserType)) {
				if (null == driver) {
					

					// browserDriverPath = "./src/main/BrowserDrivers/" + browserType + "/version/"
					// + browserVersion + "/"
					// + browserOS + "/chromedriver";
//					if ("windows".equalsIgnoreCase(browserType)) {
//						browserDriverPath = browserDriverPath + ".exe";
//					}
					browserDriverPath = "./BrowserDrivers/chromedriver_linux64/chromedriver";
					
					String path = System.getProperty("user.dir");
					System.out.println("========== this is the path:"+path);

					System.setProperty("webdriver.chrome.driver", browserDriverPath);
					driver = new ChromeDriver();
					driver.manage().window().maximize();
				}
				return driver;

			}

		}
	
		return null;

	}

}
