package com.demo.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

public class DriverFactory {

    static {
        System.setProperty("webdriver.chrome.driver", "/Users/xiaoxu/Downloads/chromedriver");

    }

    public static WebDriver setDriver(DriverType type){

        switch (type){
            case FireFox:
                return new FirefoxDriver();
            case Chrome:
                return new ChromeDriver();
            default:
                return null;
        }
    }



}
