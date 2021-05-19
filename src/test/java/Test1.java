import com.zj0724.uiAuto.Selector;
import com.zj0724.uiAuto.WebDriver;
import com.zj0724.uiAuto.WebElement;
import com.zj0724.uiAuto.webDriver.ChromeWebDriver;

public class Test1 {

    public static void main(String[] args) {
        WebDriver webDriver = new ChromeWebDriver("D:\\application\\ep-util\\chromedriver\\chromedriver.exe",true);
        try {
            webDriver.open("http://192.168.120.40/uumm/#/login");
            webDriver.findElement(Selector.byCssSelector("#app > div.home > section.home-banner > div > div.login-block > div > form > div:nth-child(1) > div > div > input")).sendKey("rnlin");
            webDriver.findElement(Selector.byCssSelector("#app > div.home > section.home-banner > div > div.login-block > div > form > div:nth-child(2) > div > div > input")).sendKey("888888a");
            webDriver.findElement(Selector.byCssSelector("#app > div.home > section.home-banner > div > div.login-block > div > form > div:nth-child(3) > div > div > div:nth-child(1) > div > input")).sendKey("1");
            webDriver.findElement(Selector.byCssSelector("#app > div.home > section.home-banner > div > div.login-block > div > div:nth-child(3) > button")).click();
            webDriver.await(5000);
            webDriver.open("http://192.168.120.40/uumm/#/chunk/ossUser/EC9925E930DE4E6EBD17F6F8951FCB56?id=EC9925E930DE4E6EBD17F6F8951FCB56");
            webDriver.findElement(Selector.byCssSelector("#app > div:nth-child(1) > div.panel-main > div.panel-main-content > div > div > div:nth-child(3) > div > div.uumm-base-cv-main > div > div > div.ep-tabs-contents > div > div > div > div.ep-row > div > button.ep-button.ep-button--primary.ep-button--small")).click();
            webDriver.findElement(Selector.byCssSelector("#app > div:nth-child(1) > div.panel-main > div.panel-main-content > div > div > div:nth-child(3) > div > div.uumm-base-cv-main > div > div > div.ep-tabs-contents > div > div > div > div.ep-model-wrapper.ep-modal-wrapper > div > div.ep-model-body.ep-modal-body > div.panel-main-content > div > div > div.uumm-base-cv-main > div:nth-child(5) > div > div.jsoneditor-vue > div > div.jsoneditor-menu > div > button")).click();
            webDriver.findElement(Selector.byCssSelector("#app > div:nth-child(1) > div.panel-main > div.panel-main-content > div > div > div:nth-child(3) > div > div.uumm-base-cv-main > div > div > div.ep-tabs-contents > div > div > div > div.ep-model-wrapper.ep-modal-wrapper > div > div.ep-model-body.ep-modal-body > div.panel-main-content > div > div > div.uumm-base-cv-main > div:nth-child(5) > div > div.jsoneditor-vue > div > div.jsoneditor-menu > div > div > div > ul > li:nth-child(5) > button")).click();
//            final WebElement element = webDriver.findElement(Selector.byCssSelector("#app > div:nth-child(1) > div.panel-main > div.panel-main-content > div > div > div:nth-child(3) > div > div.uumm-base-cv-main > div > div > div.ep-tabs-contents > div > div > div > div.ep-model-wrapper.ep-modal-wrapper > div > div.ep-model-body.ep-modal-body > div.panel-main-content > div > div > div.uumm-base-cv-main > div:nth-child(5) > div > div.jsoneditor-vue > div > div.jsoneditor-outer > div > div.ace_scroller > div"));
//            element.test();
            WebElement element = webDriver.findElement(Selector.byCssSelector("#app > div:nth-child(1) > div.panel-main > div.panel-main-content > div > div > div:nth-child(3) > div > div.uumm-base-cv-main > div > div > div.ep-tabs-contents > div > div > div > div.ep-model-wrapper.ep-modal-wrapper > div > div.ep-model-body.ep-modal-body > div.panel-main-content > div > div > div.uumm-base-cv-main > div:nth-child(5) > div > div.jsoneditor-vue > div > div.jsoneditor-outer > textarea"));
            element.clear();
            element.sendKey("{\"test\":\"123\"}");
//            webDriver.findElement(Selector.byCssSelector("#app > div:nth-child(1) > div.panel-main > div.panel-main-content > div > div > div:nth-child(3) > div > div.uumm-base-cv-main > div > div > div.ep-tabs-contents > div > div > div > div.ep-model-wrapper.ep-modal-wrapper > div > div.ep-model-body.ep-modal-body > div.panel-main-content > div > div > div.uumm-base-cv-main > div:nth-child(5) > div > div.jsoneditor-vue > div > div.jsoneditor-outer > textarea")).sendKey();
        } finally {
            webDriver.close();
        }
    }

}