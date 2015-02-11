import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

/**
 * Created by user on 2/11/15.
 */
@RunWith(JUnit4.class)
public class BookingUzTests extends BaseTest{

    @Test
    public void searchKyivIF() throws InterruptedException, IOException {
        //SearchPage.setfield("From", "Kyiv");
        //SearchPage.setfield("To", "Kyiv");
        SearchPage.setDate("March 2015", "11");//March 2015
        testPassed = true;
    }


}
