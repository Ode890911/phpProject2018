package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.DataProvider;

import com.custom.library.BasePage;



public class JavaSQLConnectivity extends BasePage{
	static Connection con;
	private static Object[][] data;
	

		private String databaseServerName = "localhost";
		private String databasePort = "1521";
		private String databaseNAme = "xe";
		private String userName = "hr";
		private String userPassword = "hr";
		private String connectionURL = "jdbc:oracle:thin:hr@//" + databaseServerName + ":" + databasePort+"/"+databaseNAme;
		
		private Connection connection = null;
		private Statement statement = null;
		private ResultSet resultSet = null;
		
		
		
		private void connectToOracleDB() throws ClassNotFoundException, SQLException
		{
			Class.forName("oracle.jdbc.OracleDriver");//load the driver
			connection = DriverManager.getConnection(connectionURL, userName, userPassword);//create the connexion
			statement = connection.createStatement();	
		}
		
		public ResultSet runSQLQuery(String sqlQuery) throws ClassNotFoundException, SQLException
		{
			connectToOracleDB();
			resultSet = statement.executeQuery(sqlQuery);
			return resultSet;
		}
		
		
			public String[][] getSQLData(String sheetName) throws SQLException {
				String[][] arrayExcelData = null;
	    	 data= new Object[10][2];				
				//create the statement object
				Statement Stmt= con.createStatement();
				//execute query
				ResultSet Rs = Stmt.executeQuery("select First_Name, Last_Name, from PhpuserCredtable");
				int rowCounter = 0;
				
				while (Rs.next())
	{int colCounter = 0;
	for(int i=1; i<=Rs.getMetaData().getColumnCount(); i++) {
		
		System.out.println(Rs.getString(i) + "\t");
		
		data[rowCounter][colCounter] = Rs.getString(i);
		colCounter++;
	}
	System.out.println("");
	rowCounter++;
		}
				return arrayExcelData;

			
			
}

}
