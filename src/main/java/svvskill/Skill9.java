package svvskill;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Skill9 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\LT Automation\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://randomwebsite.com/");
        try {
            WebElement signup = driver.findElement(By.xpath("//*[@id='navbarCollapse']/ul/li[2]/a"));
            signup.click();
            WebElement login = driver.findElement(By.xpath("//*[@id='modalSignUp']/div/div/div/div/div[4]/p/a"));
            login.click();
            String windowHandle = driver.getWindowHandle();
            WebElement TextBox = driver.findElement(By.xpath("//*[@id='login-modal-form']/div[1]/div/input"));
            TextBox.sendKeys("sample-email@lambdatest.com");
            WebElement Password = driver.findElement(By.xpath("//*[@id='login-modal-form']/div[2]/div/input"));
            Password.sendKeys("sample-password");
            WebElement proceed = driver.findElement(By.xpath("//*[@id='login-modal-form']/div[4]/button"));
            proceed.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
