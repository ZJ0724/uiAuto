import com.zj0724.StepWebDriver.entity.StepWebDriver;

import java.io.File;

public class Test {

    public static void main(String[] args) {


        StepWebDriver stepWebDriver = new StepWebDriver("E:/ZJ/MyProject/StepWebDriver/src/test/java/test.html", true);

        stepWebDriver.url("file:///E:/ZJ/MyProject/StepWebDriver/src/test/java/test.html");


        System.out.println(stepWebDriver.findElementByCssSelector("*[id='a']").prev());

    }

}