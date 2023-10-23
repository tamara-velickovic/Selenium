package zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak5 {
    public static void main(String[] args) {


        //Testirati login

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String validUsername = "student";
        String validPassword = "Password123";

        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");



        WebElement usernameBox = driver.findElement(By.id("username"));
        WebElement passwordBox = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

       usernameBox.sendKeys(validUsername);
       passwordBox.sendKeys(validPassword);
       submitButton.click();

       //Assertions

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
       // logOutButton.click();

        Assert.assertTrue(logOutButton.isDisplayed());


       String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
       String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);


        WebElement message = driver.findElement(By.className("has-text-align-center"));
        String expectedMessage = "Congratulations " + validUsername + ". You successfully logged in!";

        Assert.assertEquals(message.getText(), expectedMessage);























    }

}
