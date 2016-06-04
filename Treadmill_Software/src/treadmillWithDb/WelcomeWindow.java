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
import javax.swing.border.Border;
/**A window displayed after successful login.
 * @author Daragh Walshe	Student# B00064428
 * Group: Group 1			Date:  March 2014
 * Treadmill Project	Year 2
 * COMP H2027 - Software Engineering and Testing
 */

//--------------------------------------------------------------------------
class WelcomeWindow extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton loadUserButton, newUserButton;
	
	//-----------------------------------------------------------------------
	public WelcomeWindow(){

		//set up main window
		super("Welcome", false, false, false, false);
		setSize(600, 350);
		setLocation(100, 50);
		
		Font titleFont = new Font("Meiryo", Font.PLAIN, 28);
		Border blankBorder = BorderFactory.createEmptyBorder(25,40,50,40);//top,r,b,l

		JPanel outerPanel = new JPanel(new BorderLayout());
		outerPanel.setBorder(blankBorder);

		//The title styling
		JLabel titleLabel = new JLabel("Welcome", JLabel.CENTER);
		styleLabel(titleLabel).setFont(titleFont);
		JPanel titlePanel = new JPanel();
		titlePanel.add(titleLabel);
		stylePanel(titlePanel);
		
		//----------------------------------------------------------------
		JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
		loadUserButton = new JButton("Load User Profile");
		loadUserButton.addActionListener(this);
		styleButton(loadUserButton);
		newUserButton = new JButton("Create New User Profile");
		styleButton(newUserButton);
		newUserButton.addActionListener(this);
		buttonPanel.setPreferredSize(new Dimension(150,150));
		buttonPanel.add(loadUserButton);
		buttonPanel.add(new JLabel(""));
		
		buttonPanel.add(newUserButton);
		
		JPanel spacerPanel = new JPanel();
		spacerPanel.setPreferredSize(new Dimension(50,50));

		//---------------------------------------------------------------
		outerPanel.add(titlePanel, BorderLayout.NORTH);
		outerPanel.add(spacerPanel, BorderLayout.CENTER);
		outerPanel.add(buttonPanel, BorderLayout.SOUTH);

		Container c = getContentPane();
		c.add(outerPanel);

		//pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		}//end WelcomeWindow
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
	 * A method which takes in a JPanel for styling
	 * @param PanelIn : a JPanel to be styled by this method
	 * @return the newly styled JPanel
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
		
		Color col = new Color(150, 100, 200, 50);
		
		buttonlIn.setForeground(Color.white);
		buttonlIn.setBackground(col);//buttonlIn.setBackground(Color.darkGray);
		return buttonlIn;

		}//end styleButton
	//------------------------------------------------------------------
	/**
	 * Branch off to either Load existing user or create new user
	 * depending on the users choice
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == loadUserButton){
			System.out.println("Load user pressed");
			GUIFrontEnd.ShowTable("Patient Details");
			Mainframe.displayLoadProfileWindow();
		}
		if(e.getSource() == newUserButton){
			System.out.println("New user pressed");
			Mainframe.displayNewProfileWindow();
		}
	}
	
	
	
}//end class WelcomeWindow




