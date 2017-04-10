package com.demo.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

public class DriverFactory {

    public static WebDriver setDriver(DriverType type){
        HashMap<DriverType , WebDriver> map = new HashMap<DriverType , WebDriver>();
        map.put(DriverType.FireFox, new FirefoxDriver());

        return map.get(type);
    }

}
