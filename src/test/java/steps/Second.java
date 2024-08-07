package steps;

import java.time.Duration;

import javax.swing.JScrollBar;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Second {
	
	 WebDriver driver;	

@Given("Open browser,enter sparch hospital URL")
public void open_browser_enter_sparch_hospital_url() {
	
	 driver=new ChromeDriver();
	 
	 driver.get("https://www.sparshhospital.com/");
	 
	 driver.manage().window().maximize();
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}

@Given("On the homepage,click on the hospital dropdown")
public void on_the_homepage_click_on_the_hospital_dropdown() {
	
	driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle'])[3]")).click();

	
}

@Given("Select the SPARSH Hospital, Yeswanthpur")
public void select_the_sparsh_hospital_yeswanthpur() {
	
	driver.findElement(By.xpath("//a[@href=\"https://www.sparshhospital.com/hospitals/sparsh-hospital-yeswanthpur/\" and @class=\"dropdown-item\"]")).click();	
}

@When("User clicks on Second Opinion link")
public void user_clicks_on_second_opinion_link() throws InterruptedException {
	
    JavascriptExecutor js=(JavascriptExecutor)driver;
	
	
	js.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//a[@href='https://www.sparshhospital.com/second-opinion/'])[1]")));

	
}

@When("User enters firstname,lastname, phone, email")
public void user_enters_firstname_lastname_phone_email() {
	
	driver.findElement(By.id("secondopinion_first_name")).sendKeys("Theja");
	
	driver.findElement(By.id("secondopinion_last_name")).sendKeys("Goswami");
	
	driver.findElement(By.id("secondopinion_phone")).sendKeys("8660849921");
	
	driver.findElement(By.id("secondopinion_email")).sendKeys("thejagoaswami14@gmail.com");

}

@When("Upload the report")
public void upload_the_report() {
	
	//driver.findElement(By.id("secondopinion_reports")).sendKeys("C:\\Users\\annie\\Downloads\\DSA solved.pdf");

	

	
}

@When("Write a message on the textbox and click on Send button")
public void write_a_message_on_the_textbox_and_click_on_send_button() {
	
	driver.findElement(By.id("secondopinion_message")).sendKeys("For appointment related queries");
	

	 JavascriptExecutor js=(JavascriptExecutor)driver;
	
	  js.executeScript("document.getElementById('secondopinion_submit').click();");
}


@Then("Thankyou message should be displayed")
public void thankyou_message_should_be_displayed() {

	String Text = driver.findElement(By.xpath("//h1[@class='font-700 mb-4']")).getText();
	String textExpectedString = "Thank you";
	org.testng.Assert.assertEquals(Text, textExpectedString);
	

}

@Then("Bank info should be available in the page")
public void bank_info_should_be_available_in_the_page() {
	String Bankname = driver.findElement(By.xpath("(//div[@class='col-md-12 p-4'])[2]/p[3]")).getText();
	String BanknameExpected = "Bank Name: Bank of Baroda";
	org.testng.Assert.assertEquals(Bankname, BanknameExpected);
	driver.close();

}



}
