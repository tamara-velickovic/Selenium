package zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak5A {

    public static void main(String[] args) {


        //Blank credentials

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://practicetestautomation.com/");

        WebElement practiceTab = driver.findElement(By.id("menu-item-20"));
        practiceTab.click();

        WebElement testLoginPageLink = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageLink.click();

        // WebElement usernameField = driver.findElement(By.id("username"));
        // WebElement passwordField = driver.findElement(By.id("password"));

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.id("error"));


        //Ocekujem adekvatno obavestenje korisnika

        String expectedMessage = " Your username/password is empty!";

        Assert.assertEquals(errorMessage.getText(), expectedMessage);


        // 1. Valid oba                                         PASS
        // 2. Invalid oba
        // 3. Blank oba                                         FAIL
        // 4. Username valid, password invalid
        // 5. Username blank, password valid
        // 6. Username blank, password invalid
        // 7. Username invalid, password blank
        // 8. Username valid, password blank
        // 9. Username invalid, password valid
        // 10.


        // Logout


    }
}
