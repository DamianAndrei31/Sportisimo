package sportisimo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class login {
    public static void waitFor(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public  void main() {
        // Setăm calea către driverul Chrome
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        // Inițializăm un obiect WebDriver pentru Chrome
        WebDriver driver = new ChromeDriver();

        // Navigăm către site-ul sporisimo
        driver.get("https://www.sportisimo.ro/");

        //Acceptare cookies
        WebElement acceptcookies = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/button[2]"));
        acceptcookies.click();

        // Găsim și apăsăm butonul de autentificare
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div[3]/div[2]/div/a/div"));
        loginButton.click();

        waitFor(2000);

        // Găsim câmpurile de autentificare și le completăm cu datele de logare
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"input_login_email\"]"));
        emailInput.sendKeys("damian.emilian.andrei@gmail.com");

        waitFor(2000);

        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div/form/div[2]/div/input"));
        passwordInput.sendKeys("Andrei1234");

        waitFor(2000);

        // Apăsăm butonul de autentificare
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"async_login_menu\"]/form/div[3]/div/label"));
        submitButton.click();

        waitFor(5000);

        //verificare
        WebElement verificare= driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div[3]/div[2]/div/div[1]/p"));
        Assert.assertTrue(verificare.getText().contains("andrei"));

        waitFor(2000);

        driver.manage().deleteAllCookies();
        driver.close();

    }
}
