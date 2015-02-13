import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public void checkVariantsFrom() throws InterruptedException, IOException {
        List<String> st =new ArrayList<String>();
        st.add("Kyaniv Pereval");
        st.add("Kyanivka");
        st.add("Kybyntsi");
        st.add("Kychyranky");
        st.add("Kyiv");
        st.add("Kyivska Rusanivka");
        st.add("Kyj");
        st.add("Kykshor");
        st.add("Kyn");
        st.add("Kynnu");
        SearchPage.assertCheckVariantsStation("From", "Ky", st);
        //SearchPage.AssertContentOfErrorMessage();
        //SearchPage.ClickOKOfErrorMessage();
        Thread.sleep(5000);
        testPassed = true;
    }

    @Test
    public void checkCommonFieldOnSearchPage() throws InterruptedException, IOException {
        SearchPage.checkFrom();
        SearchPage.checkTo();
        SearchPage.checkDepartureDate();
        SearchPage.checkDepartureTime();
        SearchPage.checkRoundTrip();
        SearchPage.checkBtnSearch();
        testPassed = true;
    }

    @Test
    public void checkTodayDay() throws InterruptedException, IOException {
//        SearchPage.getDepartureDate();
        Date date = new Date();
        SimpleDateFormat today = new SimpleDateFormat("MM.dd.yyyy");
        Assert.assertEquals(today.format(date), SearchPage.getDepartureDate());
        testPassed = true;
    }

    @Test
    public void changeDepartureDate() throws InterruptedException, IOException {
        SearchPage.setDate("March 2015", "8");
        Assert.assertEquals("03.08.2015", SearchPage.getDepartureDatefromBtnSearch());
        testPassed = true;
    }


}
