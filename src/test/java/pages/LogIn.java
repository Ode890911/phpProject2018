package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.custom.library.BasePage;

public class LogIn extends BasePage {
	
	public LogIn User_LogIn() throws InterruptedException{
	
		/*driver.get("http://www.phptravels.net/login");
		Thread.sleep(1*1000);*/
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("wqor@qwe.com");
		Thread.sleep(1*1000);

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("qwerty");
		Thread.sleep(1*1000);
		driver.findElement(By.xpath("//button[@class='btn btn-action btn-lg btn-block loginbtn']")).click();
		Thread.sleep(1*1000);
		
		
		WebElement text = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));	
		//List <WebElement> text = driver.findElements(By.tagName("p"));
				//String alert = text.get(i).getText();
						
						
						     if(text.getText() != null)
						     {
						      // System.out.println(text.get(i).getText());
								String alert = text.getText();
								System.out.println(alert);
								Assert.assertTrue(driver.getTitle().contains("Account"), (alert +  ": user is not able to login-Invalid Credentiels"));
								
							 	System.out.println("Page title verified. user is able to login successfully");

						     }
						   
						 	
		return this;
	}
	

}
