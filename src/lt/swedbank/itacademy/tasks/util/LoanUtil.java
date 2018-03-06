package lt.swedbank.itacademy.tasks.util;

import lt.swedbank.itacademy.tasks.domain.VehicleLoan;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lukas
 */
public class LoanUtil {

    //TODO incorrect calculation
    public static BigDecimal calculateVehicleDepreciation(VehicleLoan loan){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date todayDate = DateUtil.getDateFromString(df.format(new Date()));

        long differenceInDays = DateUtil.differenceInDays(todayDate, loan.getManufactured());

        BigDecimal yearsInUse = new BigDecimal(differenceInDays).divide(new BigDecimal(365), 4, RoundingMode.HALF_UP);
        return loan.getPrice().multiply(yearsInUse).divide(new BigDecimal(loan.getMaximumAge()), RoundingMode.HALF_UP);
    }
}
