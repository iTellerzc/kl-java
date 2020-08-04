package com.kl.java.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author iTeller_zc
 * date:2020/4/12
 * description:
 */
public class LogbackMain {

    private static final Logger LOGGER =  LoggerFactory.getLogger(LogbackMain.class);

    public static void main(String[] args){
        LOGGER.info("this is log test!");
    }
}
