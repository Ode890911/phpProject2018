package pages;

import java.util.List;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.custom.library.BasePage;

public class LogInPage extends BasePage {
	public LogInPage() {
		// TODO Auto-generated constructor stub
	}


	//Verify Website title after navigating to Login Page
	
	
	public LogInPage VerifyLoginPage(){		

			Assert.assertTrue(driver.getTitle().contains("login"), ("user Stay on HomePage"));
			System.out.println("user navigate to 'Log In ' page");
		
		return this;
	}

	public Account_Php User_LogIn(String Username, String Password) throws InterruptedException {

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Username);
		Thread.sleep(1 * 1000);

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		Thread.sleep(1 * 1000);
		driver.findElement(By.xpath("//button[@class='btn btn-action btn-lg btn-block loginbtn']")).click();
		Thread.sleep(1 * 1000);	
		
		
		System.out.println("the website title after clicking 'LogIn' button contains : " + driver.getTitle());


		if (driver.getTitle().contains("Login")){
		WebElement text = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
			String alert = text.getText();
			System.out.println(alert);
			Assert.assertTrue(!driver.getTitle().contains("Login"),
					(alert + ": user is not able to login with valid Credentiels"));

			System.out.println("Page title verified. user is able to login successfully");

		}

		return new Account_Php();
	}
}
	
	

