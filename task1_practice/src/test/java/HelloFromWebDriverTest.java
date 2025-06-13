import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.epam.automation.HelloFromWebDriver;

public class HelloFromWebDriverTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        HelloFromWebDriver pastebin = new HelloFromWebDriver(driver);

        try {
            pastebin.open();
            Thread.sleep(2000); // I know, not the best practice, but decided to keep it for the sake of demonstration...
            pastebin.enterCode("Hello from WebDriver");
            Thread.sleep(2000);
            pastebin.setExpiration("10 Minutes");
            Thread.sleep(2000);
            pastebin.enterTitle("helloweb");
            Thread.sleep(2000);
            pastebin.submit();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}