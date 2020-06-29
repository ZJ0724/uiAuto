import com.zj0724.uiAuto.WebDriver;
import com.zj0724.uiAuto.webDriver.ChromeWebDriver;

public class Main {

    public static void main(String[] args) {

        WebDriver webDriver = new ChromeWebDriver("E:\\ZJ\\chromeDriver\\83\\chromedriver.exe", false);

        webDriver.url("http://192.168.120.40/swgdfront/#/login");

        webDriver.findElementByXpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/form/div[1]/div/input").sendKey("cus_zhoujun01");

    }

}