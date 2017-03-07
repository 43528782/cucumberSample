package com.demo.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by dujuan on 3/5/17.
 */

//should be put in the same package with .feature files.
public class DemoTest {
    private static FirefoxDriver driver = new FirefoxDriver();

    @Given("^I am on Tobao$")
    public void gotoTaobao(){
        driver.get("http://www.taobao.com");
    }


    @When("^I put \"(.*)\" into the search box$")
    public void iPutDianFanBaoIntoTheSearchBox(String name) throws Throwable {
        driver.findElementById("q").sendKeys(name);
    }

    @And("^I select the 1st result$")
    public void iSelectTheStResult() throws Throwable {
        driver.findElementByCssSelector("#J_TSearchForm > div.search-button > button").click();
        driver.findElementByCssSelector("#spulist-grid > div > div > div:nth-child(1) > div > div.info-cont > div.title-row > a").click();

    }


    private void switchHandle(){
        //handler1
        String handle = driver.getWindowHandle();

        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle))
                continue;
            driver.switchTo().window(handles);
        }
    }


    @Then("^go to details page I will see the price is as same as the previous page$")
    public void goToDetailsPageIWillSeeThePriceIsAsSameAsThePreviousPage() throws Throwable {
        this.switchHandle();
        String priceOne = driver.findElementByCssSelector("#J_itemlistListItem0 > div.col.col-3 > div.price-row > span > strong").getText();
        driver.findElementByCssSelector("#J_itemlistListItem0 > div.col.col-1 > div > div > div.pic.J_MouseEneterLeave.J_ThumbPopup > a > img").click();
        this.switchHandle();
        assertEquals(priceOne, driver.findElementByCssSelector("#J_DetailMeta > div.tm-clear > div.tb-property > div > div.tm-fcs-panel > dl.tm-happy11-panel > dd > span").getText());

    }
}

//plugs : gherkin, cucumber for java