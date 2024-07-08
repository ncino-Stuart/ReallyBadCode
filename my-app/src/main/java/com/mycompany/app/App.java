package com.mycompany.app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.nio.file.Path;
import java.util.*;


/**
 * Someone has written some really smelly code!
 * In the file below, we are reading the data from data.csv, and printing it in a human-readable format
 * (IE each line in the csv printed like this: "email : thisemail@fake.com")
 * There are many bad practices here, and a few bugs.
 *
 * Your job is to modify code so that it works, and is up to your standards.
 * Feel free to run the program, run the unit tests and change anything you see fit.
 *
 * Good luck!
 */


public class App 
{

    // com.testing.myapp.Main method
    public static final By XPATH_TO_THE_DATA_ON_THE_PAGE_THAT_I_WANT = By.xpath("/html/body/div/div[3]/textarea");
    public static void main(String[] args) {
        // I need to load the local webpage

        String path = "file:///Users/stuartgreenlief/src/interview/ReallyBadCode/my-app/src/main/www/MyData.html";
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--remote-allow-origins=*");
        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver(options);

        // Navigate to a website
        driver.get(path);


        var elementofthings = driver.findElement(By.xpath("/html/body/div/div[3]/textarea")).getText();
        System.out.println(elementofthings);
        driver.quit();
    }
}



