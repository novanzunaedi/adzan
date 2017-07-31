package id.co.noz.adzan.time;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.GregorianCalendar;

import id.co.noz.adzantime.PrayerTimes;
import id.co.noz.adzantime.TimeCalculator;
import id.co.noz.adzantime.types.PrayersType;

import static id.co.noz.adzantime.types.AngleCalculationType.MUHAMMADIYAH;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        azan();
    }

    public void azan() {
        GregorianCalendar date = new GregorianCalendar();
        System.out.println(date.getTimeInMillis());
        PrayerTimes prayerTimes = new TimeCalculator().date(date).location(-7.286569, 112.7492528,
                0, 0).timeCalculationMethod(MUHAMMADIYAH).umElQuraRamadanAdjustment(false).calculateTimes();
        prayerTimes.setUseSecond(true);
        System.out.println("TIME ----------------------------------------");
        System.out.println("TIME Fajr ---> " + prayerTimes.getPrayTime(PrayersType.FAJR));
        System.out.println("TIME sunrise --->" + prayerTimes.getPrayTime(PrayersType.SUNRISE));
        System.out.println("TIME Zuhr --->" + prayerTimes.getPrayTime(PrayersType.ZUHR));
        System.out.println("TIME Asr --->" + prayerTimes.getPrayTime(PrayersType.ASR));
        System.out.println("TIME Maghrib --->" + prayerTimes.getPrayTime(PrayersType.MAGHRIB));
        System.out.println("TIME ISHA  --->" + prayerTimes.getPrayTime(PrayersType.ISHA));
        System.out.println("TIME ----------------------------------------");
    }


}
