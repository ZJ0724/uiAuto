import com.zj0724.StepWebDriver.entity.StepWebDriver;

import java.io.File;

public class Test {

    public static void main(String[] args) {


        StepWebDriver stepWebDriver = new StepWebDriver(new File("E:\\ZJ\\chromeDriver\\81\\chromedriver.exe"));

        stepWebDriver.findElementByCssSelector("");

    }

}