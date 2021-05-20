import com.zj0724.uiAuto.Selector;
import com.zj0724.uiAuto.WebDriver;
import com.zj0724.uiAuto.webDriver.ChromeWebDriver;

public class Test1 {

    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeWebDriver("C:\\Users\\ZJ\\Desktop\\file\\chromedriver_win32\\chromedriver.exe", true);

        try {
            chromeDriver.open("http://192.168.120.40/uumm/#/login");
            chromeDriver.findElement(Selector.byCssSelector("#app > div.home > section.home-banner > div > div.login-block > div > form > div:nth-child(1) > div > div > input")).sendKey("rnlin");
            chromeDriver.findElement(Selector.byCssSelector("#app > div.home > section.home-banner > div > div.login-block > div > form > div:nth-child(2) > div > div > input")).sendKey("888888a");
            chromeDriver.findElement(Selector.byCssSelector("#app > div.home > section.home-banner > div > div.login-block > div > form > div:nth-child(3) > div > div > div:nth-child(1) > div > input")).sendKey("a");
            chromeDriver.findElement(Selector.byCssSelector("#app > div.home > section.home-banner > div > div.login-block > div > div:nth-child(3) > button")).click();
            chromeDriver.display(Selector.byCssSelector("#app > div:nth-child(1) > div.panel-main > div.panel-main-content > div.ep-row > div.resetw-col7.ep-col.ep-col-7 > div > div.title"));
            chromeDriver.open("http://192.168.120.40/uumm/#/chunk/ossUser/%E6%96%B0%E5%A2%9E%E7%BD%91%E7%AB%99%E7%94%A8%E6%88%B7?id=%E6%96%B0%E5%A2%9E%E7%BD%91%E7%AB%99%E7%94%A8%E6%88%B7");
            chromeDriver.findElement(Selector.byCssSelector("#app > div:nth-child(1) > div.panel-main > div.panel-main-content > div > div > div.uumm-base-cv-main > div > div:nth-child(4) > form > div:nth-child(1) > div:nth-child(1) > div > div > div > div.ep-input.ep-input--mini > input")).sendKey("test");
            chromeDriver.findElement(Selector.byCssSelector("#app > div:nth-child(1) > div.panel-main > div.panel-main-content > div > div > div.uumm-base-cv-main > div > div:nth-child(4) > form > div:nth-child(1) > div:nth-child(1) > div > div > div > div.ep-input.ep-input--mini > input")).event("input");
        } finally {
            chromeDriver.close();
        }
    }

}