package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Cricbuzz {
	WebDriver driver;
	@Given("^user already open cricbuzz page$")
	public void user_already_open_cricbuzz_page() 
	{
		System.setProperty("webdriver.chromedriver","C:\\Users\\admin\\Desktop\\kalaimani\\Selenium\\Driver\\chromedriver.exe\\");
		 driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com");
	}
	@When("^ Title of home page is cricbuzz$")
	public void  Title_of_home_page_is_cricbuzz()
	{
		WebElement Logo = driver.findElement(By.xpath("//*[@title=\"Cricbuzz Logo\"]"));
		Logo.isDisplayed();
		
	}
	@Then("^user click on LiveScores$") 
	public void user_click_on_LiveScores() {
		driver.findElement(By.className("cb-hm-mnu-itm"));
	}

}
