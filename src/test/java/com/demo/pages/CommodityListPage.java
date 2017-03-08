package com.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommodityListPage {
    @FindBy(css = ".grid-container.row .img-box")
    private WebElement firstItem;


    public void selectFirstItem(){
        firstItem.click();
    }


}
