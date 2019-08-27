package com.step;


import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Sample {
	static WebDriver driver;
	@Given("User should launch browser")
	public void user_should_launch_browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\raju\\Downloads\\eclipse-jee-oxygen-3a-win32-x86_64\\eclipse\\samatha\\Sele1\\driver\\chromedriver.exe");
		   driver= new ChromeDriver();
		driver.get("http://www.demo.guru99.com/telecom/");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
	   	}

	@Given("user click add customer link")
	public void user_click_add_customer_link() {
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();

	   }

	@When("user provide valid details")
	public void user_provide_valid_details(io.cucumber.datatable.DataTable dataTable) {
		System.out.println("when-1");
		Map<String,String>onedmap = dataTable.asMap(String.class,String.class);
		driver.findElement(By.xpath("//label[text()='Done']")).click();
		driver.findElement(By.id("fname")).sendKeys(onedmap.get("fname"));
		driver.findElement(By.id("lname")).sendKeys(onedmap.get("lname"));
		driver.findElement(By.id("email")).sendKeys(onedmap.get("gmail"));
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(onedmap.get("address"));
		driver.findElement(By.id("telephoneno")).sendKeys(onedmap.get("phoneno"));
		driver.findElement(By.xpath("//input[@name='submit']")).click();


	   	}

	@Then("To verify the customer id is displayed")
	public void to_verify_the_customer_id_is_displayed() {
		Assert.assertTrue(driver.findElement(By.xpath("//td[@align='center']")).isDisplayed());

	   	}

}
