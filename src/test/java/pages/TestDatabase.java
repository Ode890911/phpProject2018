package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class TestDatabase {
	
	private String databaseServerName = "localhost";
	private String databasePort = "1521";
	private String databaseNAme = "xe";
	private String userName = "hr";
	private String userPassword = "hr";
	private String connectionURL = "jdbc:oracle:thin:hr@//" + databaseServerName + ":" + databasePort+"/"+databaseNAme;
	
	private Connection connection = null;
	private Statement statement = null;
	
	
	@Test
	 public void TestVerifyDB() throws ClassNotFoundException, SQLException{	    
	                        
	       // This will load the driver
		 // 1-connect to the database
		  Class.forName("oracle.jdbc.OracleDriver");
		  System.out.println("driver loaded");
			connection = DriverManager.getConnection(connectionURL, userName, userPassword);	                
	      
	       System.out.println("Connection created");
	   		
	   	
	   // create object of statement  using create statement method
	       statement = connection.createStatement();	
	          
	        System.out.println("Statement created");
	 
	   // finally execute the query using the table I have created in DB 
	        //it will return an resultset interface
	    
	   		ResultSet data = statement.executeQuery("select* from testdata2");
	    
	 
	        System.out.println("Query Executed");
	    	 
	      while(data.next()){
	   
	       String fi_name=  data.getString("First_Name");
	       String LastN=     data.getString("Last_Name");
	     
	 
	        System.out.println("last name is "+LastN+" and first name is "+fi_name);
	   
	  
	  }
	}
	  
} 


// Iterate the resultset now    

	
/*  		System.out.println("result: " + data);	
  		
  		String tab = "\t";
  		while(data.next())
  		{
  			String lastN = data.getString("Last_Name");
  			String fiName = data.getString("First_Name");
  			String email = data.getString("Email");
  			System.out.println(lastN + tab + fiName +tab+tab+ email);
  		}
  	
}    
}*/
  
