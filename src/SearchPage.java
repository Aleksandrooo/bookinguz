import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by user on 2/11/15.
 */
public class SearchPage {
    private static String depDateXpath = "//input[@id='date_dep']";
    private static String clickSearchXpath = "//button[@name='search']";
    private static String titleOfErrorMessageXpath = "//div[@class='vToolsPopupHeader']/span";
    private static String contentOfErrorMessagehXpath = "//div[@class='vToolsPopupContent']/p";
    private static String clickOKOfErrorMessageXpath = "//center[@class='vToolsPopupToolbar']/button[text()='Ok']";
    private static String depTimeXpath = "//select[@name='time_dep']";
    private static String roundTripXpath = "//input[@name='round_trip']";


    public static void open(WebDriver webDriver) {
        webDriver.get("http://booking.uz.gov.ua/en/");
        webDriver.manage().window().maximize();
//       TestHelper.webDriver.manage().window().maximize();
//       TestHelper.webDriver.navigate().back();
//       TestHelper.webDriver.switchTo().alert().accept();
//       TestHelper.webDriver.switchTo().frame("topFrame");
//       TestHelper.webDriver.switchTo().parentFrame();
    }

    public static String getfieldXpath(String fieldName) {
        return "//div[@class='name'][text()='" + fieldName + "']/../input";
    }

    public static void setfield(String fieldName, String val) throws InterruptedException {
        //String path = "//div[@class='name'][text()='" + fieldName;
        writeInField(fieldName, val);
//        Thread.sleep(2000);
//        BaseTest.webDriver.findElement(By.xpath(path + "']/../div[@class='autosuggest']/div[1]")).click();
        TestHelper.waitElement(getfieldXpath(fieldName) + "/../div[@class='autosuggest']/div[1]").click();
    }

    public static void writeInField(String fieldName, String val) {
        //String path = "//div[@class='name'][text()='" + fieldName;
        BaseTest.webDriver.findElement(By.xpath(getfieldXpath(fieldName))).sendKeys(val);
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
        BaseTest.webDriver.findElement(By.xpath(clickOKOfErrorMessageXpath)).click();
    }

    public static void AssertTitleOfErrorMessage() {
        //vToolsPopupHeader
        Assert.assertEquals("Error filling in the form",
                BaseTest.webDriver.findElement(By.xpath(titleOfErrorMessageXpath)).getText());
    }

    public static void AssertContentOfErrorMessage() {
        //Select a departure point from the drop down list
        Assert.assertEquals("Select a departure point from the drop down list",
                BaseTest.webDriver.findElement(By.xpath(contentOfErrorMessagehXpath + "[1]")).getText());
        //Select your destination from the drop down list
        Assert.assertEquals("Select your destination from the drop down list",
                BaseTest.webDriver.findElement(By.xpath(contentOfErrorMessagehXpath + "[2]")).getText());
    }

    public static String getDepartureDatefromBtnSearch() throws InterruptedException {
        //Thread.sleep(2000);
        return BaseTest.webDriver.findElement(By.xpath(clickSearchXpath + "/span")).getText();
    }

    public static void checkFrom() {
        BaseTest.webDriver.findElement(By.xpath(getfieldXpath("From")));

    }

    public static void checkTo() {
        BaseTest.webDriver.findElement(By.xpath(getfieldXpath("To")));
    }

    public static void checkDepartureDate() {
        BaseTest.webDriver.findElement(By.xpath(depDateXpath));
    }

    public static void checkDepartureTime() {
       BaseTest.webDriver.findElement(By.xpath(depTimeXpath));
    }

    public static void checkRoundTrip() {
        BaseTest.webDriver.findElement(By.xpath(roundTripXpath));
    }

    public static void checkBtnSearch() {
        BaseTest.webDriver.findElement(By.xpath(clickSearchXpath));
    }


    public static void assertCheckVariantsStation(String fieldName, String val, List<String> st) throws InterruptedException {
        SearchPage.writeInField(fieldName, val);
        //List<WebElement> stations = BaseTest.webDriver.findElements(
        //        By.xpath(getfieldXpath(fieldName) + "/../div/div"));
        List<WebElement> stations = TestHelper.waitElements(getfieldXpath(fieldName) + "/../div/div");
        for(int i = 0; i < st.size(); i++){
            Assert.assertEquals(st.get(i), stations.get(i).getAttribute("title"));
        }
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
