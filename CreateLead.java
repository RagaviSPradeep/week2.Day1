package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {
	 public static void main(String[] args) {
		 
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 
		 //Create browser object and Launch URL 
		 driver.get("http://leaftaps.com/opentaps/control/main");
		 driver.manage().window().maximize();
		 
		 //Login using username and password
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
	
		//linktext to move to lead and create lead page
			driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Create Lead")).click();
			
			//Input Lead informations
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("ABCDE");
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Ragavi");
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys("S");
			driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Kirthi");
			driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("QA");
			driver.findElement(By.id("createLeadForm_description")).sendKeys("Test");
			driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("kirthi@asd.com");
			
			
			//Creating select class to select value in dropdown 
			WebElement dropdown1=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
			Select select=new Select(dropdown1);
			select.selectByVisibleText("New York");
		
			driver.findElement(By.name("submitButton")).click();
			
			//Get window title to check we are in correct page. 
			String title=driver.getTitle();
			System.out.println(title);
			if(title.contains("View Lead")) {
			System.out.println("Lead creation is successful");
			}
			
		}
		 }

