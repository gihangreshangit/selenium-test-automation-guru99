import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    public class guru99Test {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/V4/index.php");

    }

    @Test
    public void successfulLogin() {

        WebElement userIDText = driver.findElement(By.name("uid"));
        userIDText.sendKeys("mngr665244");
        WebElement passwordText = driver.findElement(By.name("password"));
        passwordText.sendKeys("sevynAg");
        WebElement loginButton = driver.findElement(By.name("btnLogin"));
        loginButton.click();

        WebElement welcomeLabel = driver.findElement(By.xpath("//tr[@class='heading3']/td"));

        Assert.assertEquals(welcomeLabel.getText(), "Manger Id : mngr665244", "Error: The user message is diferent.");

    }

    @Test
    public void unsuccessfulLogin() {

        WebElement userIDText = driver.findElement(By.name("uid"));
        userIDText.sendKeys("mngr665244");
        WebElement passwordText = driver.findElement(By.name("password"));
        passwordText.sendKeys("sevynAg###");
        WebElement loginButton = driver.findElement(By.name("btnLogin"));
        loginButton.click();

        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "User or Password is not valid", "Error: Allert message incorrect");

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
