package zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {

        //Potrebno je preko Gugla naci stranicu Wikipedije o Nikoli Tesli na cirilici

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com/");

        WebElement googleSearchBox = driver.findElement(By.id("APjFqb"));
        googleSearchBox.sendKeys("Никола Тесла");

        WebElement googleSearchButton = driver.findElement(By.name("btnK"));
        googleSearchButton.click();

        WebElement pageNikolaTesla = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
        pageNikolaTesla.click();

        //Assertions

        WebElement pageNikolaTeslaTitle = driver.findElement(By.className("mw-page-title-main"));
        String expectedResult = "https://sr.wikipedia.org/sr-ec/%D0%9D%D0%B8%D0%BA%D0%BE%D0%BB%D0%B0_%D0%A2%D0%B5%D1%81%D0%BB%D0%B0";
        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(expectedResult,actualResult );


        String pageTitleText = pageNikolaTeslaTitle.getText();
        String expectedTitleText = "Никола Тесла";

         Assert.assertEquals(pageTitleText, expectedTitleText);


        WebElement image = driver.findElement(By.className("infobox-image"));
        Assert.assertTrue(image.isDisplayed());












    }


}