import com.zj0724.uiAuto.WebDriver;
import com.zj0724.uiAuto.webDriver.ChromeWebDriver;
import com.zj0724.uiAuto.webDriver.FirefoxWebDriver;

public class Main {

    public static void main(String[] args) throws Exception {

        WebDriver webDriver = new ChromeWebDriver();

        webDriver.close();

    }

}