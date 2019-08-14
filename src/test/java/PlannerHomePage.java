import io.qameta.allure.Attachment;

import io.qameta.allure.Description;
import org.jbehave.core.annotations.When;
import org.junit.jupiter.api.*;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class PlannerHomePage extends PlannerSettings {

    @BeforeEach
    public void testSetup() {
        testUrl();
        loadBrowser();
    }

    @AfterEach
    public void ExitTests() {
        closeDriver();
    }

    @Test
    @DisplayName("Step00: Проверка на домашнюю страницу")
    public void Step00() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/span[1]/span[1]")).isDisplayed(); // find 
        //if (!"Planner".equals(driver.getTitle())) {
        // throw new IllegalStateException("//");
        captureScreenshot(driver);

    }

    @Test
    @Attachment
    @DisplayName("Step01: Ввод логина")
    @When("I open start page")
    public void Step01() {

        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/form[1]/div[1]/label[1]")).isDisplayed(); // find LDAP Username
        driver.findElement(By.id("id_username")).isDisplayed();
        driver.findElement(By.id("id_username")).sendKeys(login);
        captureScreenshot(driver);

    }

    @Test
    @DisplayName("Step02: Ввод пароля")
    public void Step02() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/form[1]/div[2]/label[1]")).isDisplayed(); // find LDAP Password
        driver.findElement(By.id("id_password")).isDisplayed();
        driver.findElement(By.id("id_password")).sendKeys(password);
        captureScreenshot(driver);
    }

    @Test
    @DisplayName("Step03: Ввод логина и пароля с дальнейшим входом")
    public void Step03() {
        driver.findElement(By.id("id_username")).isDisplayed();
        driver.findElement(By.id("id_username")).sendKeys(login);
        driver.findElement(By.id("id_password")).isDisplayed();
        driver.findElement(By.id("id_password")).sendKeys(password);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/form[1]/div[3]/button[1]")).isDisplayed(); // find Log in
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).isDisplayed();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(); // кнопка войти
        assertEquals("Skills - Gerard Kunze - TT Planner", driver.getTitle());
        captureScreenshot(driver);
    }

    @Test
    @DisplayName("Step04: Нажатие на иконку с выпадающим меню")
    public void Step04() {
        driver.findElement(By.id("id_username")).isDisplayed();
        driver.findElement(By.id("id_username")).sendKeys(login);
        driver.findElement(By.id("id_password")).isDisplayed();
        driver.findElement(By.id("id_password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).isDisplayed();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(); // кнопка войти
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/ul[1]/li[1]/a[1]/span[1]")).isDisplayed(); // find TT planner
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/header[@class='navbar']/div[@class='navbar__right-side']/div[2]")).isDisplayed();
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/header[@class='navbar']/div[@class='navbar__right-side']/div[2]")).click();
        captureScreenshot(driver);
    }

    @Test
    @DisplayName("Step05: выбираем из списка Профайл и попадаем в Организационную структуру")
    public void Step05() {
        driver.findElement(By.id("id_username")).isDisplayed();
        driver.findElement(By.id("id_username")).sendKeys(login);
        driver.findElement(By.id("id_password")).isDisplayed();
        driver.findElement(By.id("id_password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).isDisplayed();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(); // кнопка войти
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/header[@class='navbar']/div[@class='navbar__right-side']/div[2]")).isDisplayed();
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/header[@class='navbar']/div[@class='navbar__right-side']/div[2]")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Profile')]")).isDisplayed();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Profile')]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/a[1]")).isDisplayed(); // find org chart
        captureScreenshot(driver);

    }

    @Test
    @DisplayName("Step06: Из Организационной структуры переходим в График/Schedule")
    public void Step06() {
        driver.findElement(By.id("id_username")).isDisplayed();
        driver.findElement(By.id("id_username")).sendKeys(login);
        driver.findElement(By.id("id_password")).isDisplayed();
        driver.findElement(By.id("id_password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).isDisplayed();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(); // кнопка войти
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/header[@class='navbar']/div[@class='navbar__right-side']/div[2]")).isDisplayed();
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/header[@class='navbar']/div[@class='navbar__right-side']/div[2]")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Profile')]")).isDisplayed();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Profile')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Schedule')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Schedule')]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[1]")).isDisplayed(); // period start
        captureScreenshot(driver);

    }

    @Test
    @DisplayName("Step07: Из Организационной структуры переходим в Job titles")
    public void Step07() {

        driver.findElement(By.id("id_username")).isDisplayed();
        driver.findElement(By.id("id_username")).sendKeys(login);
        driver.findElement(By.id("id_password")).isDisplayed();
        driver.findElement(By.id("id_password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).isDisplayed();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(); // кнопка войти
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/header[@class='navbar']/div[@class='navbar__right-side']/div[2]")).isDisplayed();
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/header[@class='navbar']/div[@class='navbar__right-side']/div[2]")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Profile')]")).isDisplayed();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Profile')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Job Titles')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Job Titles')]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")).isDisplayed(); // Find "You don't have permissions to view Employee Titles"
        captureScreenshot(driver);

    }

    @Test
    @DisplayName("Step08: Переход из выпадающего списка в Скиллы")
    public void Step08() {

        driver.findElement(By.id("id_username")).isDisplayed();
        driver.findElement(By.id("id_username")).sendKeys(login);
        driver.findElement(By.id("id_password")).isDisplayed();
        driver.findElement(By.id("id_password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).isDisplayed();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(); // кнопка войти
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/header[@class='navbar']/div[@class='navbar__right-side']/div[2]")).isDisplayed();
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/header[@class='navbar']/div[@class='navbar__right-side']/div[2]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[2]/div[2]/ul[1]/li[2]/a[1]")).isDisplayed(); // Skills
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[2]/div[2]/ul[1]/li[2]/a[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[1]/a[1]")).isDisplayed(); // find skills
        captureScreenshot(driver);

    }

    @Test
    @DisplayName("Step09: Переход из Скиллов в Скилл динамикс")
    public void Step09() {

        driver.findElement(By.id("id_username")).isDisplayed();
        driver.findElement(By.id("id_username")).sendKeys(login);
        driver.findElement(By.id("id_password")).isDisplayed();
        driver.findElement(By.id("id_password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).isDisplayed();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(); // кнопка войти
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/header[@class='navbar']/div[@class='navbar__right-side']/div[2]")).isDisplayed();
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/header[@class='navbar']/div[@class='navbar__right-side']/div[2]")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Profile')]")).isDisplayed();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Profile')]")).click();
        driver.findElement(By.xpath("//li[@class='dynamic-menu__item']//a[contains(text(),'Skills')]")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='dynamic-menu__item']//a[contains(text(),'Skills')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Skills Dynamic')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Skills Dynamic')]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]/span[1]/ul[1]/li[1]/input[1]")).isDisplayed(); // find "Select skills"
        captureScreenshot(driver);

    }

    @Test
    @DisplayName("Step10: Переход из Скилл динамикс в Добавление скиллов")
    public void Step10() {

        driver.findElement(By.id("id_username")).isDisplayed();
        driver.findElement(By.id("id_username")).sendKeys(login);
        driver.findElement(By.id("id_password")).isDisplayed();
        driver.findElement(By.id("id_password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).isDisplayed();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(); // кнопка войти
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/header[@class='navbar']/div[@class='navbar__right-side']/div[2]")).isDisplayed();
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/header[@class='navbar']/div[@class='navbar__right-side']/div[2]")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Profile')]")).isDisplayed();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Profile')]")).click();
        driver.findElement(By.xpath("//li[@class='dynamic-menu__item']//a[contains(text(),'Skills')]")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='dynamic-menu__item']//a[contains(text(),'Skills')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Skills Dynamic')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Skills Dynamic')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Add Skills')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Add Skills')]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/h2[1]")).isDisplayed(); // find "Choose skills"
        captureScreenshot(driver);

    }

    @Test
    @DisplayName("Step14: В Добавлении скиллов открываем выпадающий список Key skills(old) чекбокс Backend жмём Next Step")
    public void Step14() throws NoSuchElementException {

        Actions action = new Actions(driver);
        WebDriverWait wait = (new WebDriverWait(driver, Duration.ofSeconds(10)));

        driver.findElement(By.id("id_username")).isDisplayed();
        driver.findElement(By.id("id_username")).sendKeys(login);
        //captureScreenshot(driver);
        driver.findElement(By.id("id_password")).isDisplayed();
        driver.findElement(By.id("id_password")).sendKeys(password);
        //captureScreenshot(driver);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/form[1]/div[3]/button[1]")).isDisplayed(); // find Log in
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).isDisplayed();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(); // кнопка войти*/
        //captureScreenshot(driver);

        try {
            Optional<WebElement> element = Optional.ofNullable(driver.findElement(By.xpath("//h3[contains(text(),'Backend')]")));
            if (element.isPresent()) {
                if (element.get().isDisplayed()) {

                    System.out.println("if");
                    //driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[14]/div[1]/div[1]/h3[1]")).isDisplayed(); // находим Backend
                    WebElement btn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[14]/div[1]/div[1]")); // наводим мышку на заданную точку
                    action.moveToElement(btn).perform();
                    driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[14]/div[1]/div[1]/span[1]")).isDisplayed(); // remove Backend
                    driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[14]/div[1]/div[1]/span[1]")).click(); // remove Backend
                    WebDriverWait wait1 = (new WebDriverWait(driver, Duration.ofSeconds(10)));
                    wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/button[2]")));
                    driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/button[2]")).isDisplayed(); // put button delete Backend
                    driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/button[2]")).click(); //  put button delete Backend

                } else {

                    System.out.println("else");

                }
            }

        } catch (NoSuchElementException exception) {

            System.out.println("catch");

        }

        driver.findElement(By.xpath("//a[contains(text(),'Add Skills')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Add Skills')]")).click();
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/div[@id='content']/div[@class='main']/div[@class='page-body profile']/div[@class='profile-content']/div[@class='box']/div[@id='skillsContent']/div[@id='skillsWizard']/div[@id='NewSkillsSelection']/div[@class='skills-tree']/div[@id='jstree']/ul[@class='jstree-container-ul jstree-children jstree-wholerow-ul jstree-no-dots']/li[@id='skill-648']/i[1]")).isDisplayed();
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/div[@id='content']/div[@class='main']/div[@class='page-body profile']/div[@class='profile-content']/div[@class='box']/div[@id='skillsContent']/div[@id='skillsWizard']/div[@id='NewSkillsSelection']/div[@class='skills-tree']/div[@id='jstree']/ul[@class='jstree-container-ul jstree-children jstree-wholerow-ul jstree-no-dots']/li[@id='skill-648']/i[1]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Backend')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Backend')]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/button[1]")).isDisplayed();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/span[1]/span[2]")).isDisplayed(); //рейтинг звездочки
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/span[1]/span[2]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[3]/span[1]/span[1]/span[1]/span[2]")).isDisplayed(); //выпадающий список интересности
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[3]/span[1]/span[1]/span[1]/span[2]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]/li[3]")).isDisplayed(); //выбор интереса interesting
        driver.findElement(By.xpath("/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]/li[3]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/button[2]")).isDisplayed(); //выбор интереса interesting
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/button[2]")).click();
        driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[14]/span[1]/b[1]")).isDisplayed(); // находим в скиллах Key skills (old)
        driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[14]/div[1]/div[1]/h3[1]")).isDisplayed(); // находим Backend
        WebElement btn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[14]/div[1]/div[1]")); // наводим мышку на заданную точку
        action.moveToElement(btn).perform();
        driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[14]/div[1]/div[1]/span[1]")).isDisplayed(); // remove Backend
        driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[14]/div[1]/div[1]/span[1]")).click(); // remove Backend
        //WebDriverWait wait = (new WebDriverWait(driver, 10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/button[2]")));
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/button[2]")).isDisplayed(); // put button delete Backend
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/button[2]")).click(); //  put button delete Backend

        if (driver.getPageSource().contains("History")) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        captureScreenshot(driver);

    }

    @Test
    @DisplayName("Goals")
    @Attachment
    @Description
    public void Step15() {
        driver.findElement(By.id("id_username")).isDisplayed();
        driver.findElement(By.id("id_username")).sendKeys(login);
        driver.findElement(By.id("id_password")).isDisplayed();
        driver.findElement(By.id("id_password")).sendKeys(password);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/form[1]/div[3]/button[1]")).isDisplayed(); // find Log in
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).isDisplayed();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(); // кнопка войти
        assertEquals("Skills - Gerard Kunze - TT Planner", driver.getTitle());
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/ul[1]/li[3]")).click(); // переход в Goals
        if (driver.getPageSource().contains("Add Goal")) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[1]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='col-sm-5']//input[@placeholder='@TODO']")).sendKeys("Text");
        driver.findElement(By.xpath("//textarea[@placeholder='Describe the goal']")).sendKeys("Text2");
        driver.findElement(By.xpath("//button[@class='btn btn-large btn-info js-save-goal-btn']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'fg')]")).isDisplayed();
        driver.findElement(By.xpath("//div[@id='goalsInProgress']//div[1]//div[3]//button[1]")).click();
        driver.findElement(By.xpath("//div[@class='goal-actions open']//a[contains(text(),'Delete')]")).click();
        if (driver.getPageSource().contains("Your goal has been deleted.")) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }

}

