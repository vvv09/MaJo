package com.valunskii.majo.service;


import org.shredzone.commons.suncalc.MoonPhase;
import org.shredzone.commons.suncalc.SunTimes;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

@Service
public class AstrologyServiceImpl implements AstrologyService{

    @Override
    public Map<String, String> getAllAstroData(String date) {
        //https://www.gps-latitude-longitude.com/gps-coordinates-of-Sankt-Ptrburg
        //HARDCODED for Saint Petersburg Russia
        final double LANTITUDE = 59.9342802;
        final double LONGITUDE = 30.3350986;
        ZoneId timeZone = ZoneId.of("Europe/Moscow");

        date = date  + "T00:00:00";
        ZonedDateTime dateTime = LocalDateTime.parse(date,
                DateTimeFormatter.ISO_DATE_TIME).atZone(timeZone);

        SunTimes times = SunTimes.compute()
                .on(dateTime)   // set a date
                .at(LANTITUDE, LONGITUDE)   // set a location
                .execute();     // get the results

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = dateTime.format(formatter);

        return Map.of(
                "date", formattedDate,
                "sunrise", times.getRise().format(DateTimeFormatter.ofPattern("HH:mm")),
                "sunset", times.getSet().format(DateTimeFormatter.ofPattern("HH:mm")),
                "moonphase", "not impl yet"
        );
    }

    private Calendar getDate(String date) {
        String[] dateParts = date.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);
        Calendar calendar =  new GregorianCalendar(year, month, day);
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
