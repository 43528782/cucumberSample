package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private WebElement searchBox;
    private WebElement searchButton;

    public HomePage(WebDriver webDriver) {
        this.driver = webDriver;
}

    public void searchItem(String item){
        searchBox = driver.findElement(By.id("q"));
        searchButton = driver.findElement(By.cssSelector(".btn-search"));  //这种方式定位元素是最快的
        searchBox.sendKeys(item);
        searchButton.click();
    }


}
