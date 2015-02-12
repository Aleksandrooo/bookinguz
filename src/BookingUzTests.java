import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 2/11/15.
 */
@RunWith(JUnit4.class)
public class BookingUzTests extends BaseTest{

    @Test
    public void searchKyivIF() throws InterruptedException, IOException {
        SearchPage.setfield("From", "Kyiv");
        SearchPage.setfield("To", "Ivano");
        SearchPage.setDate("March 2015", "11");//March 2015
        SearchPage.clickSearch();
        Thread.sleep(10000);
        testPassed = true;
    }

    @Test
    public void searchKyIf_messageError() throws InterruptedException, IOException {
        SearchPage.writeInField("From", "Ky");
        SearchPage.writeInField("To", "Iv");
        //SearchPage.setDate("March 2015", "11");//March 2015
        SearchPage.clickSearch();
        SearchPage.AssertTitleOfErrorMessage();
        SearchPage.AssertContentOfErrorMessage();
        SearchPage.ClickOKOfErrorMessage();
        Thread.sleep(10000);
        testPassed = true;
    }

    @Test
    public void checkCommonFieldOnSearchPage() throws InterruptedException, IOException {
//        SearchPage.checkFrom();
//        SearchPage.checkTo();
//        SearchPage.checkDepartureDate();
//        SearchPage.checkDepartureTime();
//        SearchPage.checkRoundTrip();
//        SearchPage.checkBtnSearch();
        testPassed = true;
    }

    @Test
    public void checkTodayDay() throws InterruptedException, IOException {
//        SearchPage.getDepartureDate();
        Date date = new Date();
        SimpleDateFormat today = new SimpleDateFormat("dd.MM.yyyy");
        Assert.assertEquals(today.format(date), SearchPage.getDepartureDate());
        testPassed = true;
    }


}
