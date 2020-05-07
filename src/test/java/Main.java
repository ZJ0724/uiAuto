import com.zj0724.uiAuto.WebDriver;
import com.zj0724.uiAuto.WebElement;
import com.zj0724.uiAuto.webDriver.ChromeWebDriver;
import com.zj0724.uiAuto.webDriver.FirefoxWebDriver;

public class Main {

    public static void main(String[] args) throws Exception {

        WebDriver webDriver = new ChromeWebDriver();

        webDriver.url("http://localhost:63342/uiAuto/test.html?_ijt=h27d7asgkflmmas0g148od9gpl");

        WebElement webElement = webDriver.findElementByCssSelector("#a > div");


        System.out.println(webElement.getText());
        System.out.println(webElement.getAttribute("innerText"));
        System.out.println(webElement.getAttribute("innerHTML"));


        webDriver.close();

    }

}