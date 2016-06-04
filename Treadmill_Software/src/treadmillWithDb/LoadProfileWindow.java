package treadmillWithDb;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
/**This class is to enable a user to load patient details and load the controller window with the session parameters.
 * 
 * @author Daragh Walshe	Student# B00064428
 * Group: Group 1			Date:  March 2014
 * Treadmill Project	Year 2
 * COMP H2027 - Software Engineering and Testing
 */

//--------------------------------------------------------------------------
class LoadProfileWindow extends JInternalFrame implements ActionListener{


	/**
	 * Create connection to the DB
	 * Query it for a single row in the password table
	 *  
	 */

	//---------------------------------------------------------
	//Database engine for creating DB connection, making queries
	mySQLEngine dbEngine = new mySQLEngine("root","qwerty"); //sql user name and password
	
	public void init() {
		dbEngine.connnect();
	}
	
	//---------------------------------------------------------
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton enterButton, resetButton;
	JTextField patientNameField, patientIDField;
	
	/**
	 * A setter method for the patient Name Field
	 * @param nameIn the string to set in the patient Name Field
	 */
	public void setName(String nameIn){
		patientNameField.setText(nameIn);
	}
	/**
	 * A setter method for the patient ID Field
	 * @param iDIn the string to set in the patient ID Field
	 */
	public void setID(String iDIn){
		patientIDField.setText(iDIn);
	}

	//-----------------------------------------------------------------------
	/**
	 * A GUI to take a patient name and ID in order to search the database for their profile
	 */
	public LoadProfileWindow(){

		//set up main window
		super("Load Profile", false, false, false, false);
		setSize(500,350);
		setLocation(200, 0);
		
		Font titleFont = new Font("Meiryo", Font.PLAIN, 28);
		Font normalFont = new Font("Meiryo", Font.PLAIN, 14);
		Border blankBorder = BorderFactory.createEmptyBorder(25,40,50,40);//top,r,b,l
		
		JPanel outerPanel = new JPanel(new BorderLayout());
		outerPanel.setBorder(blankBorder);

		//The title styling
		JLabel titleLabel = new JLabel("Load Profile", JLabel.CENTER);
		styleLabel(titleLabel).setFont(titleFont);
		JPanel titlePanel = new JPanel();
		titlePanel.add(titleLabel);
		stylePanel(titlePanel);
			
		
		//------------------------------------------------------------left
		JLabel idLabel = new JLabel("Patient ID:", JLabel.CENTER);
		styleLabel(idLabel).setFont(normalFont);
		JPanel idPanel = new JPanel();
		idPanel.add(idLabel);
		stylePanel(idPanel);

		JLabel patientNameLabel = new JLabel("Patient Name:", JLabel.CENTER);
		styleLabel(patientNameLabel).setFont(normalFont);
		JPanel patientNamePanel = new JPanel();
		patientNamePanel.add(patientNameLabel);
		stylePanel(patientNamePanel);
	
		JPanel leftPanel = new JPanel(new GridLayout(4, 1, 15, 15));
		leftPanel.setPreferredSize(new Dimension(150,0));
		leftPanel.add(new JLabel(""));	
		leftPanel.add(idPanel);
		leftPanel.add(patientNamePanel);
		
		//-----------------------------------------------------------right
		patientIDField = new JTextField(20);
		patientNameField = new JTextField(20);
		JPanel rightPanel = new JPanel(new GridLayout(4, 1, 15, 15));
		rightPanel.add(new JLabel(""));
		rightPanel.add(patientIDField);
		rightPanel.add(patientNameField);

		//-----------------------------------------------------------buttons
		enterButton = new JButton("Load Profile");
		enterButton.addActionListener(this);
		styleButton(enterButton);
		rightPanel.add(enterButton);
		
		resetButton = new JButton("Reset");
		resetButton.addActionListener(this);
		styleButton(resetButton);
		leftPanel.add(resetButton);
		
		//---------------------------------------------------------------
		outerPanel.add(titlePanel, BorderLayout.NORTH);
		outerPanel.add(leftPanel, BorderLayout.WEST);
		outerPanel.add(rightPanel, BorderLayout.EAST);

		Container c = getContentPane();
		c.add(outerPanel);

		//pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		}//end LoadProfileWindow
	//-----------------------------------------------------------------------
	/**
	 * A method which takes in a JLabel for styling
	 * @param labelIn : a JLabel to be styled by this method
	 * @return the newly styled label
	 */
	public JLabel styleLabel(JLabel labelIn){
		
		labelIn.setForeground(Color.white);
		labelIn.setBackground(Color.darkGray);
		labelIn.setOpaque(true);
		return labelIn;

		}//end styleLabel
	//------------------------------------------------------------------
	
	//------------------------------------------------------------------
	/**
	 * A method which takes in a JLabel for styling
	 * @param PanelIn : a JPanel to be styled by this method
	 * @return the newly styled label
	 */
	public JPanel stylePanel(JPanel PanelIn){
		PanelIn.setBackground(Color.darkGray);
		PanelIn.setOpaque(true);
		return PanelIn;

		}//end styleLabel
	//------------------------------------------------------------------
	
	//------------------------------------------------------------------
	/**
	 * A method which takes in a JButton for styling
	 * @param buttonlIn : a JButton to be styled by this method
	 * @return the newly styled JButton
	 */
	public JButton styleButton(JButton buttonlIn){		
		buttonlIn.setForeground(Color.white);
		buttonlIn.setBackground(Color.darkGray);
		return buttonlIn;

		}//end styleButton
	//------------------------------------------------------------------
	
	/**
	 * A method to handle the enter and reset buttons
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == resetButton){
			patientNameField.setText("");
			patientIDField.setText("");
		}
		
		if(e.getSource() == enterButton){
			String name = patientNameField.getText();
			String id = patientIDField.getText();
			
			System.out.println("value at patientID: " + id);
			System.out.println("value at patientName: " + name);
			
			/*-------------------------------------------------*/
			init();
			//get the row in a nice array
			int[] sessionData = getASession(id);
			for(int i=0;i<sessionData.length; i++){System.out.println(sessionData[i]);}
			/*-------------------------------------------------*/
			//create a new controller window and pass it the session info
			Mainframe.displayControllerWindow(sessionData, name);
		}
		
	}//end ActionPerformed
//--------------------------------------------------------------
		
	/**
	 * @param StrIn - the patientID to search for the session
	 * @return an integer array with the values for the session
	 */
	public int[] getASession(String StrIn) {
		
		System.out.println("In getASession method with sessID: " + StrIn);
		
		ResultSetMetaData rsmd = null;
		int colCount=0;
		try {
			ResultSet rs = dbEngine.executeQuery("select * from session where sessionID = '" + StrIn + "'");
			rsmd = rs.getMetaData();
			//move result set pointer to first and only row
			rs.next();
			colCount = rsmd.getColumnCount();//get number of columns

			int[] fullRow = new int[colCount-1];
			System.out.println("size of int array :"+(colCount-1));
				
			//Fill the int array with the cells from the row
			//Start from the second column as we have the session id already
			//and we are using an int[], and first element is a string
			for(int i=1;i<colCount;i++) { 
				fullRow[i-1] = rs.getInt(i+1);
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
		JOptionPane.showMessageDialog(null, "User has no session information", "Session Load Error", JOptionPane.ERROR_MESSAGE);
		return null;
		
		//System.out.println(message);
	}

	
//--------------------------------------------------------------
}//end class LoadProfileWindow





