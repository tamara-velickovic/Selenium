package zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {


        //Testirati login

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.navigate().to("https://www.wordpress.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String validEmail = "tamara.devet@gmail.com";
        String validPassword = "Tamara12345 ";
        String validUsername = "tamaravelickovic";

        WebElement loginLink = driver.findElement(By.linkText("Log In"));
        loginLink.click();

        WebElement emailField = driver.findElement(By.id("usernameOrEmail"));
        emailField.sendKeys(validEmail);



        WebElement continueButton = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/main/div/div/form/div[1]/div[2]/button"));
        continueButton.click();

        WebElement passwordField = driver.findElement(By.id("password"));
        //Thread.sleep(4000);
        passwordField.sendKeys(validPassword);

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/main/div/div/form/div[1]/div[2]/button"));
        loginButton.click();

        //Assertions

        /* Thread.sleep(4000);
        String expectedURL = "https://wordpress.com/home/tamaravelickovic.wordpress.com";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);  */


        wait.until(ExpectedConditions.urlToBe("https://wordpress.com/home/tamaravelickovic.wordpress.com"));
        //Ne treba nam vise ni asertacija


        WebElement profileButton = driver.findElement(By.cssSelector(".masterbar__item.masterbar__item-me"));
        profileButton.click();


        WebElement profileName = driver.findElement(By.className("profile-gravatar__user-display-name"));
        String profileNameText = profileName.getText();

        Assert.assertEquals(profileNameText, validUsername);

        WebElement logoutButton = driver.findElement(By.className("sidebar__me-signout-text"));
        Assert.assertTrue(logoutButton.isDisplayed());























    }


}
