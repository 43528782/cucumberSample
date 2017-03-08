package com.demo.runner;

import com.cucumber.listener.ExtentCucumberFormatter;
import com.relevantcodes.extentreports.NetworkMode;
import cucumber.api.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

import java.io.File;
import java.util.Date;


@RunWith(Cucumber.class)  //initiate run time environment for cucumber
@CucumberOptions(
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter"},
        glue = "com.demo.steps",
        features = "src/test/resources/com.demo/",
        tags = {"@demo1"})
public class runTest {
    /**
     * @see <a herf="https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#dt">Date/Time</a>
     */
    private static final String REPORT_PATH = "target/cucumber/%1$tY-%1$tm-%1$td-%1$tH-%1$tM-%1$tS/report.html";

    @BeforeClass
    public static void  setup(){
        String reportPath = String.format(REPORT_PATH, new Date());
        ExtentCucumberFormatter.initiateExtentCucumberFormatter(new File(reportPath),false, NetworkMode.OFFLINE);
    }
}
