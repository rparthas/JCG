package com.jcg.dateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatExample {

    public static void main(String[] args) {
        Date now = new Date();
        System.out.println("String version of Date. " + now.toString());
        System.out.println("DateTimeWithShort. " + DateFormat.getInstance().format(now));
        System.out.println("TimeWithMedium. " + DateFormat.getTimeInstance().format(now));
        System.out.println("DateTimeWithMedium. " + DateFormat.getDateTimeInstance().format(now));
        System.out.println("TimeWithShort . " + DateFormat.getTimeInstance(DateFormat.SHORT).format(now));
        System.out.println("TimeWithLong. " + DateFormat.getTimeInstance(DateFormat.LONG).format(now));
        System.out.println("DTML. " + DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.LONG).format(now));
        System.out.println("DTMF. " + DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.FULL).format(now));
        System.out.println("DTLL. " + DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(now));
        System.out.println("DTLF. " + DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.FULL).format(now));

        try {
            DateFormat format = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
            Date parsedDate = format.parse("22/6/19 10:43 PM");
            Calendar cal = Calendar.getInstance();
            cal.setTime(parsedDate);
            cal.add(Calendar.DATE, 5);
            System.out.println("Date Result. " + cal.getTime().toString());

            System.out.println(new SimpleDateFormat("G").format(now));
            System.out.println(new SimpleDateFormat("y").format(now));
            System.out.println(new SimpleDateFormat("yyyyyy").format(now));
            System.out.println(new SimpleDateFormat("dd").format(now));
            System.out.println(new SimpleDateFormat("hhhh").format(now));
            System.out.println(new SimpleDateFormat("H").format(now));
            cal.add(Calendar.HOUR, -22);
            System.out.println(new SimpleDateFormat("E").format(cal.getTime()));
            System.out.println(new SimpleDateFormat("DDDD").format(cal.getTime()));
            System.out.println(new SimpleDateFormat("F").format(cal.getTime()));
            System.out.println(new SimpleDateFormat("w").format(cal.getTime()));
            System.out.println(new SimpleDateFormat("W").format(cal.getTime()));
            System.out.println(new SimpleDateFormat("a").format(cal.getTime()));
            System.out.println(new SimpleDateFormat("z").format(cal.getTime()));
            System.out.println(new SimpleDateFormat("zz").format(cal.getTime()));
            System.out.println(new SimpleDateFormat("zzzzz").format(cal.getTime()));
            System.out.println(new SimpleDateFormat("SSS").format(cal.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            DateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy G hh:mm:SS zzz");
            String result = simpleDateFormat.format(now);
            System.out.println("Date String "+result);
            System.out.println("ParsedResult "+simpleDateFormat.parse(result));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}


