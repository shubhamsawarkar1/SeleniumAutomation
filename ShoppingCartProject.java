package org.project.finals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartProject {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver","J:\\Testing Course\\Testing SOFTWARES\\chromedriver\\msedgedriver.exe");
        WebDriver driver=new EdgeDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("shubhamsawarkar@gmail.com");
        driver.findElement(By.xpath("//input[@id='input-email']//following::input[1]")).sendKeys("shubham");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        System.out.println("Login successful");
        Actions act=new Actions(driver);
        WebElement laptop=driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        WebElement allLaptop=driver.findElement(By.linkText("Show AllLaptops & Notebooks"));
        act.moveToElement(laptop).click(allLaptop).build().perform();

        driver.findElement(By.xpath("(//span[text()='Add to Cart'])[3]")).click();
        System.out.println("MAcbook Air Added to cart");
        driver.findElement(By.xpath("(//span[text()='Add to Cart'])[4]")).click();
        driver.findElement(By.xpath("//span[text()='Shopping Cart']")).click();
        WebElement maca=driver.findElement(By.xpath("(//a[text()='MacBook Air'])[2]"));
        WebElement macp=driver.findElement(By.xpath("(//a[text()='MacBook Pro'])[2]"));
        if (maca.getText().equals("MacBook Air")){
            System.out.println("The MacBook Air product text is correct");
        }else {
            System.out.println("The MacBook Air product text is not correct");
        }
        if (macp.getText().equals("MacBook Pro")) {
            System.out.println(" MacBook Pro product text is Correct " );
        }else {
            System.out.println(" MacBook Pro product text is not Correct " );
        }
        driver.findElement(By.xpath("//input[@name='quantity[30541]']")).clear();
        driver.findElement(By.xpath("//input[@name='quantity[30541]']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@name='quantity[30540]']")).clear();
        driver.findElement(By.xpath("//input[@name='quantity[30540]']")).sendKeys("2");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement total=driver.findElement(By.xpath("(//td[text()='$5,202.00'])[2]"));
        System.out.println("The sum of Product is : "+total.getText());
        if (total.getText().equals("$5,202.00")){
            System.out.println("Product price is correct ");
        }else {
            System.out.println("Product price is not correct ");
        }
        driver.findElement(By.xpath("//a[text()='Checkout']")).click();


        System.out.println("checkout done!!!");



driver.quit();
    }
}
