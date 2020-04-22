import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebElement;

public class Test {

    public static void main(String[] args) {


        System.setProperty("webdriver.gecko.driver", "E:\\ZJ\\fireboxDriver\\geckodriver.exe");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
//        firefoxOptions.addArguments("--headless");

        WebDriver webDriver = new FirefoxDriver(firefoxOptions);

        webDriver.get("https://www.baidu.com/");

//        webDriver.quit();
    }

}