import com.zj0724.uiAuto.WebDriver;
import com.zj0724.uiAuto.webDriver.ChromeWebDriver;
import com.zj0724.uiAuto.webDriver.FirefoxWebDriver;

public class Main {

    public static void main(String[] args) throws Exception {


        WebDriver webDriver = new FirefoxWebDriver();


        webDriver.url("http://www.baidu.com");

        webDriver.close();

        webDriver = new ChromeWebDriver();

        webDriver.url("http://www.baidu.com");

        webDriver.close();

    }

}