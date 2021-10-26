package utilities;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

    public static WebDriver driver;
    @BeforeClass
    @Parameters({"url" , "browserType"})
    public void setUp(String url,String browserType) throws InterruptedException {
        //reportsObj=new ReportsUtil();
        driver = getInstance(browserType);
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
    }


    /* This method is used to Load Drivers*/
    public static WebDriver getInstance(String browserType) {

        switch (browserType) {

            case "chrome":
                WebDriverManager.chromedriver().setup();;
                driver = new ChromeDriver();
                break;
            case "IE":
                WebDriverManager.iedriver().setup();;
                driver = new InternetExplorerDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();;
                driver = new FirefoxDriver();
                break;
        }

        return driver;

    }
    @AfterClass
    public void flush() {
    	driver.quit();
    }
}
