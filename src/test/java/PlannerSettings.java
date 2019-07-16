import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.util.Date;


public class PlannerSettings {

    static WebDriver driver;
    public String login = "gerardkunze";
    public String password = "123456";
    public String site = "https://planner-sandbox.dev.thumbtack.net/accounts/login/";
    public String property = "webdriver.chrome.driver";
    public String property2 = "/home/raltynbaev/chromedriver";

    public static void captureScreenshot(WebDriver driver)
    {
        try
        {
            Date date = new Date();
            TakesScreenshot ts = (TakesScreenshot)driver;
            File sources = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sources, new File("/home/raltynbaev/IdeaProjects/PlannerTest/target/screenshots/screenshots" + date + ".png"));
            System.out.println("Screenshot taken");
        }
        catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }

}





