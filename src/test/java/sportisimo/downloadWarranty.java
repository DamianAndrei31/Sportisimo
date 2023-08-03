package sportisimo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.openqa.selenium.WindowType;



public class downloadWarranty {

    public static void waitFor(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
public void downloadWarranty(){

        // Setăm calea către driverul Chrome
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

    // Inițializăm un obiect WebDriver pentru Chrome
    WebDriver driver = new ChromeDriver();

    // Navigăm către site-ul sporisimo
    driver.get("https://www.sportisimo.ro/");

    //Acceptare cookies
    WebElement acceptcookies = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/button[2]"));
    acceptcookies.click();
  waitFor(2000);

  WebElement ptdescare= driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div[2]/div[1]/ul/li[13]/a"));
    ptdescare.click();

    waitFor(3000);
  WebElement downloadgarantie= driver.findElement(By.xpath("//*[@id=\"section_1\"]/div/div[4]/div[1]/div/div[2]/div/div[1]"));
    downloadgarantie.click();

    waitFor(3000);
    Actions action = new Actions(driver); action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();

        waitFor(2000);

    System.out.println(driver.getTitle());

    String numedescarcare= driver.getCurrentUrl();

    waitFor(100);
    //Assert.assertTrue(numedescarcare.contains("pdf"));

    //driver.switchTo().newWindow(WindowType.TAB);
}
}
