package SeleniumUvod;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium6 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/");

        Cookie cookie = new Cookie("wordpress_logged_in", "tamaravelickovic%7C1792701943%7CON0m8GwmidhGxIc4aS1qMyHEwiR7wtzqKQLWWyVTpen%7Cb9bbeec73368f04df95d612bb2c1806d0bfcdd6c4c81191d3328c31b30395269");

        driver.manage().addCookie(cookie);
        driver.navigate().refresh();


    }
}