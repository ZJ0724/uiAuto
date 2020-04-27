



# uiAuto

ui自动化框架，基于selenium封装。



## 说明

目前支持谷歌浏览器、火狐浏览器，windows版、linux版。



## API

### interface WebDriver

驱动接口。

> **package：**
>
> com.zj0724.uiAuto

> **实现类：**
>
> `ChromeWebDriver`、`FirefoxWebDriver`

> **构造方法：**
>
> `FirefoxWebDriver` 构造方法与 `ChromeWebDriver` 一致
>
> ```java
> /**
> * 实例化一个谷歌驱动，使用内置的驱动文件
> */ 
> ChromeWebDriver()   
> ```
>
> ```java
> /**
> * 实例化一个谷歌驱动，使用内置的驱动文件
> *
> * @param headless true：不显示浏览器；false：显示浏览器
> */ 
> ChromeWebDriver(boolean headless)
> ```
>
> ```java
> /**
> * 实例化一个谷歌驱动，使用指定的驱动文件
> *
> * @param webDriverFilePath 驱动文件绝对路径
> * @param headless true：不显示浏览器；false：显示浏览器
> */ 
> ChromeWebDriver(String webDriverFilePath, boolean headless)
> ```
>
> ```java
> /**
> * 实例化一个谷歌驱动，使用指定的驱动文件
> *
> * @param webDriverFile 驱动文件
> * @param headless true：不显示浏览器；false：显示浏览器
> */ 
> ChromeWebDriver(File webDriverFile, boolean headless)
> ```
>
> ```java
> /**
> * 实例化一个谷歌驱动，使用指定的驱动文件，默认不显示浏览器
> *
> * @param webDriverFile 驱动文件绝对路径
> */ 
> ChromeWebDriver(String webDriverFilePath)
> ```
>
> ```java
> /**
> * 实例化一个谷歌驱动，使用指定的驱动文件，默认不显示浏览器
> *
> * @param webDriverFile 驱动文件
> */ 
> ChromeWebDriver(File webDriverFile)
> ```

> **方法：**
>
> ```java
> /**
> * 通过cssSelector查找元素
> *
> * @param cssSelector css选择器
> *
> * @return WebElement 一个元素
> * */
> WebElement findElementByCssSelector(String cssSelector);
> ```
>
> ```java
> /**
>  * 通过cssSelector查找元素
>  *
>  * @param cssSelector css选择器
>  * 
>  * @return List<WebElement> 返回一个元素集合
>  * */
> List<WebElement> findElementsByCssSelector(String cssSelector);
> ```
>
> ```java
> /**
>  * 通过xpath查找元素
>  *
>  * @param xpath xpath语法
>  * 
>  * @return WebElement 返回一个元素
>  * */
> WebElement findElementByXpath(String xpath);
> ```
>
> ```java
> /**
>  * 通过xpath查找元素
>  * 
>  * @param xpath xpath语法
>  *
>  * @return List<WebElement> 返回一个元素集合
>  * */
> List<WebElement> findElementsByXpath(String xpath);
> ```
>
> ```java
> /**
>  * 线程等待
>  *
>  * @param Millisecond 要等待的毫秒数
>  * */
> void await(int Millisecond);
> ```
>
> ```java
> /**
>  * 打开网址
>  *
>  * @param url 要打开的网址
>  * */
> void url(String url);
> ```
>
> ```java
> /**
>  * 关闭驱动
>  * */
> void close();
> ```



### class WebElement

一个元素对象。

> **package：**
>
> com.zj0724.uiAuto

> **方法：**
>
> ```java
> /**
>  * 点击元素
>  * */
> public void click();
> ```
>
> ```java
> /**
>  * 输入框输入参数
>  * 
>  * @param value 要输入的参数
>  * */
> public void sendKey(String value);
> ```
>
> ```java
> /**
>  * 获取父级元素
>  * 
>  * @return 返回父级元素，如果不存在父级元素，抛出元素未找到异常
>  * */
> public WebElement parent();
> ```
>
> ```java
> /**
>  * 获取元素属性值
>  * 
>  * @param name 元素属性名
>  * */
> public String getAttribute(String name);
> ```
>
> ```java
> /**
>  * 获取子元素
>  * 
>  * @param index 元素索引，从1开始
>  *              
>  * @return 返回子元素，如果不存在，抛出元素未找到异常
>  * */
> public WebElement children(int index);
> ```
>
> ```java
> /**
>  * 获取下一个元素
>  * 
>  * @return  返回同级下一个元素，如果不存在，抛出元素未找到异常
>  * */
> public WebElement next();
> ```
>
> ```java
> /**
>  * 获取上一个元素
>  * 
>  * @return 返回同级上一个元素，如果不存在，抛出元素未找到异常
>  * */
> public WebElement prev();
> ```

