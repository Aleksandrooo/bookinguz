import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by user on 2/11/15.
 */

public class TestHelper {

    public static WebElement waitElement(WebDriver webDriver,  String path) throws InterruptedException {
        int timeout = 30000, timepassed = 0, s;
        while(timepassed < timeout) {
            s = webDriver.findElements(By.xpath(path)).size();
            if (webDriver.findElements(By.xpath(path)).size() > 0) {
                //if (s > 0) {
                WebElement we = webDriver.findElements(By.xpath(path)).get(0);
                //System.out.println(we.getAttribute("value"));
                return we;
            }
            Thread.sleep(100);
            timepassed += 100;
            //System.out.println(timepassed);
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
