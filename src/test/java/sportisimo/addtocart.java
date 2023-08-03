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

public class addtocart {
    public static void waitFor(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void addtocart(){
        // Setăm calea către driverul Chrome
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        // Inițializăm un obiect WebDriver pentru Chrome
        WebDriver driver = new ChromeDriver();

        // Navigăm către site-ul sporisimo
        driver.get("https://www.sportisimo.ro/");



        waitFor(2000);

        //Acceptare cookies
        WebElement acceptcookies = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/button[2]"));
        acceptcookies.click();

        WebElement butoncautare= driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div[3]/div[1]/div/p"));
        butoncautare.click();

        // Căutăm produsul "ceas" în bara de căutare
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"search_input\"]"));
        searchInput.click();
        searchInput.sendKeys("garmin");

         WebElement clicksearch= driver.findElement(By.className("text"));
        clicksearch.click();

        // WebElement vizualizaremaimulteproduse= driver.findElement(By.xpath("//*[@id=\"body\"]/div[3]/div[1]/div[2]/div/div[1]/div[3]/div[2]/form/div/label"));
       // vizualizaremaimulteproduse.click();
        //waitFor(1000);

        // Adaugam primul rezultat in cosul de cumparaturi
        WebElement selectareceas = driver.findElement(By.partialLinkText("FORERUNNER 45S OPC"));

        waitFor(2000);

        selectareceas.click();

        //Adauga in cos
        WebElement adaugaincos= driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/div[5]/div[3]/form/div[3]/div[1]/div/button/span"));
        adaugaincos.click();
        waitFor(3000);

         WebElement verificare= driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/div[6]/div/div/div[1]/div/div/div/h1/span"));
        Assert.assertTrue(verificare.getText().contains("adăugat"));

        // Închidem browser-ul
        driver.quit();

    }




}
