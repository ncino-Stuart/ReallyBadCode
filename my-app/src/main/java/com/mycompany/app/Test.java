package com.mycompany.app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {

    public static final By XPATH_TO_THE_DATA_ON_THE_PAGE = By.xpath("/html/body/div/div[3]/textarea");

    public static void main(String[] args) {
        // URL to load
        String url = "https://www.google.com/";

        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Configure ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");

        // Create an instance of ChromeDriver with options
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to the website
            driver.get(url);

            // Find the element containing the text and print it
            String text = driver.findElement(XPATH_TO_THE_DATA_ON_THE_PAGE).getText();
            System.out.println(text);
        } catch (Exception e) {
            // Handle any exceptions that occur
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
