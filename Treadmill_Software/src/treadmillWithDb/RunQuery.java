package treadmillWithDb;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**A class to perform a sql query to load a row into the patient database.
 * @author Daragh Walshe	Student# B00064428
 * Group: Group 1			Date:  March 2014
 * Treadmill Project	Year 2
 * COMP H2027 - Software Engineering and Testing
 */
public class RunQuery {

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
	 * @param patientDetails 
	 */
	public RunQuery(String[] patientDetails) {
		init();
		runQuery(patientDetails);
		System.out.println("in run Query 1");
	}
	
	public void init() {
		dbEngine.connnect();
		//runQuery();
	}
	
	//---------------------------------------------------------
	
	public void runQuery() {
		
		try {
			// Create a query and send to the db engine for insertion
			String sql = "INSERT INTO users (username, password, usertype) " +
						 "VALUES ('Daragh', 'daragh01', 'neither')";
			dbEngine.insertQuery(sql);
		}
		catch (SQLException e) {
			System.out.println(e);
			System.err.println("SQLException: " + e.getMessage());
		}

	}
	//---------------------------------------------------------
	/**
	 * Places the elements of the String array into an sql query
	 * to be inserted into the patient table in the database
	 * @param newPatient A string array holding the patients details
	 */
	public void runQuery(String[] newPatient) {
		String sql = null;
		System.out.println("in run Query 2");
		sql = "INSERT INTO patient VALUES (";
		
		for(int i=0; i<newPatient.length-1; i++){
			sql += "'" + newPatient[i] + "',";
		}
		sql += "'" + newPatient[newPatient.length-1] + "'";
		sql += ")";
		try {
			// Send to the db engine for insertion
			dbEngine.insertQuery(sql);
		}
		catch (SQLException e) {
			System.out.println(e);
			System.err.println("SQLException: " + e.getMessage());
			String errorMessage = "SQLException: " + e.getMessage();
			JOptionPane.showMessageDialog(null, errorMessage, "Database Error", JOptionPane.ERROR_MESSAGE);
		}	
		
	}
	//---------------------------------------------------------
	
}//end class RunQuery

