
package treadmillWithDb;

import java.sql.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/** 
 * This class is a GUI front end for a mySQL database. 
 * It assumes a stock inventory database and will display the 
 * database product details in a JTable and allow the user to 
 * select an item from the JTable and give them details about 
 * the product manufacturer. <p>
 *
 * @author	Simon McLoughlin
 * @see mySQLEngine
 * Modified by D.Walshe for the purposes of this project
 * mainly to allow the window be displayed as a JInternal Frame
 */

@SuppressWarnings("serial")
public class GUIFrontEnd extends JInternalFrame implements ListSelectionListener{
	
	
	//Table for stock details
	JTable patientTable = null;
	
	//scroll pane for stocktable
	JScrollPane scrollPane;
	
	//Database engine for creating DB connection, making queries
	mySQLEngine dbEngine = new mySQLEngine("root","qwerty"); //database engine
	
	/**
	 * Constructor for GUIFrontEnd JFrame, calls constructor in 
	 * super class JFrame and calls the {@link #init() init} method
	 * @param title the title of the GUIFrontEnd JFrame
	 */
	public GUIFrontEnd(String title) {
		super(title);
		init();
		setSize(880, 250);
		setLocation(0, 325);
		setVisible(true);
	}
	
	/**
	 * Create connection to the DB and call {@link #populatePatientTable() populatePatientTable}.
	 * this call would normally be triggered by a user in a real 
	 * (non-demo) application. 
	 */
	public void init() {
		dbEngine.connnect();
		populatePatientTable();
	}
	
	/**
	 * method to retrieve patient details from the database 
	 * and display them in a JTable.
	 */
	public void populatePatientTable() {
		
		//select everything from users table
		ResultSet rs;
		ResultSetMetaData rsmd = null;
		int colCount=0;
		String [] colNames = null;
		
		//get the column names from the ResultSet metadata
		try {
			rs = dbEngine.executeQuery("select * from patient");
			rsmd = rs.getMetaData();
			colCount = rsmd.getColumnCount();
	        colNames = new String[colCount];
	        for(int i=1;i<=colCount;i++) {
	        	colNames[i-1] = rsmd.getColumnName(i);
	        }
	        
	        //JTables have a view class and a control class, the view class
			//handles the drawing of the JTable, the Model class handles the properties
			//and the data
			
			//Create a table model (used for controlling a JTable)
			DefaultTableModel model = new DefaultTableModel(colNames,0);
			patientTable = new JTable(model);
			
			//Similarly a ListSelectionModel represents the current state of the selection
			//for components (like JTables) 
			DefaultListSelectionModel dlsm = new DefaultListSelectionModel();
			//allow single selection only from patient Table
			dlsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			patientTable.setSelectionModel(dlsm);
			dlsm.addListSelectionListener(this); //lets use this JFrame as the event handler for
												 //when an item is selected
			
			String [] currentRow = new String[colCount];//array to hold the row data
			while(rs.next()) { //move the rs pointer on to the next record (starts before the 1st)
				for(int i=1;i<=colCount;i++) {
					currentRow[i-1] = rs.getString(i);
				}
				model.addRow(currentRow); //add the row to the table through the table model
			}
		}
		catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		}
		
		scrollPane = new JScrollPane(patientTable);//add the table to a scroll pane
		this.getContentPane().add(scrollPane);
	}
	
	/** Event handler for the list selection model
	 * 	This will get the manufacturer ID from the selected row
	 * 	in the stock table and pass it to show
	 * 
	 * 	@param e The ListSelectionEvent details
	 */
	public void valueChanged(ListSelectionEvent e) {
		//table row and column indexes start at zero, hence some -1's
		//note that I could (and probably should) of performed an sql query 
		//to get the column index for patientID, rather than using a prior knowledge
		String patientID = (String) patientTable.getValueAt(patientTable.getSelectedRow(), patientTable.getColumnCount()-9);
		String patientName = (String) patientTable.getValueAt(patientTable.getSelectedRow(), patientTable.getColumnCount()-11);
		showPatientDialog(patientID, patientName);
		System.out.println(patientID);System.out.println(patientName);
	}
	
	/**
	 * Form and execute a query to get the session details
	 * for a particular patient. The patient is the one selected
	 * by the user. Display results in a dialog box. and set the
	 * name and ID fields in the load session fields for convenience of use
	 * 
	 * @param patientIDIn The patientID used in the query and set in the LoadProfile Window
	 * 
	 */
	public void showPatientDialog(String patientIDIn, String patientNameIn) {
		
		ResultSetMetaData rsmd = null;
		int colCount=0;
		String message = "Patient Session Details:\n";
		try {
			ResultSet rs = dbEngine.executeQuery("select * from session where sessionID='"+patientIDIn+"'");
			rsmd = rs.getMetaData();
			rs.next();//move result set pointer to first and only row
			colCount = rsmd.getColumnCount();//get number of columns
			//create a patient details message string
	        for(int i=1;i<=colCount;i++) {
	        	message = message + rsmd.getColumnName(i)+": "+rs.getString(i)+"\n"; 
	        }
	        //set the fields in the load profile window for user convenience
	        Mainframe.aLoadProfileWindow.setID(patientIDIn);
	        Mainframe.aLoadProfileWindow.setName(patientNameIn);
		}
		catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		}
		JOptionPane.showMessageDialog(this, message); //show details in a dialog box
	}
	


	/**
	 * The method to instantiate GUIFrontEnd and show it.
	 * @param titleIn A title for the window
	 */
	public static void ShowTable(String titleIn){
		GUIFrontEnd gui = new GUIFrontEnd(titleIn);
		//gui.pack();
		gui.setVisible(true);
	}
		

}
