package com.crystall.smartlockprototype.util;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TimestampParser implements ITimestampParser{

    /**
     * Parses the timestamp value.
     * @param timestamp
     * @return map with date and time.
     */
    @Override
    public ParsedDate parse(String timestamp) {
        String[] splitted = timestamp.split("\\\\s+");
        ParsedDate parsedDate = new ParsedDate();
        parsedDate.setDate(splitted[0]);
        parsedDate.setTime(splitted[1]);
        return parsedDate;
    }

    /**
     * Prepare the current timestamp to store
     * @return parsable current timestamp
     */
    @SuppressLint("SimpleDateFormat")
    @Override
    public String storeTimeStamp() {
        return (new SimpleDateFormat("dd-M-yyyy hh:mm:ss").format(new Date()));
    }

}
