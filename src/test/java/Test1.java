import com.zj0724.uiAuto.DriverType;
import com.zj0724.uiAuto.WebDriver;
import com.zj0724.uiAuto.webDriver.RemoteWebDriver;

public class Test1 {

    public static void main(String[] args) {
        WebDriver webDriver = new RemoteWebDriver("http://192.168.74.100:4444/wd/hub", DriverType.CHROME);
        webDriver.open("https://www.baidu.com/");
        webDriver.close();

        WebDriver webDriver1 = new RemoteWebDriver("http://192.168.74.100:4444/wd/hub", DriverType.CHROME);
        webDriver1.open("https://www.baidu.com/");
        webDriver1.close();
    }

}