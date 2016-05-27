package treadmillWithDb;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 * @author Szabolcs Kovacs	Student# B00063874
 * Group: Grp 1				Date: March 2014
 * Treadmill Project		Year 2
 * COMP H2027 - Software Engineering and Testing
 *
 */
class ServiceLogInWindow extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	/** Attributes 
	 */
	JPanel mainPanel, titlePanel;
	JLabel lblServiceLogIn, lblVersion;
	JButton btnDiagnostic, btnUpdate, btnLoadError, btnLogOut;
	JTextArea textAreaInfo;
	/**
	 * The GUI provides an interface for the service man. The user able to run diagnostic tool, update the software and 
	 * print out error log file on the screen.
	 */
	public ServiceLogInWindow() {
		super("Service Log In Window", false, false, false, false);
		setBounds(100, 100, 600, 400);
	
//-----------------------------------------------------------------------------------
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 584, 371);
		mainPanel.setLayout(null);
//-----------------------------------------------------------------------------------		
		titlePanel = new JPanel();
		titlePanel.setBackground(Color.DARK_GRAY);
		titlePanel.setBounds(25, 11, 527, 62);
		mainPanel.add(titlePanel);
		titlePanel.setLayout(null);
//-----------------------------------------------------------------------------------			
		lblServiceLogIn = new JLabel("Service Log in");
		lblServiceLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblServiceLogIn.setForeground(Color.WHITE);
		lblServiceLogIn.setFont(new Font("Meiryo", Font.PLAIN, 28));
		lblServiceLogIn.setBounds(162, 11, 242, 40);
		titlePanel.add(lblServiceLogIn);
//-----------------------------------------------------------------------------------		
		btnDiagnostic = new JButton("Run Diagnostic");
		btnDiagnostic.setBackground(Color.DARK_GRAY);
		btnDiagnostic.setFont(new Font("Meiryo", Font.PLAIN, 14));
		btnDiagnostic.setForeground(Color.WHITE);
		btnDiagnostic.setBounds(25, 97, 154, 42);
		mainPanel.add(btnDiagnostic);
//-----------------------------------------------------------------------------------		
		btnUpdate = new JButton("Update");
		btnUpdate.setBackground(Color.DARK_GRAY);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Meiryo", Font.PLAIN, 14));
		btnUpdate.setBounds(212, 97, 154, 42);
		mainPanel.add(btnUpdate);
//-----------------------------------------------------------------------------------		
		btnLoadError = new JButton("Load error log");
		btnLoadError.setBackground(Color.DARK_GRAY);
		btnLoadError.setForeground(Color.WHITE);
		btnLoadError.setFont(new Font("Meiryo", Font.PLAIN, 14));
		btnLoadError.setBounds(384, 95, 168, 42);
		mainPanel.add(btnLoadError);
//-----------------------------------------------------------------------------------		
		textAreaInfo = new JTextArea();
		textAreaInfo.setBounds(25, 150, 527, 129);
		textAreaInfo.setEditable(false);
		mainPanel.add(textAreaInfo);
//-----------------------------------------------------------------------------------		
		btnLogOut = new JButton("Log out");
		btnLogOut.setBackground(Color.DARK_GRAY);
		btnLogOut.setFont(new Font("Meiryo", Font.PLAIN, 14));
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setBounds(437, 303, 115, 42);
		mainPanel.add(btnLogOut);
//-----------------------------------------------------------------------------------		
		lblVersion = new JLabel("version 2.1");
		lblVersion.setHorizontalAlignment(SwingConstants.CENTER);
		lblVersion.setBounds(495, 348, 79, 22);
		mainPanel.add(lblVersion);
//-----------------------------------------------------------------------------------		
		Container c = getContentPane();
		c.add(mainPanel);
		setVisible(true);
	}
	/**
	 *A method to take the Run diagnostic, Update, Load error log and Log out buttons   
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnDiagnostic) {
			//textAreaInfo.setText("");
			
		}
		if(e.getSource() == btnUpdate) {
			//textAreaInfo.setText("");  ???
		}
//		if(e.getSource() == btnLoadError) {
	/** To display some error == Loading error info from the txt file into the text area (only example, just think about)
			Logger logException = Logger.getLogger("exception.file.example");
			try {
			}catch(NullPointerException ex) {
				try {
						Handler fileOut = new FileHandler("errorLog.txt", true);
						fileOut.setFormatter(new SimpleFormatter());
						logException.addHandler(fileOut);
				}
				catch(IOException ioEx) {
					//ignored
				}
			
			logException.log(Level.SEVERE,"An exception occurred in here");
			}
		} */
		if(e.getSource() == btnLogOut) {
		//	System.exit(0);
		}
	}
}
