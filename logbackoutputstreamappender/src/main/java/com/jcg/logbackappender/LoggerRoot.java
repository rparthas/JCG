package com.jcg.logbackappender;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.stream.IntStream;

public class LoggerRoot {
    private static final Logger logger = LoggerFactory.getLogger(LoggerRoot.class.getSimpleName());
    public static void main(String... args){
        IntStream.rangeClosed(1,10).forEach(counter->{
            logger.info("Counter:" + counter);
        });
    }
}
