import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class PlannerSettings {

    static WebDriver driver;

    public String login = "gerardkunze";
    public String password = "123456";

    public String property = "webdriver.chrome.driver";
    public String property2 = "/home/raltynbaev/chromedriver";

    public static void captureScreenshot(WebDriver driver) {
        try {
            Date date = new Date();
            TakesScreenshot ts = (TakesScreenshot) driver;
            File sources = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sources, new File("/home/raltynbaev/IdeaProjects/PlannerTest/target/screenshots/screenshots" + date + ".png"));
            System.out.println("Screenshot taken");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }

    public void loadBrowser() {
        final String site = "https://planner-sandbox.dev.thumbtack.net/accounts/login/";

        System.setProperty(property, property2);
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("headless");

        driver = new ChromeDriver(options);
        driver.get(site);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void testUrl(){

        try {
            URL url = new URL("https://planner-sandbox.dev.thumbtack.net/accounts/login/");
            URLConnection conn = url.openConnection();
            conn.connect();

        }
        catch (MalformedURLException e) {
            System.out.println("yoy2");
        }
        catch (IOException e) {
            System.out.println("yoy");
        }
    }

    public void closeDriver(){
        driver.close();
    }
}
