package steps;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver;
    private static ExtentHtmlReporter extentHtmlReporter;
    private static ExtentReports extentReport;
    private static ExtentTest extentTest;
    public static String urlBase = "https://samuraibs-web-kennedy.herokuapp.com";
    @Before(value = "@setup")
    public void before(Scenario scenario) {
        if(extentReport == null) {
            extentReport = new ExtentReports();
            extentHtmlReporter = new ExtentHtmlReporter("src\\main\\resources\\htmlReporter.html");
            extentReport.attachReporter(extentHtmlReporter);
        }

        extentTest = extentReport.createTest(scenario.getName());

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
        extentTest.log(Status.PASS, "Cenário " + scenario.getName() + " executado com sucesso!");
        extentReport.flush();
        driver.close();
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static ExtentTest getExtentTest() {
        return extentTest;
    }


}
