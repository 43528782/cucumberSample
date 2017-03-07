package com.demo.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

public class DriverFactory {

    public static WebDriver setDriver(DriverType type){
        //我用的是 tm 的 hash map, 也就是尼玛键值对这种方式来代替 if else
        //站到代码的角度来说的话,代码里面如果 if else 之类的东西比较多的话逻辑略显复杂,不容易读懂,而且容易读错,单元测试覆盖率也烦
        //所以用键值对来代替这东西.是一个比较体现 B 格的做法
        //如果需要增加其他的 driver 的话就增加 map.put(xxxx) 就行了
        HashMap<DriverType , WebDriver> map = new HashMap<DriverType , WebDriver>();

        map.put(DriverType.FireFox, new FirefoxDriver());
        return map.get(type);
    }

}
