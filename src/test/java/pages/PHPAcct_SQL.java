package pages;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.custom.library.BasePage;
import com.custom.library.ExcelManager;

public class PHPAcct_SQL extends BasePage {
	
	
	@DataProvider(name = "Sign Up")
	public  Object[][] getHotelDateFromExcel() throws SQLException
	
	{
		ExcelManager reader = new ExcelManager("src/test/resources/PhpUserCredTest.xls");//create new object excelmanager ,excell file location must be added
		return reader.getExcelData("Sheet1");
		
		/*JavaSQLConnectivity javaSQL = new JavaSQLConnectivity();//add location for database				
		
		return javaSQL.getSQLData("PHPTEST1");*/
	}
	
	
	//PR4ESENTATION EXAMPLES
	
	
	
	@Test (dataProvider = "Sign Up")//data provider annotation
	public void loginTest(String First_Name, String Last_Name, String Mobile_Number, String	Email,String Password, String confirm_Password) throws InterruptedException
	{
		
		
		driver.get("http://www.phptravels.net/register");
		Thread.sleep(1*1000);
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(First_Name );
		Thread.sleep(1*1000);
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(Last_Name);
		Thread.sleep(1*1000);
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(Mobile_Number);
		Thread.sleep(1*1000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Email);
		Thread.sleep(1*1000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		Thread.sleep(1*1000);			
		driver.findElement(By.xpath("//input[@name='confirmpassword']")).sendKeys(confirm_Password);
		Thread.sleep(1*1000);		
		driver.findElement(By.cssSelector("button.signupbtn.btn_full.btn.btn-action.btn-block.btn-lg")).click();
		Thread.sleep(2*1000);

		List <WebElement> text = driver.findElements(By.xpath("//div[@class='alert alert-danger']"));
		
		
		for(int i=0; i< text.size(); i++)
		   {
		     if(text.get(i).getText() != null)
		     {
		       System.out.println(text.get(i).getText());
		       
		     }
		   }
		   } 
	
	

    
		/*@Test (dataProvider = "Sign Up")
	     
	 	public  void SQLDB() throws SQLException {
				JavaSQLConnectivity javaSql = new JavaSQLConnectivity();
				ResultSet data = javaSql.runSQLQuery("select First_Name, Last_Name, from PhpuserCredtable");
			System.out.println("result: " + data);*/	
				
	
}
