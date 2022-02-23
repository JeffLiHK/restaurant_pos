package pkpd.restaurant.utils;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class SplitIdsUtilTest {

    @Test
    @Ignore
    public void splitStrIds() {
        List<Long> ids = SplitIdsUtil.splitStrIds("3,13,16,");
       for(Long id:ids){
           System.out.println(id);
       }
    }
}