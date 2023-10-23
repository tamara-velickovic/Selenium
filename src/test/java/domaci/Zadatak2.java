package domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;


public class Zadatak2 {
public static void main(String[] args)  {


    //Napisati test case za dati text box

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.navigate().to("https://demoqa.com/text-box/");

    WebElement fullNamefield = driver.findElement(By.id("userName"));
    WebElement emailfield = driver.findElement(By.id("userEmail"));
    WebElement currentAddressfield = driver.findElement(By.id("currentAddress"));
    WebElement permanentAddressfield = driver.findElement(By.id("permanentAddress"));
    WebElement submitButton = driver.findElement(By.id("submit"));

    //ValidInput

    ArrayList<String> testFullNames = new ArrayList<>();
    testFullNames.add("test");
    testFullNames.add("Tamara Velickovic");


    ArrayList<String> testEmails = new ArrayList<>();
    testEmails.add("test@mail.com");
    testEmails.add("tamara.devet@gmail.com");


    ArrayList<String> testAddresses = new ArrayList<>();
    testAddresses.add("test");
    testAddresses.add("Knez Mihajlova");


    for (int i = 0; i < testFullNames.size(); i++) {

        fullNamefield.sendKeys(testFullNames.get(i));
        emailfield.sendKeys(testEmails.get(i));
        currentAddressfield.sendKeys(testAddresses.get(i));
        permanentAddressfield.sendKeys(testAddresses.get(i));
        submitButton.click();

        //Asertacije

        WebElement nameOutput = driver.findElement(By.id("name"));
        WebElement emailOutput = driver.findElement(By.id("email"));
        WebElement currentAddressOutput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[3]"));
        WebElement permanentAddressOutput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[4]"));

        //Ukoliko sam dobro primetila, to sto label field-a i text output nisu dva odvojena elementa bih smatrala bug-om i test case outcome bih stavila da je Fail ili makar kao improvement suggestion,
        // ali u svrhu vezbe cu zanemariti

        Assert.assertEquals( nameOutput.getText(), "Name:"+testFullNames.get(i));
        Assert.assertEquals( emailOutput.getText(), "Email:"+testEmails.get(i));
        Assert.assertEquals( currentAddressOutput.getText(),"Current Address :"+ testAddresses.get(i));
        Assert.assertEquals( permanentAddressOutput.getText(),"Permananet Address :"+ testAddresses.get(i)); // Ovde ima i slovnu gresku u reci "Parmanent"



        fullNamefield.clear();
        emailfield.clear();
        permanentAddressfield.clear();
        currentAddressfield.clear();
    }












    }

}
