package com.crystall.smartlockprototype.util;

import java.util.Date;
import java.util.Map;

public interface ITimestampParser {

    /**
     * Parses the timestamp value.
     * @param timestamp
     * @return map with date and time.
     */
    Map<String, String> parse(String timestamp);

    /**
     * Gets the current timestamp
     * @return the current timestamp
     */
    String storeTimeStamp();

}
