import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by user on 2/11/15.
 */

public class TestHelper {

    public static WebElement waitElement(String path) throws InterruptedException {
        int timeout = 30000, timepassed = 0, s;
        while(timepassed < timeout) {
            s = BaseTest.webDriver.findElements(By.xpath(path)).size();
            if (BaseTest.webDriver.findElements(By.xpath(path)).size() > 0) {
                WebElement we = BaseTest.webDriver.findElements(By.xpath(path)).get(0);
                return we;
            }
            Thread.sleep(100);
            timepassed += 100;
        }
        Assert.fail();
        return null;
    }

    public static List<WebElement> waitElements(String path) throws InterruptedException {
        int timeout = 30000, timepassed = 0, s;
        while(timepassed < timeout) {
            s = BaseTest.webDriver.findElements(By.xpath(path)).size();
            if (BaseTest.webDriver.findElements(By.xpath(path)).size() > 0) {
                List<WebElement> we = BaseTest.webDriver.findElements(By.xpath(path));
                return we;
            }
            Thread.sleep(100);
            timepassed += 100;
        }
        Assert.fail();
        return null;
    }

    public static void waitValue(WebDriver webDriver,  String path, String val) throws InterruptedException {
        int timeout = 30000, timepassed = 0, s;
        while(timepassed < timeout) {
            if (webDriver.findElements(By.xpath(path)).size() > 0) {
                WebElement we = webDriver.findElements(By.xpath(path)).get(0);
                if(val.equals(we.getAttribute("value"))) {
                    return;
                }
            }
            Thread.sleep(100);
            timepassed += 100;
        }
        Assert.fail();

    }

    public static void waitText(WebDriver webDriver,  String path, String val) throws InterruptedException {
        int timeout = 30000, timepassed = 0, s;
        while(timepassed < timeout) {
            if (webDriver.findElements(By.xpath(path)).size() > 0) {
                WebElement we = webDriver.findElements(By.xpath(path)).get(0);
                if(val.equals(we.getText())) {
                    return;
                }
            }
            Thread.sleep(100);
            timepassed += 100;
        }
        Assert.fail();

    }

}
