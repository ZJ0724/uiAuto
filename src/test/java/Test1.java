import com.zj0724.uiAuto.DriverType;
import com.zj0724.uiAuto.WebDriver;
import com.zj0724.uiAuto.webDriver.RemoteWebDriver;

public class Test1 {

    public static void main(String[] args) {
        WebDriver webDriver = new RemoteWebDriver("http://localhost/selenium-server", DriverType.CHROME);
        webDriver.open("https://www.baidu.com/");
        webDriver.close();
    }

}