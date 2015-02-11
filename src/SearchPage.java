import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by user on 2/11/15.
 */
public class SearchPage {
    private static String depDateXpath = "//input[@id='date_dep']";
    //private static String fucherDateXpath = "//table[@class='month']/caption[text()='March 2015']";

    public static void open(WebDriver webDriver) {
        webDriver.get("http://booking.uz.gov.ua/en/");
        webDriver.manage().window().maximize();
//       TestHelper.webDriver.manage().window().maximize();
//       TestHelper.webDriver.navigate().back();
//       TestHelper.webDriver.switchTo().alert().accept();
//       TestHelper.webDriver.switchTo().frame("topFrame");
//       TestHelper.webDriver.switchTo().parentFrame();
    }


    public static void setfield(String fieldName, String val) {
        BaseTest.webDriver.findElement(By.xpath("//div[@class='name'][text()='" + fieldName + "']/../input")).sendKeys(val);
    }

    public static void setDate(String monthdName, String val) {
        BaseTest.webDriver.findElement(By.xpath(depDateXpath)).click();
        BaseTest.webDriver.findElement(By.xpath(
                "//table[@class='month']/caption[text()='" + monthdName + "']/following::td[text()='" + val + "']")).click();
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
