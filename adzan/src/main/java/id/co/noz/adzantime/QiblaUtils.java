package id.co.noz.adzantime;

import static id.co.noz.adzantime.Constants.KAABA_LATITUDE;
import static id.co.noz.adzantime.Constants.KAABA_LONGITUDE;
import static id.co.noz.adzantime.Constants.TOTAL_DEGREES;
import static id.co.noz.adzantime.util.MathUtil.atan2Deg;
import static id.co.noz.adzantime.util.MathUtil.cosDeg;
import static id.co.noz.adzantime.util.MathUtil.sinDeg;
import static id.co.noz.adzantime.util.MathUtil.tanDeg;

/**
 * Created by CLient-PC on 31/07/2017.
 */

public class QiblaUtils {

    /**
     * Return qibla direction in degrees from the north (clock-wise).
     *
     * @param latitude  latitude in degrees
     * @param longitude longitude in degrees
     * @return 0 means north, 90 means east, 270 means west, etc
     */
    public static double qibla(double latitude, double longitude) {
        double degrees = atan2Deg(sinDeg(KAABA_LONGITUDE - longitude),
                cosDeg(latitude) * tanDeg(KAABA_LATITUDE)
                        - sinDeg(latitude) * cosDeg(KAABA_LONGITUDE - longitude));
        return degrees >= 0 ? degrees : degrees + TOTAL_DEGREES;
    }
}
