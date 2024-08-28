package com.nec.pptgenerator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class App {
    private WebDriver driver;

    // Initialize and set path
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:5001");
    }

    public void generatePPT() {
        // Press the start button
        WebElement startButton = driver.findElement(By.cssSelector("a.btn.btn-primary.btn-lg.mt-4[href='/generate']"));
        startButton.click();

        // Test variables to be used
        String title = "Research on eVTOL";
        String presenter = "Eric Mu";
        String slideCount = "3";
        String content = "Explore the latest advancements in electric vertical takeoff and landing (eVTOL) technology. The first page primarily discusses the technological innovations of domestic and international companies and the current major technologies of eVTOL. The second page focuses on market dynamics, including the research and development progress and certification status of leading companies at home and abroad. The third page discusses future trends, analyzing eVTOL-related regulations and identifying several countries most likely to pioneer the development of eVTOL.";

        // Input fields
        WebElement titleInput = driver.findElement(By.id("presentation_title"));
        WebElement presenterInput = driver.findElement(By.id("presenter_name"));
        WebElement slideInput = driver.findElement(By.id("number_of_slide"));
        WebElement contentInput = driver.findElement(By.id("user_text"));
        WebElement templateChoice = driver.findElement(By.id("NEC"));

        WebElement llmChoice = driver.findElement(By.id("assistant_choice"));
        Select llmSelect = new Select(llmChoice);

        WebElement searchChoice = driver.findElement(By.id("online_choice"));
        Select onlineSelect = new Select(searchChoice);

        WebElement imageChoice = driver.findElement(By.id("add_image"));
        Select imageSelect = new Select(imageChoice);

        // Insert the variables into corresponding fields
        titleInput.sendKeys(title);
        presenterInput.sendKeys(presenter);
        slideInput.sendKeys(slideCount);
        contentInput.sendKeys(content);
        templateChoice.click();
        llmSelect.selectByVisibleText("Kimi");
        onlineSelect.selectByVisibleText("否");
        imageSelect.selectByVisibleText("否");

        // Click generate
        WebElement generateButton = driver.findElement(By.id("generate-button"));
        generateButton.click();

        // Click save to save the changes and generate the ppt
        WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(),'保存')]"));
        saveButton.click();
    }

    public void teardown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
