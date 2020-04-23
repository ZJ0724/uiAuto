import com.zj0724.uiAuto.WebDriver;
import com.zj0724.uiAuto.webDriver.ChromeWebDriver;

public class Test {

    public static void main(String[] args) throws Exception {



        WebDriver webDriver = new ChromeWebDriver(false);

        webDriver.close();

        Thread.sleep(10000);

        WebDriver webDriver1 = new ChromeWebDriver(false);

        webDriver1.close();

    }

}