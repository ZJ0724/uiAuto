import com.zj0724.StepWebDriver.StepWebDriver;

import java.io.File;

public class Test {

    @org.junit.Test
    public void testCheck(){
        System.out.println(StepWebDriver.check("$(\"44534[id=232][class=2=324.click()]\")[3].sendKey(?)"));
    }

    @org.junit.Test
    public void testExecute(){
        StepWebDriver stepWebDriver = new StepWebDriver(new File("E:\\ZJ\\chromedriver\\79\\chromedriver.exe"));
    }

}