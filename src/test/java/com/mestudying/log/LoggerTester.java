package com.mestudying.log;

import org.apache.log4j.Logger;
import org.apache.log4j.NDC;
import org.apache.log4j.lf5.DefaultLF5Configurator;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by junweizhang on 17/4/8.
 */
public class LoggerTester {

    public static final String DEBUG_KEY="log4j.debug";

    @BeforeClass
    public static void setUp(){
        System.setProperty(DEBUG_KEY, "true");
    }

    @Test
    public void testLogger(){
        try {
            DefaultLF5Configurator.configure();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger logger01 = Logger.getLogger(LoggerTester.class);
        logger01.info("It is a test log...");
        logger01.info("It is a test log...");
    }

    @Test
    public void testLf5Logger(){
        try {
            DefaultLF5Configurator.configure();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger logger01 = Logger.getRootLogger();
        logger01.info("It is a test log...");
        logger01.info("It is a test log...");
    }

    @Test
    public void testSMTP(){
        Logger logger01 = Logger.getLogger(LoggerTester.class);
        logger01.error("It is a test log...");
    }

    @Test
    public void testRollFile(){
        Logger logger01 = Logger.getLogger(LoggerTester.class);
        for(int i = 0; i < 100; i++){
            logger01.info("It is a test log...");
        }
    }

    @Test
    public void testNDC(){
        NDC.push("thread context 001.");
        Logger logger01 = Logger.getLogger(LoggerTester.class);
        logger01.info("I am a NDC msg...");
        NDC.pop();
        logger01.info("NDC pop...");
    }

}
