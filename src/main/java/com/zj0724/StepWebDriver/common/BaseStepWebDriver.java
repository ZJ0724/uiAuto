package com.zj0724.StepWebDriver.common;

import com.zj0724.StepWebDriver.StepWebDriver;
import com.zj0724.StepWebDriver.entity.WebElement;
import com.zj0724.StepWebDriver.exception.ErrorException;
import com.zj0724.StepWebDriver.exception.GrammarException;
import com.zj0724.StepWebDriver.exception.WebElementException;
import org.openqa.selenium.*;
import java.util.ArrayList;
import java.util.List;

public class BaseStepWebDriver implements StepWebDriver {

    private final WebDriver webDriver;

    public BaseStepWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement findElementByCssSelector(String cssSelector) {
        try {
            return new WebElement(webDriver.findElement(By.cssSelector(cssSelector)));
        } catch (InvalidSelectorException e) {
            throw GrammarException.cssGrammarException();
        } catch (NoSuchElementException e) {
            throw WebElementException.elementNotFind();
        }
    }

    public List<WebElement> findElementsByCssSelector(String cssSelector) {
        try {
            List<WebElement> result = new ArrayList<>();
            List<org.openqa.selenium.WebElement> elements = webDriver.findElements(By.cssSelector(cssSelector));
            for (org.openqa.selenium.WebElement element : elements) {
                result.add(new WebElement(element));
            }
            return result;
        } catch (InvalidSelectorException e) {
            throw GrammarException.cssGrammarException();
        } catch (NoSuchElementException e) {
            throw WebElementException.elementNotFind();
        }
    }

    public WebElement findElementByXpath(String xpath) {
        try {
            return new WebElement(webDriver.findElement(By.xpath(xpath)));
        } catch (InvalidSelectorException e) {
            throw GrammarException.xpathGrammarException();
        } catch (NoSuchElementException e) {
            throw WebElementException.elementNotFind();
        }
    }

    public List<WebElement> findElementsByXpath(String xpath) {
        try {
            List<WebElement> result = new ArrayList<>();
            List<org.openqa.selenium.WebElement> elements = webDriver.findElements(By.xpath(xpath));
            for (org.openqa.selenium.WebElement element : elements) {
                result.add(new WebElement(element));
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
            this.webDriver.close();
            this.webDriver.quit();
        }
    }

}
