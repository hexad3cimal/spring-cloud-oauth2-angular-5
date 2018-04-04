package com.jovin.usermodule.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by hexad3cimal on 18/3/18.
 */

@Component("TimeUtil")
public class TimeUtil {

    public Date parseToZonedDateTime(String date, String dateFormat, String timeZone) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        ZonedDateTime zonedDateTime = null;
        LocalDateTime dt = LocalDateTime.parse(date, formatter);
        if( timeZone == null || timeZone.isEmpty())
            zonedDateTime = dt.atZone(ZoneId.systemDefault());
        else
            zonedDateTime = dt.atZone(ZoneId.of(timeZone));


        return Date.from(zonedDateTime.toInstant());
    }
}
