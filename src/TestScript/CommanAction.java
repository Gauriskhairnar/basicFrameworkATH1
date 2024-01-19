package TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CommanAction
{
    public WebDriver driver;

    public void launchApp() {
        System.setProperty("webdriver.crome.driver", "C:\\Program Files\\automation software\\cromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:100/");
        driver.manage().window().maximize();
    }

    public String verifyTitle(String expTitle) {
        String actTitle = driver.getTitle();
        if (expTitle.equals(actTitle)) {
            return "passed";

        } else {
            return "failed";
        }
    }

    public boolean elementDisplay(String xpath)
    {
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    public String elementGetText(String xpath)
    {
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public String GetTextBoxText(String xpath, String text) {
        driver.findElement(By.xpath(xpath)).sendKeys(text);
        return driver.findElement(By.xpath(xpath)).getAttribute("value");
    }

    public String GettypeAttribute(String xpath) {
        return driver.findElement(By.xpath(xpath)).getAttribute("type");
    }

    public void login(String userid, String password) {
        driver.findElement(By.name("user_name")).clear();
        driver.findElement(By.name("user_name")).sendKeys(userid);
        driver.findElement(By.name("user_password")).clear();
        driver.findElement(By.name("user_password")).sendKeys(password);
        driver.findElement(By.name("Login")).click();
    }

    public void MouseHover(String xpath) {
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath(xpath))).perform();
    }

    public void MouseClick(String xpath) {

        Actions a = new Actions(driver);
        a.click(driver.findElement(By.xpath(xpath))).perform();
    }

    public void ElementClick(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void DragAndDrop(String srs, String dest) {
        Actions a1 = new Actions(driver);
        a1.dragAndDrop(driver.findElement(By.xpath(srs)), driver.findElement(By.xpath(dest))).perform();
    }


    public void WindowHandle() {
        Set<String> set = driver.getWindowHandles();
        Iterator<String> itr = set.iterator();
        String firstWindow = itr.next();
        String secondWindow = itr.next();
        driver.switchTo().window(secondWindow);
        driver.findElement(By.xpath("//a[text()='vtiger']")).click();
        driver.switchTo().window(firstWindow);

    }

    public String GetTextBoxText(String xpath) {
        return driver.findElement(By.xpath(xpath)).getAttribute("Value");

    }

    public void TabHandles()
    {
        Set<String> set = driver.getWindowHandles();
        Iterator<String> itr = set.iterator();
        String firsttab= itr.next();
        String secondtab = itr.next();
        driver.switchTo().window(secondtab);
        driver.findElement(By.xpath("//a[@id='login']")).click();
        driver.close();

        driver.switchTo().window(firsttab);
        //driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
            driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
            driver.findElement(By.xpath("//input[@name='Login']")).click();
    }

    public void newLeadCheck()
    {
        driver.findElement(By.xpath("//a[text()='New Lead']")).click();
        driver.findElement(By.xpath("//input[@name='button']")).click();
        String alertmsg1 = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("swapnil");
        driver.findElement(By.xpath("//input[@name='button']")).click();
        String alertmsg2 = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//input[@name='company']")).sendKeys("TATA TACH");
        driver.findElement(By.xpath("//input[@name='button']")).click();
    }

        public Boolean alertHandles1() {
            driver.findElement(By.xpath("//a[text()='New Lead']")).click();
            driver.findElement(By.xpath("//input[@name='button']")).click();
            String alertmsg11 = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();

            driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("ram");
            driver.findElement(By.xpath("//input[@name='button']")).click();
            String alertmsg22 = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();

            driver.findElement(By.xpath("//input[@name='company']")).sendKeys("infocys");
            driver.findElement(By.xpath("//input[@name='button']")).click();

            if (alertmsg11.equals("Last Name cannot be empty") && (alertmsg22.equals("Company cannot be empty"))) {
                return true;
            } else {
                return false;
            }
        }

        public void fileUpload()
            {
                driver.findElement(By.xpath("//a[text()='New Lead']")).click();
                driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("sham");
                driver.findElement(By.xpath("//input[@name='company']")).sendKeys("mind tree");
                driver.findElement(By.xpath("//input[@name='button']")).click();

                driver.findElement(By.xpath("//input[@value='New Attachment']")).click();
                driver.findElement(By.xpath("//input[@name='binFile']")).sendKeys("C:\\Users\\gauri\\OneDrive\\Desktop\\Testing\\Software");
                driver.findElement(By.xpath("//input[@value='Upload']")).click();


            }
            public Boolean fileuploadjpgmsgalert()
            {
                driver.findElement(By.xpath("//a[text()='New Lead']")).click();
                driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("mina");
                driver.findElement(By.xpath("//input[@name='company']")).sendKeys("mind tree");
                driver.findElement(By.xpath("//input[@name='button']")).click();
                driver.findElement(By.xpath("//input[@value='New Product']")).click();
                driver.findElement(By.xpath("//input[@name='productname']")).sendKeys("abc123");
                driver.findElement(By.xpath("//input[@name='imagename']")).sendKeys("C:\\Users\\gauri\\OneDrive\\Desktop\\Testing\\Software\\");
                driver.findElements(By.xpath("//input[@value='  Save  ']")).get(1).click();

                String alertmsg3 = driver.switchTo().alert().getText();
                driver.switchTo().alert().accept();

                if (alertmsg3.equals("Kindly specify a valid Product Image File of type .jpg, .png or .gif"))
                {

                    return true;
                }
                else
                {
                    return false;
                }



            }
            public void productWindohandle() throws InterruptedException {
                driver.findElement(By.xpath("//a[text()='New Lead']")).click();
                driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("mina");
                driver.findElement(By.xpath("//input[@name='company']")).sendKeys("mind tree");
                driver.findElement(By.xpath("//input[@name='button']")).click();
                driver.findElement(By.xpath("//input[@value='New Product']")).click();
                driver.findElement(By.xpath("//input[@name='productname']")).sendKeys("abc123");
                driver.findElement(By.xpath("//input[@value='Change']")).click();
                Thread.sleep(9000);

                Set<String> set = driver.getWindowHandles();
                Iterator<String> itr = set.iterator();
                String firstWindow = itr.next();
                String secondWindow = itr.next();
                driver.switchTo().window(secondWindow);
                driver.findElement(By.xpath("//a[text()='Mary Smith']")).click();
                driver.switchTo().window(firstWindow);
            }
            public void DropdownHandling()
            {
                driver.findElement(By.xpath("//a[text()='New Lead']")).click();
                driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("mina");
                driver.findElement(By.xpath("//input[@name='company']")).sendKeys("mind tree");
                driver.findElement(By.xpath("//input[@name='button']")).click();
                driver.findElement(By.xpath("//input[@value='New Task']")).click();
                driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("abc");
                driver.findElement(By.xpath("//input[@name='date_start']")).sendKeys("2023-06-09");
                driver.findElement(By.xpath("//input[@name='time_start']")).sendKeys("16:45");
                Select dropdown=new Select(driver.findElement(By.xpath("//select[@name='parent_type']")));
                dropdown.selectByVisibleText("Potentials");
                Select dropdown1=new Select( driver.findElement(By.xpath("//select[@name='taskstatus']")));
                dropdown1.selectByVisibleText("Pending Input");
                driver.findElement(By.xpath("//input[@name='sendnotification']")).click();
                driver.findElement(By.xpath("//input[@value='  Save  ']")).click();


            }
            public void checklink_size()
            {
                driver.findElement(By.xpath("//a[text()='Accounts']")).click();
                driver.findElements(By.tagName("a")).size();
                System.out.println(driver.findElements(By.tagName("a")).size());

            }








        }

