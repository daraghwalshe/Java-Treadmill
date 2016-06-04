package treadmillWithDb;



import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**Verify correct login and directs flow between medical and service windows.
 * @author Daragh Walshe	Student# B00064428
 * Group: Group 1			Date:  March 2014
 * Treadmill Project	Year 2
 * COMP H2027 - Software Engineering and Testing
 */
public class LoginManager {

	//Database engine for creating DB connection, making queries
	mySQLEngine dbEngine = new mySQLEngine("root","qwerty"); //sql user name and password
	
	/**
	 * Create connection to the DB
	 * Query it for a single row in the password table
	 *  
	 */

	//---------------------------------------------------------
	
	/**
	 * Constructor 
	 */
	public LoginManager(String stringIn) {
		init();
		//get the row in a nice array
		String[] results = getARow(stringIn);
		for(int i=0;i<results.length; i++){System.out.println(results[i]);}
		checkResult(results);
	}
	
	public void init() {
		dbEngine.connnect();
	}
	
	//---------------------------------------------------------
	
	public String[] getARow(String StrIn) {
		
		ResultSetMetaData rsmd = null;
		int colCount=0;
		try {
			ResultSet rs = dbEngine.executeQuery("select * from users where username = '" + StrIn + "'");
			rsmd = rs.getMetaData();
			//move result set pointer to first and only row
			rs.next();
			colCount = rsmd.getColumnCount();//get number of columns
			System.out.println("No of cols: " + colCount);
			String[] fullRow = new String[colCount];
			
			//Fill the string array with the cells from the row
			for(int i=1;i<=colCount;i++) { 
				fullRow[i-1] = rs.getString(i);
	        }
			for(int i=0;i<fullRow.length; i++){System.out.println(fullRow[i]);}//temp
			return fullRow;
		}
		catch (SQLException e) {
			System.out.println("No matching entries found !!!!");
			System.err.println("SQLException: " + e.getMessage());
		}
		//We can error handle an incorrect entry from here ////////////////////////////////////////////////////
		System.out.println("No matching entries found !!");
		JOptionPane.showMessageDialog(null, "Incorrect Username or password", "Log In Error", JOptionPane.ERROR_MESSAGE);
		return null;
		
		//System.out.println(message);
	}

	
	//-------------------------------------------------------------
	//we can use this method for all the username/password checking
	//-------------------------------------------------------------
	public void checkResult(String[] toBeChecked) {

		String userIn = LoginWindow.getUserInput();
		String passIn = LoginWindow.getPassword();
		
		System.out.println(userIn);//////////////////////////////////////////////////////////////////////temp??????
		for(int i=0;i<toBeChecked.length; i++){System.out.println(toBeChecked[i]);}//////////////////////////temp
		
		if(toBeChecked[0].equals(userIn) && toBeChecked[1].equals(passIn)){
			System.out.println("service screen load");
			//go to the main window with the user type in toBeChecked[2]
			Mainframe.youreIn(toBeChecked[2]);
		}
		else{
			System.out.println("Incorrect Login");
			
		}
		
	}
	
	//---------------------------------------------------------

	
}//end class LoginManager

