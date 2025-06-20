package lt.techin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/prisijungti");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
//    @AfterEach
//    public void afterEach(){
//        if(driver != null){
//            driver.quit();
//        }
//    }

}

