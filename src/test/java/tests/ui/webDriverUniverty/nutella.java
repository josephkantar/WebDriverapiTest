package tests.ui.webDriverUniverty;

import driver.Driver;
import driver.DriverMngr;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class nutella {
    private WebDriver driver;
    @Test
    public void test01() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        WebElement searchBox= driver.findElement(By.cssSelector("[id='APjFqb']"));
        searchBox.sendKeys("Nutella");
        searchBox.submit();
        WebElement resultStatsElement=driver.findElement(By.cssSelector("[id='result-stats']"));
        String resulText= resultStatsElement.getText();
        String numberText = resulText.replaceAll("[^0-9]", "");
        long sonuc=Long.parseLong(numberText);
        Assert.assertTrue(sonuc > 1000000, "1.000.000'dan fazla");
    }
}















