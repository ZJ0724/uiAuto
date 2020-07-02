import com.zj0724.uiAuto.WebDriver;
import com.zj0724.uiAuto.WebElement;
import com.zj0724.uiAuto.webDriver.ChromeWebDriver;

public class Main {

    public static void main(String[] args) {

        WebDriver webDriver = new ChromeWebDriver("E:\\ZJ\\chromeDriver\\83\\chromedriver.exe", false);

        webDriver.url("http://192.168.125.67:8080/kesida_sys/home/netHomeDataInit");

        WebElement webElement = webDriver.findElementByText("确定");

        System.out.println(webElement);

    }

}