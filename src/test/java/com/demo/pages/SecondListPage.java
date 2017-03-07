package com.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by dujuan on 3/6/17.
 */
public class SecondListPage {
    @FindBy(css = "#J_itemlistListItem0 > div.col.col-3 > div.price-row > span > strong")
    private WebElement priceOntheList;

    @FindBy(css = "#J_itemlistListItem0 img")
    private WebElement target;

    public String getPriceOnTheList() { return priceOntheList.getText();}

    public void clickToGoToDetailPage(){ target.click();}

}


