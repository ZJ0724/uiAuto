import com.zj0724.StepWebDriver.entity.StepWebDriver;

import java.io.File;

public class Test {

    public static void main(String[] args) {


//        StepWebDriver stepWebDriver = new StepWebDriver("E:/ZJ/MyProject/StepWebDriver/src/test/java/test.html", true);
        StepWebDriver stepWebDriver1 = new StepWebDriver(new File("E:\\ZJ\\chromeDriver\\81\\chromedriver.exe"));
//        stepWebDriver.url("file:///E:/ZJ/MyProject/StepWebDriver/src/test/java/test.html");


//        System.out.println(stepWebDriver.findElementByCssSelector("*[id='a']").prev());

    }

}