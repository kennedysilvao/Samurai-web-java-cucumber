package utilitarios;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import steps.Hooks;

import java.io.File;
import java.io.IOException;

public class Utils {
    public static void logPrint(String strLog) {

        ExtentTest extentTest = Hooks.getExtentTest();
        try {
            takeScreenshot(strLog);
            extentTest.log(Status.INFO, strLog, MediaEntityBuilder.createScreenCaptureFromPath("./evidencias/" + strLog + ".jpeg").build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void takeScreenshot(String strLog) {
        File srcFile = ((TakesScreenshot) Hooks.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("./evidencias/" + strLog + ".jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
