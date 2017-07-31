package id.co.noz.adzantime;

import java.util.Date;

import id.co.noz.adzantime.types.PrayersType;

import static id.co.noz.adzantime.Constants.MILLIS_IN_SECOND;
import static id.co.noz.adzantime.Constants.MINUTE_IN_HOUR;
import static id.co.noz.adzantime.Constants.SECOND_IN_MINUTE;
import static id.co.noz.adzantime.types.PrayersType.ASR;
import static id.co.noz.adzantime.types.PrayersType.MAGHRIB;
import static id.co.noz.adzantime.types.PrayersType.SUNRISE;
import static id.co.noz.adzantime.types.PrayersType.ZUHR;
import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Math.ceil;

/**
 * Created by CLient-PC on 31/07/2017.
 */

public class PrayerTimes {

    private boolean useSecond = false;
    private double[] prayerTimes;
    private long millis;

    PrayerTimes(long millis, double... prayerTimes) {
        this.prayerTimes = prayerTimes;
        this.millis = millis;
        if (prayerTimes[SUNRISE.getIndex()] == NEGATIVE_INFINITY || prayerTimes[MAGHRIB.getIndex()] == POSITIVE_INFINITY) {
            prayerTimes[ZUHR.getIndex()] = POSITIVE_INFINITY;
            prayerTimes[ASR.getIndex()] = POSITIVE_INFINITY;
        }
    }

    public Date getPrayTime(PrayersType payersType) {
        double time = prayerTimes[payersType.getIndex()];
        if (time == POSITIVE_INFINITY || time == NEGATIVE_INFINITY) {
            return null;
        }
        // negative hours will raise exception
        if (isUseSecond())
            return new Date(this.millis + (long) ceil(time * MINUTE_IN_HOUR * SECOND_IN_MINUTE) * MILLIS_IN_SECOND);
        else
            return new Date(this.millis + (long) ceil(time * MINUTE_IN_HOUR) * SECOND_IN_MINUTE * MILLIS_IN_SECOND);
    }

    public Time getTimeinHoursAndMinutesAndSecounds(int timeName) {
        double time = prayerTimes[timeName];
        if (time == POSITIVE_INFINITY || time == NEGATIVE_INFINITY)
            return null;
        if (isUseSecond())
            return new Time(time);
        else
            return new Time(ceil(time * MINUTE_IN_HOUR) / SECOND_IN_MINUTE);
    }

    /**
     * Whether second is used, if not it will be zero and minute is rounded to the top (ceil).
     */
    public boolean isUseSecond() {
        return useSecond;
    }

    public void setUseSecond(boolean useSecond) {
        this.useSecond = useSecond;
    }

}
