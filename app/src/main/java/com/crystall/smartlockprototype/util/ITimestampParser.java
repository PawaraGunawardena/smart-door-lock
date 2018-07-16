package com.crystall.smartlockprototype.util;

public interface ITimestampParser {

    /**
     * Parses the timestamp value.
     * @param timestamp
     * @return a ParsedDate bean.
     */
   ParsedDate parse(String timestamp);

    /**
     * Gets the current timestamp
     * @return the current timestamp
     */
    String storeTimeStamp();

}
