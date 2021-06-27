import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
// Broken links using Selenium
public class BorkenLinksSelenium {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Drivers2\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");

        List<WebElement> links= driver.findElements(By.xpath("//a"));
        System.out.println("the total number of links is: "+links.size());
        // go to each link and verify href att is not empty

        int n=0;
        for (int i=0; i<links.size(); i++){
            String href=(links.get(i).getAttribute("href"));
            if (href.isEmpty()){
                n=n+1;
                String linkname= links.get(i).getText();
                System.out.println(linkname+ "  is broken");
            }
        }
        System.out.println("there is "+n+ " broken links");

    }
}
