package id.co.noz.adzantime.types;

/**
 * Created by CLient-PC on 31/07/2017.
 */

public enum PrayersType {
    FAJR(0),
    SUNRISE(1),
    ZUHR(2),
    ASR(3),
    MAGHRIB(4),
    ISHA(5);
    private int index;

    public int getIndex() {
        return index;
    }

    PrayersType(int index) {
        this.index = index;
    }
}
