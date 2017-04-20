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
        HashMap<DriverType , WebDriver> map = new HashMap<DriverType , WebDriver>();
        map.put(DriverType.FireFox, new FirefoxDriver());
        map.put(DriverType.Chrome,new ChromeDriver());

        return map.get(type);
    }



}
