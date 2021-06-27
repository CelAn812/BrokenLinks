import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static io.restassured.RestAssured.given;
// Broken links using API and selenium
public class APITestingSelenium {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Drivers2\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");

        List<WebElement> links = driver.findElements(By.xpath("//a"));
        System.out.println("the total number of links is: " + links.size());
        for (int i=0; i<links.size(); i++) {
            String href = (links.get(i).getAttribute("href"));
            int statuscode= given().when().get(href).then().extract().statusCode();
            String name= links.get(i).getText();
            if(statuscode==200){
                System.out.println("The link "+name+" is working");
            }else{
                System.out.println("The link "+name+" is not working");
            }
        }
    }
}
