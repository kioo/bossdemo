package webstart;

import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.utils.BuildHeaders;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StartBossSendQuery {
    public static String AND = "&";
    public static String EQUAL = "=";
    public static int PAGE_NUM = 1;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/wangchi/IdeaProjects/beyonsoft/bossdemo/chromedriver");

//"https://www.zhipin.com/wapi/zpitem/web/boss/search/geeks.json?page=2&keywords=java&tag=&city=101110100&gender=-1&experience=-1,-1&salary=-1,-1&age=-1,-1&schoolLevel=-1&applyStatus=-1&degree=201,201&switchFreq=0&geekJobRequirements=0&exchangeResume=0&viewResume=0&firstDegree=0&queryAnd=0&companyNamesForHunter=&companySearchTypeForHunter=0&source=1&cityCodeStr=&_=1642991019710"
        String loginUrl = "https://login.zhipin.com/";
        String requestUrl = "https://www.zhipin.com/wapi/zpitem/web/boss/search/geeks.json?";
        String queryParams = "keywords=java&tag=&city=101110100&gender=-1&experience=-1,-1&salary=-1,-1&age=-1,-1&schoolLevel=-1&applyStatus=-1&degree=201,201&switchFreq=0&geekJobRequirements=0&exchangeResume=0&viewResume=0&firstDegree=0&queryAnd=0&companyNamesForHunter=&companySearchTypeForHunter=0&source=1&cityCodeStr=";
        WebDriver driver = new ChromeDriver();
        try {
            driver.get(loginUrl);
            System.out.println("1. 进入登录页面，等待 5 分钟");
            WebElement mainElement = new WebDriverWait(driver, Duration.ofMinutes(5))
                    .until(driverd -> driverd.findElement(By.id("main")));

            System.out.println("2. 登录成功");
            Set<Cookie> cookies = driver.manage().getCookies();

            System.out.println("3. 获取所有 cookies");
            Map<String, String> paramsMap = new HashMap<>();
            StringBuffer cookieString = new StringBuffer();
            for(Cookie cookie: cookies){
                System.out.println(cookie.getName()+" : "+cookie.getValue());
                cookieString.append(cookie.getName());
                cookieString.append("=");
                cookieString.append(cookie.getValue());
                cookieString.append(";");
                if(cookie.getName().equals("zp_token")){
                    paramsMap.put(cookie.getName(),cookie.getValue());
                }
            }
            paramsMap.put("cookie",cookieString.toString());
            // 获取查询配置参数
            long nowTime = new Date().getTime();
            paramsMap.put("timestamp","&_="+nowTime);
            paramsMap.put("page","page"+EQUAL+PAGE_NUM);

            Map<String, String> headerMap = BuildHeaders.buildBossHeader(paramsMap);
            System.out.println(headerMap);

            System.out.println("4. 拼装request header");
            String finalUrl = requestUrl+paramsMap.get("page")+AND+queryParams+paramsMap.get("timestamp");
            Console.log("=================  Request URL: =================  "+finalUrl);
            Console.log("=================  Request Header: =================  ");
            headerMap.forEach((key,value)-> {
                Console.log("【 "+key+" 】 ====:==== 【 "+value+" 】");
            });
            HttpRequest httpRequest = HttpRequest.get(finalUrl).headerMap(headerMap,true).timeout(20000);
//            HttpRequest httpRequest = HttpRequest.get(requestUrl).headerMap(headerMap,true).timeout(20000);
            String resultBody = httpRequest.execute().body();
            Console.log(resultBody);
} finally {
            System.out.println("退出浏览器");
            driver.quit();
        }
    }
}
