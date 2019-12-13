import pers.ZJ.StepWebDriver.StepWebDriver;
import pers.ZJ.StepWebDriver.util.RegularUtil;
import pers.ZJ.StepWebDriver.util.StepUtil;

import java.io.File;

public class Test {

    @org.junit.Test
    public void testCheck(){
        System.out.println(StepWebDriver.check("$(\"44534[id=232][class=2=324.click()]\")[3].click(5)"));
    }

    @org.junit.Test
    public void testExecute(){
        StepWebDriver stepWebDriver = new StepWebDriver(new File("E:\\ZJ\\chromedriver\\78\\chromedriver.exe"));
        stepWebDriver.execute("url(\"http://192.168.125.67:8080/kesida_sys/home/netHomeDataInit\")");
        stepWebDriver.execute("$(\"input[id=userAccount]\").sendKey(\"zhoujun01\")");
        stepWebDriver.execute("$(\"input[id=userPassword]\").sendKey(\"zhoujun01\")");
//        stepWebDriver.close();
    }

}