package com.jcg.examples;

import org.apache.log4j.Logger;

public class LoggerMain {

	public static final Logger logger = Logger.getLogger(LoggerMain.class);

	public static void main(String[] args) {
		int loop = 0;
		while (loop < 100) {
			logger.warn("This is a warn log");
			loop++;
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				logger.error("Error occurred in sleep", e);
				Thread.currentThread().interrupt();
			}
		}
	}

}
