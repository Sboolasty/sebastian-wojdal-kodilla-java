package org.example.facebook;

import org.example.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestingApp {
    public static final String XPATH_DENY_COOKIES = "//button[@class=\"_42ft _4jy0 _al66 _4jy3 _4jy1 selected _51sy\"]";
    public static final String XPATH_REGISTER = "//a[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        assert driver != null;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        driver.get("https://www.facebook.com");

        driver.findElement(By.xpath(XPATH_DENY_COOKIES)).click();
        driver.findElement(By.xpath(XPATH_REGISTER)).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name=\"birthday_day\"]")));

        Select selectDay = new Select(driver.findElement(By.xpath("//select[@name=\"birthday_day\"]")));
        selectDay.selectByValue("11");
        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@name=\"birthday_month\"]")));
        selectMonth.selectByValue("12");
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@name=\"birthday_year\"]")));
        selectYear.selectByValue("1986");
    }
}