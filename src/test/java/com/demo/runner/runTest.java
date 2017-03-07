package com.demo.runner;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

/**
 * Created by dujuan on 3/5/17.
 */
@RunWith(Cucumber.class)  //initiate run time environment for cucumber
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"}, //报告的风格, 报告的格式
        glue = "com.demo.steps",
        features = "src/test/resources/com.demo/",
        tags = {"@demo1"})
public class runTest {
}
