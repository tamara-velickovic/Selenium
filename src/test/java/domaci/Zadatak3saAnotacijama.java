package domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class Zadatak3saAnotacijama {


    // Ulogujte se na demoqa(https://demoqa.com/ -> Book Store Application) preko cookies-a, dodati dve knjige
    //  na svoj nalog, zatim se izlogovati brisanjem cookies-a. Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu.

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void closeAll() {

            driver.quit();

    }

    @BeforeMethod
    public void getUrl() {
        driver.navigate().to("https://demoqa.com/");
    }

    @Test (priority = 1)
    public void LoginWithCookies() throws InterruptedException {


        Cookie username = new Cookie("userName", "tamaravelickovic");
        Cookie userID = new Cookie("_cc_id", "858facf6-58cb-4f39-bb3f-6c18d3a8a6d9");
        Cookie expires = new Cookie("expires", "2023-10-08T14%3A34%3A30.522Z");
        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InRhbWFyYXZlbGlja292aWMiLCJwYXNzd29yZCI6IlRhbWFyYTEyMzQ1ISIsImlhdCI6MTY5NjE2OTg4Nn0.H1WG_7GEJDiR_LSeY3vbge3mnc85s_2Bovi5pryhDWk");

        driver.manage().addCookie(username);
        driver.manage().addCookie(userID);
        driver.manage().addCookie(expires);
        driver.manage().addCookie(token);

        driver.navigate().refresh();

    }


        @Test (priority = 2) // (dependsOnMethods = "LoginWithCookies") //ili standard login
        public void addBooks () throws InterruptedException {

            //Pristup BookStore-u


            List<WebElement> homePageCards = driver.findElements(By.className("card-body"));

            for (int i = 0; i < homePageCards.size(); i++) {
                if (homePageCards.get(i).getText().equals("Book Store Application")) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homePageCards.get(i));
                    homePageCards.get(i).click();
                }
            }

            //Dodavanje dve knjige


            WebElement firstBook = driver.findElement(By.linkText("Git Pocket Guide"));
            firstBook.click();

            WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
            wait.until(ExpectedConditions.elementToBeClickable(addButton));
            addButton.click();


            WebElement secondBook = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
            secondBook.click();

            WebElement addButton2 = driver.findElement(By.id("addNewRecordButton"));
            wait.until(ExpectedConditions.elementToBeClickable(addButton2));
            addButton2.click();
        }




    @Test (priority = 3) //(dependsOnMethods = "LoginWithCookies") //ili standard login
    public void Logout() {


        // Logout brisanjem cookie-a
        driver.manage().deleteCookieNamed("userName");
        driver.manage().deleteCookieNamed("userID");
        driver.manage().deleteCookieNamed("expires");
        driver.manage().deleteCookieNamed("token");
        driver.navigate().refresh();


    }
    @Test (priority = 4)
    public void standardLogin() {

        //Pristup BookStore-u (mozda neka odvojena metoda)


        List<WebElement> homePageCards = driver.findElements(By.className("card-body"));

        for (int i = 0; i < homePageCards.size(); i++) {
            if (homePageCards.get(i).getText().equals("Book Store Application")) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homePageCards.get(i));
                homePageCards.get(i).click();
            }
        }

        String myUsername = "tamaravelickovic";
        String myPassword = "Tamara12345!";

        WebElement login = driver.findElement(By.id("login"));
        login.click();

        WebElement userNameField = driver.findElement(By.id("userName"));
        userNameField.clear();
        userNameField.sendKeys(myUsername);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(myPassword);

        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
    }

    @Test(dependsOnMethods = "standardLogin") //ili loginWithCookies
    public void verifyBooksArePresent() {

        //Pristupanje Collections na profilu

        List<WebElement> homePageCards = driver.findElements(By.className("card-body"));

        for (int i = 0; i < homePageCards.size(); i++) {
            if (homePageCards.get(i).getText().equals("Book Store Application")) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homePageCards.get(i));
                homePageCards.get(i).click();
            }
        }

        List<WebElement> profile = driver.findElements(By.id("item-3"));

        for (int i = 0; i < profile.size(); i++) {
            if (profile.get(i).getText().equals("Profile")) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", profile.get(i));
                profile.get(i).click();
            }
        }

        //Asertacije

        WebElement firstBookPresent = driver.findElement(By.linkText("Git Pocket Guide"));
        Assert.assertTrue(firstBookPresent.isDisplayed());

        WebElement secondBookPresent = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        Assert.assertTrue(secondBookPresent.isDisplayed());

    }
}