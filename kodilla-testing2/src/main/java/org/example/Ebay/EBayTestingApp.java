package org.example.Ebay;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EBayTestingApp {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "c:\\Selenium-drivers\\Chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.ebay.com/");

        WebElement searchInput = driver.findElement(By.name("_nkw"));

        searchInput.sendKeys("Laptop");
        searchInput.sendKeys(Keys.RETURN);

        driver.quit();
    }
}