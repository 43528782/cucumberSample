package com.demo.steps;

import com.demo.pages.CommodityListPage;
import com.demo.pages.DetailsPage;
import com.demo.pages.HomePage;
import com.demo.pages.SecondListPage;
import com.demo.util.DriverFactory;
import com.demo.util.DriverType;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


/**
 * Created by dujuan on 3/6/17.
 */
public class SearchStep {

    private WebDriver driver = DriverFactory.setDriver(DriverType.FireFox);
    //方便元素管理,实现元素公用,提高代码的可读性(封装了元素以及针对它的处理)
    private HomePage homePage = new HomePage(driver);

//    private HomePage homePage= PageFactory.initElements(driver, HomePage.class);
    private CommodityListPage commodityListPage = PageFactory.initElements(driver,CommodityListPage.class);
    private SecondListPage secondListPage = PageFactory.initElements(driver,SecondListPage.class);
    private DetailsPage detailsPage = PageFactory.initElements(driver, DetailsPage.class);

    //增强测试稳定性的方式
    @Before
    public void beforeScenario(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.write(scenario.getName() + " scenario fails, current URL is" + driver.getCurrentUrl());
            scenario.embed(screenshot, "image/png");
        }
        //清理测试现场: 删除cookies避免上次操作的参与信息影响下面的测试 以及关闭浏览器
        driver.manage().deleteAllCookies();
        driver.quit();
    }


    @Given("^I am on Tobao page$")
    public void gotoTaobao(){
        driver.get("http://www.taobao.com");
    }


    @When("^I am searching \"(.*)\"$")
    public void iPutDianFanBaoIntoTheSearchBox(String item) {
         homePage.searchItem(item);
    }

    @And("^I select the 1st item of the results$")
    public void iSelectTheStItem() {
        commodityListPage.selectFirstItem();
    }


    @Then("^On the details page I will see the price is equal to previous page$")
    public void goToDetailsPageIWillSeeThePriceIsAsSameAsThePreviousPage() {
        this.switchHandle();

        String originalPrice = secondListPage.getPriceOnTheList();
        secondListPage.clickToGoToDetailPage();

        this.switchHandle();

        assertEquals(originalPrice, detailsPage.actualPrice());
    }


    private void switchHandle(){
        String handle = driver.getWindowHandle();

        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle))
                continue;
            driver.switchTo().window(handles);
        }
    }

}
