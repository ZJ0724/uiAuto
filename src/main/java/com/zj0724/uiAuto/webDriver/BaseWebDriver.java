package com.zj0724.uiAuto.webDriver;

import com.zj0724.uiAuto.WebDriver;
import com.zj0724.uiAuto.exception.ErrorException;
import com.zj0724.uiAuto.exception.GrammarException;
import com.zj0724.uiAuto.exception.WebElementException;
import org.openqa.selenium.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BaseWebDriver implements WebDriver {

    private org.openqa.selenium.WebDriver webDriver;

    /**
     * 构造函数
     * */
    protected BaseWebDriver() {}

    /**
     * 加载驱动
     * */
    protected abstract void loadWebDriver(File webDriverFile, boolean headless);
    protected abstract void loadWebDriver(boolean headless);

    /**
     * 设置驱动
     * */
    protected void setWebDriver(org.openqa.selenium.WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * 生成驱动文件
     * */
    protected void createWebDriverFile(com.zj0724.uiAuto.constant.WebDriver webDriver) {
        File webDriverFile = webDriver.getWebDriverFile();
        if (!webDriverFile.exists()) {
            File parentPath = webDriverFile.getParentFile();
            if (!parentPath.exists()) {
                parentPath.mkdirs();
            }
            try {
                InputStream inputStream = BaseWebDriver.class.getResourceAsStream(webDriver.getWebDriverResource());
                OutputStream outputStream = new FileOutputStream(webDriverFile);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                byte[] bytes = new byte[bufferedInputStream.available()];
                bufferedInputStream.read(bytes);
                bufferedOutputStream.write(bytes);
                outputStream.close();
                inputStream.close();
                bufferedInputStream.close();
                bufferedOutputStream.close();
            } catch (IOException e) {
                throw ErrorException.bug("创建驱动文件出错" + e.getMessage());
            }
        }
    }

    public com.zj0724.uiAuto.WebElement findElementByCssSelector(String cssSelector) {
        try {
            return new com.zj0724.uiAuto.WebElement(webDriver.findElement(By.cssSelector(cssSelector)));
        } catch (InvalidSelectorException e) {
            throw GrammarException.cssGrammarException();
        } catch (NoSuchElementException e) {
            throw WebElementException.elementNotFind();
        }
    }

    public List<com.zj0724.uiAuto.WebElement> findElementsByCssSelector(String cssSelector) {
        try {
            List<com.zj0724.uiAuto.WebElement> result = new ArrayList<>();
            List<org.openqa.selenium.WebElement> elements = webDriver.findElements(By.cssSelector(cssSelector));
            for (org.openqa.selenium.WebElement element : elements) {
                result.add(new com.zj0724.uiAuto.WebElement(element));
            }
            return result;
        } catch (InvalidSelectorException e) {
            throw GrammarException.cssGrammarException();
        } catch (NoSuchElementException e) {
            throw WebElementException.elementNotFind();
        }
    }

    public com.zj0724.uiAuto.WebElement findElementByXpath(String xpath) {
        try {
            return new com.zj0724.uiAuto.WebElement(webDriver.findElement(By.xpath(xpath)));
        } catch (InvalidSelectorException e) {
            throw GrammarException.xpathGrammarException();
        } catch (NoSuchElementException e) {
            throw WebElementException.elementNotFind();
        }
    }

    public List<com.zj0724.uiAuto.WebElement> findElementsByXpath(String xpath) {
        try {
            List<com.zj0724.uiAuto.WebElement> result = new ArrayList<>();
            List<org.openqa.selenium.WebElement> elements = webDriver.findElements(By.xpath(xpath));
            for (org.openqa.selenium.WebElement element : elements) {
                result.add(new com.zj0724.uiAuto.WebElement(element));
            }
            return result;
        } catch (InvalidSelectorException e) {
            throw GrammarException.xpathGrammarException();
        } catch (NoSuchElementException e) {
            throw WebElementException.elementNotFind();
        }
    }

    public void await(int Millisecond) {
        try {
            Thread.sleep(Millisecond);
        } catch (InterruptedException e) {
            throw ErrorException.bug(e.getMessage());
        }
    }

    public void url(String url) {
        try {
            this.webDriver.get(url);
        } catch (InvalidArgumentException e) {
            throw GrammarException.urlError();
        }
    }

    public void close() {
        if (this.webDriver != null) {
            this.webDriver.quit();
            this.webDriver = null;
        }
    }

}
