package com.jcg.logbackappender;


import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;

public class MapAppender extends AppenderBase<LoggingEvent> {

    MapHolder holder = MapHolder.create();

    @Override
    protected void append(LoggingEvent event) {
        holder.putEvent(String.valueOf(System.nanoTime()), event.getMessage());
    }

}
