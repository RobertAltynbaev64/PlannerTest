import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlannerHomePage extends PlannerSettings {

    @BeforeEach
    public void testSetup() {

        System.setProperty(property, property2);
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("headless");
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        driver.get(site);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    @DisplayName("Step00: Проверка на домашнюю страницу")
    public void Step00() {
        if (!"Planner".equals(driver.getTitle())) {
            throw new IllegalStateException("This isn't Planner's home Page!");
        }
    }

    @Test
    @DisplayName("Step01: Ввод логина")
    public void Step01() {
        driver.findElement(By.id("id_username")).isDisplayed();
        driver.findElement(By.id("id_username")).sendKeys(login);

    }

    @Test
    @DisplayName("Step02: Ввод пароля")
    public void Step02() {
        driver.findElement(By.id("id_password")).isDisplayed();
        driver.findElement(By.id("id_password")).sendKeys(password);
    }

    @Test
    @DisplayName("Step03: Ввод логина и пароля с дальнейшим входом")
    public void Step03() {
        driver.findElement(By.id("id_username")).isDisplayed();
        driver.findElement(By.id("id_username")).sendKeys(login);
        driver.findElement(By.id("id_password")).isDisplayed();
        driver.findElement(By.id("id_password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).isDisplayed();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(); // кнопка войти
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
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/header[@class='navbar']/div[@class='navbar__right-side']/div[2]")).isDisplayed();
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/header[@class='navbar']/div[@class='navbar__right-side']/div[2]")).click();
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

    }

    @Test
    @DisplayName("Step07: Из График/Schedule в Job titles")
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
        driver.findElement(By.xpath("//a[contains(text(),'Schedule')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Schedule')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Job Titles')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Job Titles')]")).click();

    }

    @Test
    @DisplayName("Step08: Переход из Профайла в Скиллы")
    public void Step08() {

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
        driver.findElement(By.xpath("//a[contains(text(),'Job Titles')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Job Titles')]")).click();
        driver.findElement(By.xpath("//li[@class='dynamic-menu__item']//a[contains(text(),'Skills')]")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='dynamic-menu__item']//a[contains(text(),'Skills')]")).click();

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
        driver.findElement(By.xpath("//a[contains(text(),'Schedule')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Schedule')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Job Titles')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Job Titles')]")).click();
        driver.findElement(By.xpath("//li[@class='dynamic-menu__item']//a[contains(text(),'Skills')]")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='dynamic-menu__item']//a[contains(text(),'Skills')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Skills Dynamic')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Skills Dynamic')]")).click();

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
        driver.findElement(By.xpath("//a[contains(text(),'Schedule')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Schedule')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Job Titles')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Job Titles')]")).click();
        driver.findElement(By.xpath("//li[@class='dynamic-menu__item']//a[contains(text(),'Skills')]")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='dynamic-menu__item']//a[contains(text(),'Skills')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Skills Dynamic')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Skills Dynamic')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Add Skills')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Add Skills')]")).click();

    }

    @Test
    @DisplayName("Step11: В Добавлении скиллов открываем выпадающий список Key skills(old)")
    public void Step11() {

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
        driver.findElement(By.xpath("//a[contains(text(),'Job Titles')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Job Titles')]")).click();
        driver.findElement(By.xpath("//li[@class='dynamic-menu__item']//a[contains(text(),'Skills')]")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='dynamic-menu__item']//a[contains(text(),'Skills')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Skills Dynamic')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Skills Dynamic')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Add Skills')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Add Skills')]")).click();
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/div[@id='content']/div[@class='main']/div[@class='page-body profile']/div[@class='profile-content']/div[@class='box']/div[@id='skillsContent']/div[@id='skillsWizard']/div[@id='NewSkillsSelection']/div[@class='skills-tree']/div[@id='jstree']/ul[@class='jstree-container-ul jstree-children jstree-wholerow-ul jstree-no-dots']/li[@id='skill-648']/i[1]")).isDisplayed();
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/div[@id='content']/div[@class='main']/div[@class='page-body profile']/div[@class='profile-content']/div[@class='box']/div[@id='skillsContent']/div[@id='skillsWizard']/div[@id='NewSkillsSelection']/div[@class='skills-tree']/div[@id='jstree']/ul[@class='jstree-container-ul jstree-children jstree-wholerow-ul jstree-no-dots']/li[@id='skill-648']/i[1]")).click();

    }

    @Test
    @DisplayName("Step12: В Добавлении скиллов открываем выпадающий список Key skills(old) чекбокс Backend")
    public void Step12() {

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
        driver.findElement(By.xpath("//a[contains(text(),'Job Titles')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Job Titles')]")).click();
        driver.findElement(By.xpath("//li[@class='dynamic-menu__item']//a[contains(text(),'Skills')]")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='dynamic-menu__item']//a[contains(text(),'Skills')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Skills Dynamic')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Skills Dynamic')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Add Skills')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Add Skills')]")).click();
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/div[@id='content']/div[@class='main']/div[@class='page-body profile']/div[@class='profile-content']/div[@class='box']/div[@id='skillsContent']/div[@id='skillsWizard']/div[@id='NewSkillsSelection']/div[@class='skills-tree']/div[@id='jstree']/ul[@class='jstree-container-ul jstree-children jstree-wholerow-ul jstree-no-dots']/li[@id='skill-648']/i[1]")).isDisplayed();
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/div[@id='content']/div[@class='main']/div[@class='page-body profile']/div[@class='profile-content']/div[@class='box']/div[@id='skillsContent']/div[@id='skillsWizard']/div[@id='NewSkillsSelection']/div[@class='skills-tree']/div[@id='jstree']/ul[@class='jstree-container-ul jstree-children jstree-wholerow-ul jstree-no-dots']/li[@id='skill-648']/i[1]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Backend')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Backend')]")).click();
        assertEquals("Webpage expected title", driver.getTitle());

    }

    @Test
    @DisplayName("Step13: В Добавлении скиллов открываем выпадающий список Key skills(old) чекбокс Backend жмём Next Step")
    public void Step13() {

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
        driver.findElement(By.xpath("//a[contains(text(),'Job Titles')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Job Titles')]")).click();
        driver.findElement(By.xpath("//li[@class='dynamic-menu__item']//a[contains(text(),'Skills')]")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='dynamic-menu__item']//a[contains(text(),'Skills')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Skills Dynamic')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Skills Dynamic')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Add Skills')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Add Skills')]")).click();
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/div[@id='content']/div[@class='main']/div[@class='page-body profile']/div[@class='profile-content']/div[@class='box']/div[@id='skillsContent']/div[@id='skillsWizard']/div[@id='NewSkillsSelection']/div[@class='skills-tree']/div[@id='jstree']/ul[@class='jstree-container-ul jstree-children jstree-wholerow-ul jstree-no-dots']/li[@id='skill-648']/i[1]")).isDisplayed();
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/div[@id='content']/div[@class='main']/div[@class='page-body profile']/div[@class='profile-content']/div[@class='box']/div[@id='skillsContent']/div[@id='skillsWizard']/div[@id='NewSkillsSelection']/div[@class='skills-tree']/div[@id='jstree']/ul[@class='jstree-container-ul jstree-children jstree-wholerow-ul jstree-no-dots']/li[@id='skill-648']/i[1]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Backend')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Backend')]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/button[1]")).isDisplayed();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/button[1]")).click();

    }

    @Test
    @DisplayName("Step14: В Добавлении скиллов открываем выпадающий список Key skills(old) чекбокс Backend жмём Next Step")
    public void Step14() {

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
        driver.findElement(By.xpath("//a[contains(text(),'Job Titles')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Job Titles')]")).click();
        driver.findElement(By.xpath("//li[@class='dynamic-menu__item']//a[contains(text(),'Skills')]")).isDisplayed();
        driver.findElement(By.xpath("//li[@class='dynamic-menu__item']//a[contains(text(),'Skills')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Skills Dynamic')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Skills Dynamic')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Add Skills')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Add Skills')]")).click();
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/div[@id='content']/div[@class='main']/div[@class='page-body profile']/div[@class='profile-content']/div[@class='box']/div[@id='skillsContent']/div[@id='skillsWizard']/div[@id='NewSkillsSelection']/div[@class='skills-tree']/div[@id='jstree']/ul[@class='jstree-container-ul jstree-children jstree-wholerow-ul jstree-no-dots']/li[@id='skill-648']/i[1]")).isDisplayed();
        driver.findElement(By.xpath("//body[@class='page']/div[@class='page__inner']/div[@id='content']/div[@class='main']/div[@class='page-body profile']/div[@class='profile-content']/div[@class='box']/div[@id='skillsContent']/div[@id='skillsWizard']/div[@id='NewSkillsSelection']/div[@class='skills-tree']/div[@id='jstree']/ul[@class='jstree-container-ul jstree-children jstree-wholerow-ul jstree-no-dots']/li[@id='skill-648']/i[1]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Backend')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Backend')]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/button[1]")).isDisplayed();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/button[1]")).click();
        //assertEquals("Webpage expected title", driver.getTitle());
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/span[1]/span[2]")).isDisplayed();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/span[1]/span[2]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[3]/span[1]/span[1]/span[1]/span[2]")).isDisplayed();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[3]/span[1]/span[1]/span[1]/span[2]")).click();

    }



}




    /*



        if (driver.findElement(By.xpath("//span[contains(@class,'select2-selection__arrow')]")).isDisplayed()) {
            driver.findElement(By.xpath("//span[contains(@class,'select2-selection__arrow')]")).click();
            //driver.findElement(By.xpath("//li[@id='select2-w4p9-result-xw6m-3']")).click();
            //span[@class='select2-selection__arrow']
        } else {
            System.out.println(" выпадающий список не нажался ");
        }

        Thread.sleep(3000);

        if (driver.findElement(By.xpath("//li[@id='select2-zqbj-result-yub6-3']")).isDisplayed()) {
            driver.findElement(By.xpath("//li[@id='select2-zqbj-result-yub6-3']")).click();
            //driver.findElement(By.xpath("//li[@id='select2-w4p9-result-xw6m-3']")).click();
        } else {
            System.out.println(" выпадающий список не нажался ");
        }



        if (driver.findElement(By.xpath("//div[@id='skillsWizard']//span[3]")).isDisplayed()) {
            driver.findElement(By.xpath("//div[@id='skillsWizard']//span[3]")).click();
        } else {
            System.out.println(" выбор 3 звезд не нажался ");
        }

        if (driver.findElement(By.xpath("//button[@id='saveNewSkills']")).isDisplayed()) {
            driver.findElement(By.xpath("//button[@id='saveNewSkills']")).click();
        } else {
            System.out.println(" финиш не нажался ");*/