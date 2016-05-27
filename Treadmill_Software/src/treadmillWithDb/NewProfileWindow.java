package treadmillWithDb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**A window to take in patient details for a new patient.
 * @author Daragh Walshe	Student# B00064428
 * Group: Group 1			Date:  March 2014
 * Treadmill Project	Year 2
 * COMP H2027 - Software Engineering and Testing
 */
//--------------------------------------------------------------------------
class NewProfileWindow extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextField patientNameField, patientDOBField, patientPPSField, patientAddField, patientCityField;
	JButton nextButton;
	
	//-----------------------------------------------------------------------
	public NewProfileWindow(){

		//set up main window
		super("Create New Profile", false, false, false, false);
		setSize(882,500);
		
		
		Font titleFont = new Font("Meiryo", Font.PLAIN, 28);
		Font normalFont = new Font("Meiryo", Font.PLAIN, 14);
		Border blankBorder = BorderFactory.createEmptyBorder(25,40,50,40);//top,r,b,l

		
		JPanel outerPanel = new JPanel(new BorderLayout());
		outerPanel.setBorder(blankBorder);

		//The title styling
		JLabel titleLabel = new JLabel("Create New Profile", JLabel.CENTER);
		styleLabel(titleLabel).setFont(titleFont);
		JPanel titlePanel = new JPanel();
		titlePanel.add(titleLabel);
		stylePanel(titlePanel);
			
		//------------------------------------------------------------left
		JLabel nameLabel = new JLabel("Name:", JLabel.CENTER);
		styleLabel(nameLabel).setFont(normalFont);
		JPanel namePanel = new JPanel();
		namePanel.add(nameLabel);
		stylePanel(namePanel);

		JLabel dobLabel = new JLabel("Data of Birth:", JLabel.CENTER);
		styleLabel(dobLabel).setFont(normalFont);
		JPanel dobPanel = new JPanel();
		dobPanel.add(dobLabel);
		stylePanel(dobPanel);
	
		JLabel ppsLabel = new JLabel("PPS No:", JLabel.CENTER);
		styleLabel(ppsLabel).setFont(normalFont);
		JPanel ppsPanel = new JPanel();
		ppsPanel.add(ppsLabel);
		stylePanel(ppsPanel);

		JLabel addressLabel = new JLabel("Address:", JLabel.CENTER);
		styleLabel(addressLabel).setFont(normalFont);
		JPanel addressPanel = new JPanel();
		addressPanel.add(addressLabel);
		stylePanel(addressPanel);		
	
		JLabel cityLabel = new JLabel("City:", JLabel.CENTER);
		styleLabel(cityLabel).setFont(normalFont);
		JPanel cityPanel = new JPanel();
		cityPanel.add(cityLabel);
		stylePanel(cityPanel);	
		
		
		JPanel leftPanel = new JPanel(new GridLayout(7, 1, 15, 15));
		leftPanel.setPreferredSize(new Dimension(150,0));
		leftPanel.add(new JLabel(""));	
		leftPanel.add(namePanel);
		leftPanel.add(dobPanel);
		leftPanel.add(ppsPanel);
		leftPanel.add(addressPanel);
		leftPanel.add(cityPanel);
		
		//-----------------------------------------------------------right
		patientNameField = new JTextField(48);
		patientDOBField = new JTextField(48);
		patientPPSField = new JTextField(48);
		patientAddField = new JTextField(48);
		patientCityField = new JTextField(48);

		JPanel rightPanel = new JPanel(new GridLayout(7, 1, 15, 15));
		rightPanel.add(new JLabel(""));
		rightPanel.add(patientNameField);
		rightPanel.add(patientDOBField);
		rightPanel.add(patientPPSField);
		rightPanel.add(patientAddField);
		rightPanel.add(patientCityField);

		//-----------------------------------------------------------buttons
		nextButton = new JButton("Next >>");
		nextButton.addActionListener(this);
		JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
		styleButton(nextButton);
		buttonPanel.add(new JLabel(""));
		buttonPanel.add(new JLabel(""));
		buttonPanel.add(nextButton);
		rightPanel.add(buttonPanel);
		
		//---------------------------------------------------------------
		outerPanel.add(titlePanel, BorderLayout.NORTH);
		outerPanel.add(leftPanel, BorderLayout.WEST);
		outerPanel.add(rightPanel, BorderLayout.EAST);

		Container c = getContentPane();
		c.add(outerPanel);

		//pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		}//end NewProfileWindow
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
	//-----------------------------------------------------------------------
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
	 * A method to take in the details from the
	 * first screen of the new profile process.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String[] patientDetails = new String[5];
		
		//Prob change for str[]
		if(e.getSource() == nextButton){
			
			try{
					patientDetails[0] = patientNameField.getText();
					patientDetails[1] = patientDOBField.getText();
					patientDetails[2] = patientPPSField.getText();
					patientDetails[3] = patientAddField.getText();
					patientDetails[4] = patientCityField.getText();

				System.out.println("value at patient name: " + patientDetails[0]);
			}
			catch(Exception ee){
				System.out.println("Please fill in all the fields");
			}
			Mainframe.displayNewProfile2Window(patientDetails);
		}
		
		//Mainframe.displayNewProfile2Window(patientDetails);
		
	}//end action-performed
	//------------------------------------------------------------------	

}//end class NewProfileWindow






