package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver;
    public static String urlBase = "https://samuraibs-web-kennedy.herokuapp.com";
    @Before(value = "@setup")
    public void before(Scenario scenario) {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(urlBase);
    }

    @After(value = "@after")
    public void after(Scenario scenario) {
        if(scenario.isFailed()) {
            System.out.println(scenario.getName() + " =========================== FAILED ===============================");
        }else {
            System.out.println(scenario.getName() + " =========================== PASSED ===============================");
        }
        driver.close();
    }


}
