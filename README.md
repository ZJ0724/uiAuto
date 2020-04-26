



# uiAuto

ui自动化框架，基于selenium封装。



## 说明

目前支持谷歌浏览器、火狐浏览器，windows版、linux版。



## API

### interface WebDriver

驱动接口。

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