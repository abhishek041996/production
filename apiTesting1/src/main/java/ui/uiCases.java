package ui;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class uiCases {
		@SuppressWarnings("deprecation")
		
		public static void main(String[] args){
			    WebDriver driver = new ChromeDriver();
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	            driver.get("https://sustlabs-emc.web.app");
	            driver.findElement(By.xpath("//*[@id='email']")).sendKeys("atul.patil@lodhagroup.com");
	            driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Lodha@1234");
	            driver.findElement(By.xpath("/html/body/app-root/layout/empty-layout/div/div[1]/auth-sign-in/div/div/div[2]/form/button/span[2]/span")).click();
	            driver.manage().window().maximize();
	            //driver.findElement(By.xpath("/html/body/app-root/layout/classic-layout/fuse-vertical-navigation/div/div[2]/fuse-vertical-navigation-basic-item[2]/div/a")).click();
	            //driver.findElement(By.xpath("/html/body/app-root/layout/classic-layout/div/div[2]/app-all-bots/div/app-botlist-table/div/div/div[2]/div[1]/table/tbody/tr/td[6]/div/button/span[2]")).click();
	            driver.quit();
	          
	            }

	}
