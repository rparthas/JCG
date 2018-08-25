package com.jcg.selenium;

import java.io.BufferedReader;
import java.io.FileReader;

public class KeywordExecutor {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            KeywordService keywordService = new KeywordService();
            String newLine = br.readLine();
            while ((newLine = br.readLine()) != null) {
                System.out.println("Executing command:"+newLine);
                String[] commandLine = newLine.split(",");
                String command = commandLine[0];
                switch (command.toUpperCase()) {
                    case Keywords.OPEN_BROWSER:
                        String browserName = commandLine[1];
                        keywordService.openBrowser(browserName);
                        break;
                    case Keywords.OPEN_URL:
                        keywordService.openUrl(commandLine[3]);
                        break;
                    case Keywords.ENTER_TEXT:
                        keywordService.enterText(commandLine[1],commandLine[2],commandLine[3]);
                        break;
                    case Keywords.CLICK_AT:
                        keywordService.clickOnLocator(commandLine[1],commandLine[2]);
                        break;
                    case Keywords.CLOSE_BROWSER:
                        keywordService.closeBrowser();
                        break;
                    case Keywords.VERIFY_VALUE:
                        boolean success =keywordService.verify(commandLine[1],commandLine[2],commandLine[3],commandLine[4]);
                        if(!success){
                            throw new Exception("Verify failed for["+command+"]");
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }


    }
}
