import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by dujuan on 3/4/17.
 */
public class Demo {

        private static FirefoxDriver driver = new FirefoxDriver();

        @Before
        public void setEnv(){
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

        @Test
        public void open (){

                driver.get("http://www.taobao.com");
                driver.findElementById("q").sendKeys("电饭煲");
                //此处可以用谷歌浏览器的 copy 功能..呵呵
                driver.findElementByCssSelector("#J_TSearchForm > div.search-button > button").click();
                driver.findElementByCssSelector("#spulist-grid > div > div > div:nth-child(1) > div > div.info-cont > div.title-row > a").click();

                //handler1
               this.switchHandle();

                String priceOne = driver.findElementByCssSelector("#J_itemlistListItem0 > div.col.col-3 > div.price-row > span > strong").getText();
                driver.findElementByCssSelector("#J_itemlistListItem0 > div.col.col-1 > div > div > div.pic.J_MouseEneterLeave.J_ThumbPopup > a > img").click();

                this.switchHandle();
                assertEquals(priceOne, driver.findElementByCssSelector("#J_DetailMeta > div.tm-clear > div.tb-property > div > div.tm-fcs-panel > dl.tm-happy11-panel > dd > span").getText()
);

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

}
