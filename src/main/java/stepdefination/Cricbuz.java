package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import  cricbuzzrunner.Runner;
public class Cricbuz extends Runner  {
	WebDriver driver;
	@Given("^user already open cricbuzz page$")
	public void user_already_open_cricbuzz_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\kalaimani");
		driver=new ChromeDriver();
		driver.get("https://www.cricbuzz.com");
		
	}

	@When("^Title of cricbuzz page$")
	public void Title_of_cricbuzz_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		WebElement Logo = driver.findElement(By.xpath("//*[@title=\"Cricbuzz Logo\"]"));
		Logo.isDisplayed();
	}

	@Then("^user click on LiveScores$")
	public void user_click_on_LiveScores() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@title=\"Live Cricket Score\"]"));
		driver.findElement(By.className("cb-hm-mnu-itm")).click();
	
	    
	}



}
