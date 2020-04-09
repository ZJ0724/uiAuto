import com.zj0724.StepWebDriver.entity.StepWebDriver;

import java.io.File;

public class Test {

    public static void main(String[] args) {


        StepWebDriver stepWebDriver = new StepWebDriver("E:\\ZJ\\chromeDriver\\80\\chromedriver.exe", true);

        stepWebDriver.url("http://192.168.125.67:8080/kesida_sys/home/netHomeDataInit");



        stepWebDriver.findByCssSelector("a[onclick=\"login()\"]").click();
    }

}