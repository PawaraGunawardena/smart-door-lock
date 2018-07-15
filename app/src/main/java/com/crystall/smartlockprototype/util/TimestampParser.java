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
    public Map<String, String> parse(String timestamp) {
        String[] splitted = timestamp.split("\\\\s+");
        Map<String, String > map = new HashMap<>();
        map.put("date", splitted[0]);
        map.put("time", splitted[1]);
        return map;
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
