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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
/**A window to accept username and password.
 * @author Daragh Walshe	Student# B00064428
 * Group: Group 1			Date:  March 2014
 * Treadmill Project	Year 2
 * COMP H2027 - Software Engineering and Testing
 */

//--------------------------------------------------------------------------
class LoginWindow extends JInternalFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton logInButton;
	JTextField userField;
	JPasswordField passwordField;
	protected String password;
	
	//static Shapes motor;
	
	//-----------------------------------------------------------------------
	/**
	 * Constructor for the log in window
	 */
	public LoginWindow(){

		//set up main window
		super("Login", false, false, false, false);
		setSize(500,350);
		setLocation(200, 75);
				
		Font titleFont = new Font("Meiryo", Font.PLAIN, 28);
		Font normalFont = new Font("Meiryo", Font.PLAIN, 14);
		Border blankBorder = BorderFactory.createEmptyBorder(25,40,50,40);//top,r,b,l

		
		JPanel outerPanel = new JPanel(new BorderLayout());
		outerPanel.setBorder(blankBorder);

		//The title styling
		JLabel titleLabel = new JLabel("Log In", JLabel.CENTER);
		styleLabel(titleLabel).setFont(titleFont);
		JPanel titlePanel = new JPanel();
		titlePanel.add(titleLabel);
		stylePanel(titlePanel);
			
		
		//------------------------------------------------------------left
		JLabel userLabel = new JLabel("Username:", JLabel.CENTER);
		styleLabel(userLabel).setFont(normalFont);
		JPanel userPanel = new JPanel();
		userPanel.add(userLabel);
		stylePanel(userPanel);

		JLabel passLabel = new JLabel("Password:", JLabel.CENTER);
		styleLabel(passLabel).setFont(normalFont);
		JPanel passwordPanel = new JPanel();
		passwordPanel.add(passLabel);
		stylePanel(passwordPanel);
	
		JPanel leftPanel = new JPanel(new GridLayout(4, 1, 15, 15));
		leftPanel.setPreferredSize(new Dimension(150,0));
		leftPanel.add(new JLabel(""));	
		leftPanel.add(userPanel);
		leftPanel.add(passwordPanel);
		
		//-----------------------------------------------------------right
		userField = new JTextField(20);
		passwordField = new JPasswordField(20);
		JPanel rightPanel = new JPanel(new GridLayout(4, 1, 15, 15));
		rightPanel.add(new JLabel(""));
		rightPanel.add(userField);
		rightPanel.add(passwordField);

		//-------------------------------------------------------------bottom
		logInButton = new JButton("Log In");
		logInButton.addActionListener(this);
		styleButton(logInButton);
		rightPanel.add(logInButton);
		
		//---------------------------------------------------------------
		outerPanel.add(titlePanel, BorderLayout.NORTH);
		outerPanel.add(leftPanel, BorderLayout.WEST);
		outerPanel.add(rightPanel, BorderLayout.EAST);

		Container c = getContentPane();
		c.add(outerPanel);

		//pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		}//end LoginWindow
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
	 * @param PanelIn : a JLabel to be styled by this method
	 * @return the newly styled label
	 */
	public JPanel stylePanel(JPanel PanelIn){
		//PanelIn.setForeground(Color.white);
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
	 * A method to handle the submit button for the log-in process
	 * 
	 */
	
	private static String user;
	private static String passString;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == logInButton){
			user = userField.getText();
			char[] passwordEntered = passwordField.getPassword();
			passString = new String(passwordEntered);
			
			System.out.println("value at username: " + user);
			System.out.println("value at password: " + passString);
 	
			new LoginManager(user);
		}
	}
	//------------------------------------------------------------	
	/**
	 * A getter method for the username entered
	 * @return user the username entered
	 */
	public static String getUserInput(){
		return user;
	}
	/**
	 * A getter method for the password entered by the user
	 * @return passString the password entered
	 */
	public static String getPassword(){
		return passString;
	}
	//------------------------------------------------------------
	
}//end class LoginWindow








