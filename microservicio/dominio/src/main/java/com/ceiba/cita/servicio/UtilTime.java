package com.ceiba.cita.servicio;

import java.time.LocalTime;

public class UtilTime {

    private static final LocalTime CONS_MIDNIGHT = LocalTime.parse("23:59:59");
    private static final LocalTime CONS_DAY = LocalTime.parse("00:00:00");
    private static LocalTime CONS_START_DAY = LocalTime.parse("06:00:00");
    private static LocalTime CONS_END_DAY = LocalTime.parse("18:00:00");
    private static LocalTime CONS_START_NIGHT = LocalTime.parse("20:00:00");
    private static LocalTime CONS_END_NIGHT = LocalTime.parse("04:00:00");

    public static boolean checkAllRangeTime(LocalTime dateTime) {
        if (dateTime == null) {
            throw new IllegalArgumentException("Tiempo no puede ser nulo");
        }
        boolean isInsideRangeDayTime = checkRangeDayTime(dateTime, CONS_START_DAY, CONS_END_DAY);
        boolean isInsideRangeNightTime = checkRangeNightTime(dateTime, CONS_START_NIGHT, CONS_END_NIGHT);
        return isInsideRangeDayTime || isInsideRangeNightTime ?
                true : false;
    }

    private static boolean checkRangeDayTime(LocalTime dateTime, LocalTime startRange, LocalTime endRange) {
        return checkRange(dateTime, startRange, endRange);
    }

    private static boolean checkRangeNightTime(LocalTime dateTime, LocalTime startRange, LocalTime endRange) {
        boolean isNightSchedule = checkRange(dateTime, startRange, CONS_MIDNIGHT);
        boolean isDaySchedule = checkRange(dateTime, CONS_DAY, endRange);
        return isNightSchedule || isDaySchedule;
    }

    private static boolean checkRange(LocalTime dateTime, LocalTime startRange, LocalTime endRange) {
        int startValue = dateTime.compareTo(startRange);
        int endValue = dateTime.compareTo(endRange);

        boolean isInsideRangeStart = startValue > 0 || startValue == 0;
        boolean isInsideRangeEnd = endValue < 0 || endValue == 0;

        return isInsideRangeStart && isInsideRangeEnd ? true : false;
    }
}
