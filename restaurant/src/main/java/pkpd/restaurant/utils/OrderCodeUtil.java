package pkpd.restaurant.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class OrderCodeUtil {
    public static String createOrderCode(){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MMdd-HHmm-ss-SSS");
        Date date = new Date();
        return sf.format(date);
    }
}
