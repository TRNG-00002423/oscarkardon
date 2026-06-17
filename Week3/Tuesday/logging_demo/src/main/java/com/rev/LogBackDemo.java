package com.rev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBackDemo {
    private static final Logger logger = LoggerFactory.getLogger(LogBackDemo.class);

    public static void main(String[] args) {
        logger.info("Application Started.....");
        try{
            int result =  100 / 0;
        } catch(ArithmeticException e){
            logger.error("An arithmetic exception occured" + e);
        } finally{
            logger.info("Exception handled");
        }
        logger.trace("Detail info");
        logger.debug("Debugging");
        logger.warn("warning messages");
        logger.info("Application executed");
        logger.error("Error messages");
    }   
}