import com.zj0724.uiauto.webDriver.ChromeWebDriver;
import com.zj0724.uiauto.webDriver.FirefoxWebDriver;
import org.junit.Test;

public class Main {

    /**
     * 谷歌驱动测试
     * */
    @Test
    public void chromeDriverTest() {
        // 驱动文件路径
        String webDriverPath = "E:\\ZJ\\chromeDriver\\83\\chromedriver.exe";

        WebDriver webDriver = new ChromeWebDriver(webDriverPath);
        webDriver.close();
        System.out.println("ok");
    }

    /**
     * 火狐驱动测试
     * */
    @Test
    public void firefoxDriverTest() {
        // 驱动文件路径
        String webDriverPath = "E:\\ZJ\\fireboxDriver\\geckodriver.exe";

        WebDriver webDriver = new FirefoxWebDriver(webDriverPath);
        webDriver.close();
        System.out.println("ok");
    }

}