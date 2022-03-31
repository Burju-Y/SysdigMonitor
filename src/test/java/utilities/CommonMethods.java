package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonMethods {

    /**
     * This method will take a screenshot
     *
     * @param fileName
     */
    public static byte[] takeScreenShot(String fileName) {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH.mm.ss");
        String timeStamp = sdf.format(date.getTime());
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        byte[] picture = ts.getScreenshotAs(OutputType.BYTES);
        File file = ts.getScreenshotAs(OutputType.FILE);
        String scrshotFile = Constants.SCREENSHOTS_FILEPATH + fileName + timeStamp + ".png";
        try {
            FileUtils.copyFile(file, new File(scrshotFile));
        } catch (IOException e) {
            System.out.println("Cannot take a screenshot");
        }
        return picture;
    }

    /**
     * This method performs Keyboard Enter interaction with Actions class
     */
    public static void actionKeysEnter(){
        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.ENTER).perform();
    }

}
