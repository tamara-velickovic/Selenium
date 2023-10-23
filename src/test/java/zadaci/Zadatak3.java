package zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

import static org.openqa.selenium.Keys.ENTER;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {

        //Zadatak 3
        //Otici na Google
        //Zatim ukucati "Wikipedia" u polje za pretragu
        //Odraditi pretragu i otvoriti stranicu
        //Na stranici Wikipedia pretraziti "Nikola Tesla"


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com/");

        WebElement searchBox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea"));
        searchBox.sendKeys("Wikipedia");
        searchBox.sendKeys(ENTER);

        Thread.sleep(4000);
        WebElement pageItem = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
        pageItem.click();

        WebElement searchBoxWiki = driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/div/input"));
        searchBoxWiki.sendKeys("Nikola Tesla");
        searchBoxWiki.sendKeys(ENTER);


















    }


}
