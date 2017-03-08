package com.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsPage {
    @FindBy(css = "#J_PromoPrice span.tm-price")
    private WebElement price;

    public String actualPrice(){ return price.getText();}

}
