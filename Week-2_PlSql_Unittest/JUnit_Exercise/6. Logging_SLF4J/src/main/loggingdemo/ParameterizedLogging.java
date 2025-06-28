
package com.mycompany.loggingdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogging {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLogging.class);

    public static void main(String[] args) {
        String username = "Shreesh";
        int attempts = 3;

        logger.info("User {} has tried to login {} times", username, attempts);
        logger.debug("Debug details: username={}, attempts={}", username, attempts);
    }
}