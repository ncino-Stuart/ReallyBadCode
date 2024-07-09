package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public static final By XPATH_TO_THE_DATA_ON_THE_PAGE_THAT_I_WANT = By.xpath("/html/body/div/div[3]/textarea");
    public static final By XPATH_TO_THE_BUTTON_ON_THE_PAGE_THAT_I_WANT = By.xpath("//button");
    public static final By CSS_SELECTOR_TO_THE_DATA_ON_THE_PAGE_THAT_I_WANT = By.cssSelector("html body div#container div#text-area-box.box textarea");
    public static final By CSS_SELECTOR_TO_THE_BUTTON_ON_THE_PAGE_THAT_I_WANT = By.cssSelector("html body div#container div#text-area-box.box button:nth-child(3)");

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

// TESTING THE INITAL STATE OF THE FIELD
    @Test
    public void GetInitial__String_Of_Field() {
        // I need to load the local webpage

        try {
            String path = "file:///Users/stuartgreenlief/src/interview/ReallyBadCode/src/main/www/MyData.html";
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
            assertTrue(elementofthings.equals("thisemail@fake.com".toString()));

            // Close the browser
            driver.quit();
        } catch (Exception e) {
            System.out.println("An error occourreed");
        }
    }

    // TESTING THE INITAL STATE OF THE FIELD
    @Test
    public void Getthechanged__String_Of_Field() throws Exception {
        // I need to load the local webpage

        try {
            String path = "file:///Users/stuartgreenlief/src/interview/ReallyBadCode/src/main/www/MyData.html";
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--remote-allow-origins=*");
            // Create an instance of ChromeDriver
            WebDriver driver = new ChromeDriver(options);

            // Navigate to a website
            driver.get(path);


            var elementofthings = driver.findElement(XPATH_TO_THE_DATA_ON_THE_PAGE_THAT_I_WANT).getText();
            System.out.println(elementofthings);

            // compare the string to the target
            // for some reason the string is not being compared correctly, when I do "target" == elementofthings it returns false
            var target = "thisemail@fake.com";
            for (int j =0; j < elementofthings.length(); j+= 1) {
                int i = j ;
                System.out.println(elementofthings.charAt(i));
                assertEquals(elementofthings.charAt(i), target.charAt(i));
            }
            // Click the button
            driver.findElement(XPATH_TO_THE_BUTTON_ON_THE_PAGE_THAT_I_WANT).click();

            Thread.sleep(2000);

            System.out.println("I clicked the button, done sleeping!");

            elementofthings = driver.findElement(XPATH_TO_THE_DATA_ON_THE_PAGE_THAT_I_WANT).getAttribute("value");
            Thread.sleep(2000);

            System.out.println(elementofthings);
            assertEquals((elementofthings.equals("newemail@updated.com")), true);

            // Close the browser
            driver.quit();
        } catch (Exception e) {
            System.out.println("An error occourreed");
        }
    }
}
