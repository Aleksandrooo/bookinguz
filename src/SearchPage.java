import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;

/**
 * Created by user on 2/11/15.
 */
public class SearchPage {
    private static String depDateXpath = "//input[@id='date_dep']";
    private static String clickSearchXpath = "//button[@name='search']";
    private static String titleOfErrorMessageXpath = "//div[@class='vToolsPopupHeader']/span";
    private static String contentOfErrorMessagehXpath = "//div[@class='vToolsPopupContent']/p";
    private static String clickOKOfErrorMessageXpath = "//center[@class='vToolsPopupToolbar']/button[text()='OK']";

    public static void open(WebDriver webDriver) {
        webDriver.get("http://booking.uz.gov.ua/en/");
        webDriver.manage().window().maximize();
//       TestHelper.webDriver.manage().window().maximize();
//       TestHelper.webDriver.navigate().back();
//       TestHelper.webDriver.switchTo().alert().accept();
//       TestHelper.webDriver.switchTo().frame("topFrame");
//       TestHelper.webDriver.switchTo().parentFrame();
    }


    public static void setfield(String fieldName, String val) throws InterruptedException {
        String path = "//div[@class='name'][text()='" + fieldName;
        writeInField(fieldName, val);
//        Thread.sleep(2000);
//        BaseTest.webDriver.findElement(By.xpath(path + "']/../div[@class='autosuggest']/div[1]")).click();
        TestHelper.waitElement(path + "']/../div[@class='autosuggest']/div[1]").click();
    }

    public static void writeInField(String fieldName, String val) {
        String path = "//div[@class='name'][text()='" + fieldName;
        BaseTest.webDriver.findElement(By.xpath(path + "']/../input")).sendKeys(val);
    }

    public static void setDate(String monthdName, String val) {
        BaseTest.webDriver.findElement(By.xpath(depDateXpath)).click();
        BaseTest.webDriver.findElement(By.xpath(
                "//table[@class='month']/caption[text()='" + monthdName + "']/following::td[text()='" + val + "']")).click();
    }

    public static void clickSearch() {
        BaseTest.webDriver.findElement(By.xpath(clickSearchXpath)).click();
    }

    public static String getDepartureDate() {
        return  BaseTest.webDriver.findElement(By.xpath(depDateXpath)).getAttribute("value");
    }

    public static void ClickOKOfErrorMessage() {

    }

    public static void AssertTitleOfErrorMessage() {
    }

    public static void AssertContentOfErrorMessage() {
        //Select a departure point from the drop down list
        //Select your destination from the drop down list
    }


//    private static Map<String, String> fieldNameOsago = new HashMap<String, String>(){{
//        put("я хочу застраховать", transportXpath);
//        put("детали", detailsXpath);
//        put("зарегистирирован в", locationXpath);
//        put("стаж безаварийной езды", experienceXpath);
//        put("срок действия страховки", periodXpath);
//        put("хотите ли также заключить договор ДГО ?", dgoXpath);
//    }};
}
