package domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {


    public static void main(String[] args) throws InterruptedException {


        //Otici na YouTube i pustiti jednu pesmu po Vasem izboru.


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://www.youtube.com");


        WebElement searchBoxYoutube = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/ytd-searchbox/form/div[1]/div[1]/input"));
        searchBoxYoutube.sendKeys("Bee Gees - Stayin' Alive");

        WebElement searchButton = driver.findElement(By.id("search-icon-legacy"));
        searchButton.click();

        Thread.sleep(4000);
        WebElement songLink = driver.findElement(By.linkText("Bee Gees - Stayin' Alive (Official Music Video)"));
        songLink.click();


    }
}



