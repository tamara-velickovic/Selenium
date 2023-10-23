package SeleniumUvod;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Selenium2 {

    public static void main(String[] args) {


       //  JavascriptExecutor js= (JavascriptExecutor) driver;
       // js.executeScript(" window.open()");

       //Pozivamo kako bi mogla da se izvrsi skripta za otvaranje novih tabova

       //driver.getWindowHandles()
       //Funkcija koja sve otvorene tabove smesta u listu

       // ArrayList<String> listaTabova = new ArrayList <> (driver.getWindowHandles());
       // driver.switchTo()listaTabova.get(1))





        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(listaTabova.get(1));
        js.executeScript("window.open()");
        driver.navigate().to("https://www.linkedin.com/");

        //0
        //0 - 1
        //0 - 2 - 1
        //0 - 3 - 2 - 1

    }
}