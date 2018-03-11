package com.jcg.examples;

import org.apache.log4j.Logger;

import java.util.stream.IntStream;

public class LoggerMain {

    public static final Logger logger = Logger.getLogger(LoggerMain.class);

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10000).forEach(count -> {
                    logger.warn("This is a warn log");
                }
        );
    }

}
