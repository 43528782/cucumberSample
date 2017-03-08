package com.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(id = "q")
    private WebElement searchBox;  //    WebElement searchBox = driver.findElemntByID("q");

    @FindBy(css = ".btn-search")  //这种方式定位元素是最快的
    private WebElement searchButton;

    public void searchItem(String item){
        searchBox.sendKeys(item);
        searchButton.click();
    }


}
