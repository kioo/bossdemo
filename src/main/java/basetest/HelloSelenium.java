package basetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class HelloSelenium {
    public static void main(String[] args) {
        // 配置 drive 位置
        System.setProperty("webdriver.chrome.driver","/Users/wangchi/IdeaProjects/beyonsoft/bossdemo/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        driver.getTitle(); // => "Google"

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.name("btnK"));

        searchBox.sendKeys("Selenium");
        searchButton.click();

        searchBox = driver.findElement(By.name("q"));
        searchBox.getAttribute("value"); // => "Selenium"

        driver.quit();
    }
}

///Users/wangchi/IdeaProjects/beyonsoft/bossdemo/chromedriver