package svvskill;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver; // Step 1: Import the EdgeDriver class
public class Skill3 {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.amazon.in/");
        String pageTitle = driver.getTitle();
        System.out.println(" Title: " + pageTitle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphones");
        driver.findElement(By.id("nav-search-submit-button")).submit();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3000);");
        js.executeScript("window.scrollBy(0,-2000);");
    }
}
