package com.crystall.smartlockprototype.util;

public interface ITimestampParser {

    /**
     * Parses the timestamp value.
     * @param timestamp
     * @return map with date and time.
     */
   ParsedDate parse(String timestamp);

    /**
     * Gets the current timestamp
     * @return the current timestamp
     */
    String storeTimeStamp();

}
