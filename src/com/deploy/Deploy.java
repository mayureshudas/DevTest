package com.deploy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Deploy {
	static WebDriver driver;
	@BeforeSuite
	public static void setup(){
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\maudas\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		driver=new ChromeDriver();
		//driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://52.66.16.188:1507");
	}
	
	@Test
	public static void test(){
		driver.findElement(By.xpath("//form//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//form//input[@id='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//form//button[@class='login-btn btn btn-block ng-binding']")).click();
		driver.findElement(By.xpath("//div[@class='sidebar']//ul[@class='nav nav-list']/li[@id='nav.menu.manage']/a")).click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement manageVservices=driver.findElement(By.xpath("//div[@class='sidebar']//ul[@class='nav nav-list']/li[@id='nav.menu.manage']/ul/li[@id='nav.menu.manage.virtualservices']/a/span"));
		wait.until(ExpectedConditions.elementToBeClickable(manageVservices));
		if(manageVservices.isDisplayed()){
			manageVservices.click();
		}
		else{
			System.out.println("ERROR!!!!");
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String image="google2";
		String xpath1="//div[@class='main-content']//div[@class='widget-body']//div[@class='ui-grid-row ng-scope']/div/div/a[contains(text(),'"+image+"')]/../../div";
		List <WebElement> services=driver.findElements(By.xpath(xpath1));
		//System.out.println(services.size());
		WebElement div=services.get(0);
		String xpath2="//div[@class='main-content']//div[@class='widget-body']//div[@class='ui-grid-row ng-scope']/div/div/a[contains(text(),'"+image+"')]/../../div[@id='"+div.getAttribute("id")+"']/span/a";
		WebElement deploy=driver.findElement(By.xpath(xpath2));
		deploy.click();
		//String xpath3="//div[@class='main-content']//div[@class='widget-body']//div[@class='ui-grid-row ng-scope']/div/div/a[contains(text(),'google2')]/../../div[@id='"+div.getAttribute("id")+"']/span/a/following-sibling::ul//a[contains(text(),'Deploy')]";
		//driver.findElement(By.xpath(xpath3)).click();
		Actions action=new Actions(driver);
		Point point=deploy.getLocation();
		//System.out.println("X coordinate: "+point.getX());
		//System.out.println("Y coordinate: "+point.getY());
		action.moveByOffset(12,24).click().build().perform();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[@class='modal-content']//button[contains(text(),'Deploy')]")).click();
		//action.moveToElement(deploy, 5, 10).click().build().perform();
		/*for(WebElement service:services){
			System.out.println(service.getAttribute("id"));
		}*/
		/*List <WebElement> services=driver.findElements(By.xpath("//div[@class='main-content']//div[@class='widget-body']//div[@class='ui-grid-row ng-scope']/div/div/a"));
		int serviceIndex=services.indexOf(driver.findElement(By.xpath("//div[@class='main-content']//div[@class='widget-body']//div[@class='ui-grid-row ng-scope']/div/div/a[contains(text(),'google2')]")));
		int i=((serviceIndex+1)/3)-1;
		//System.out.println(serviceIndex);
		System.out.println(services.size());
		for(WebElement service:services){
			System.out.println(service.getText());
		}
		
		WebElement deploy=driver.findElement(By.xpath("//div[@class='main-content']//div[@class='widget-body']//div[@class='ui-grid-row ng-scope']['+i']/div/div[0]/span[1]/a"));
		wait.until(ExpectedConditions.visibilityOf(deploy));
		if(deploy.isDisplayed()){
			deploy.click();
		}
		else{
			System.out.println("ERROR!!!!--2");
		}*/
	}
	

}