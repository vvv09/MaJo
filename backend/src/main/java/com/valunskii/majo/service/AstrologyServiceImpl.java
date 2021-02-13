package com.valunskii.majo.service;

import com.luckycatlabs.sunrisesunset.SunriseSunsetCalculator;
import com.luckycatlabs.sunrisesunset.dto.Location;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

@Service
public class AstrologyServiceImpl implements AstrologyService{

    @Override
    public Map<String, String> getAllAstroData(String date, double lantitude, double longitude) {
        Location location = new Location(lantitude, longitude);
        SunriseSunsetCalculator calculator = new SunriseSunsetCalculator(location, "Europe/Moscow");

//        String officialSunrise = calculator.getOfficialSunriseForDate(Calendar.getInstance());
//        String officialSunset = calculator.getOfficialSunsetForDate(Calendar.getInstance());

//        Calendar[] sunriseSunset =
//                ca.rmen.sunrisesunset.SunriseSunset
//                        .getSunriseSunset(getDate(date), lantitude, longitude);
        Calendar calendar = getDate(date);
        return Map.of(
                "date", getDateString(calendar),
                "place", calendar.getTimeZone().toString(),
                "sunrise", calculator.getOfficialSunriseForDate(calendar),
                "sunset", calculator.getOfficialSunsetForDate(calendar),
                "moonphase", "not yet");
    }

    private Calendar getDate(String date) {
        String[] dateParts = date.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);
        Calendar calendar =  new GregorianCalendar(year, month, day);
        System.out.println(calendar.get(Calendar.YEAR)); // 01
        System.out.println(calendar.get(Calendar.MONTH)); // 01
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); // 01
        return calendar;
    }

    private String getDateString(Calendar calendar) {
        StringBuilder result = new StringBuilder();
        result.append(calendar.get(Calendar.YEAR) + "-");
        result.append(calendar.get(Calendar.MONTH) + "-");
        result.append(calendar.get(Calendar.DAY_OF_MONTH));
        return result.toString();
    }
}
