import com.zj0724.uiAuto.DriverType;
import com.zj0724.uiAuto.Selector;
import com.zj0724.uiAuto.WebDriver;
import com.zj0724.uiAuto.webDriver.ChromeWebDriver;
import com.zj0724.uiAuto.webDriver.RemoteWebDriver;

public class Test1 {

    public static void main(String[] args) {

        WebDriver webDriver = new ChromeWebDriver("E:\\ZJ\\chromedriver\\chromedriver.exe", true);
        try {
            webDriver.open("file:///C:/Users/ZJ/Desktop/file/index.html");
            webDriver.findElement(Selector.byCssSelector("body > div > button")).click();
        } finally {
            webDriver.close();
        }
    }

}