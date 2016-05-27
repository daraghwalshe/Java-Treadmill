package treadmillWithDb;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
/**
 * @author Szabolcs Kovacs	Student# B00063874
 * Group: Grp 1				Date: March 2014
 * Treadmill Project		Year 2
 * COMP H2027 - Software Engineering and Testing
 *
 */
public class NewProfile2Window extends JInternalFrame implements ActionListener {


	/**
	 * Attributes hold all the GUI components
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel mainPanel, titlePanel, genderPanel, heightPanel, weightpanel, pnlMedication, pnlDr, pnlComment;
	private JLabel titleLabel, genderLabel, lblHeight, lblWeight, lblMedication, lblDoctor;
	private JRadioButton rdbtnMale, rdbtnFemale;	
	private JTextField txtfldHeight, txtFldMedication, txtFldWeight, txtFldDr;
	private JTextArea txtAreaComments;
	private JButton btnSubmit, btnReset;
	ButtonGroup btnGrp = new ButtonGroup();
	boolean male = false;
	boolean female = false;
	String[] patientDetails = new String[11];
	
	/**
	 * Create the JInternalFrame. This is the second part of the "create a new profile" interface.
	 * The user able to complete the form or reset all the fields 
	 */
	public NewProfile2Window(String[] halfDetails) {
				
		super("Service Log In Window", false, false, false, false);
		setBounds(00, 00, 880, 500);
		
		
		for(int i=0; i<halfDetails.length; i++){
			patientDetails[i] = halfDetails[i];
		}
//---------------------------------------------------------------------------------------------------------
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 864, 471);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
//---------------------------------------------------------------------------------------------------------		
		titlePanel = new JPanel();
		titlePanel.setBackground(Color.DARK_GRAY);
		titlePanel.setBounds(10, 11, 827, 60);
		mainPanel.add(titlePanel);
		titlePanel.setLayout(null);

		titleLabel = new JLabel("Create  New Profile");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Meiryo", Font.PLAIN, 28));
		titleLabel.setBounds(22, 11, 783, 47);
		titlePanel.add(titleLabel);
//---------------------------------------------------------------------------------------------------------		
		genderPanel = new JPanel();
		genderPanel.setBackground(Color.DARK_GRAY);
		genderPanel.setBounds(10, 88, 117, 28);
		mainPanel.add(genderPanel);

		genderLabel = new JLabel("Gender");
		genderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		genderLabel.setForeground(Color.WHITE);
		genderLabel.setFont(new Font("Meiryo", Font.PLAIN, 14));
		genderPanel.add(genderLabel);

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Meiryo", Font.PLAIN, 12));
		rdbtnMale.setBounds(194, 93, 89, 23);
		btnGrp.add(rdbtnMale);
		mainPanel.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Meiryo", Font.PLAIN, 12));
		rdbtnFemale.setBounds(336, 93, 80, 23);
		btnGrp.add(rdbtnFemale);
		mainPanel.add(rdbtnFemale);
//---------------------------------------------------------------------------------------------------------		
		heightPanel = new JPanel();
		heightPanel.setBackground(Color.DARK_GRAY);
		heightPanel.setBounds(10, 127, 117, 28);
		mainPanel.add(heightPanel);
		
		lblHeight = new JLabel("Height");
		lblHeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeight.setForeground(Color.WHITE);
		lblHeight.setFont(new Font("Meiryo", Font.PLAIN, 14));
		heightPanel.add(lblHeight);

		txtfldHeight = new JTextField();
		txtfldHeight.setFont(new Font("Meiryo", Font.PLAIN, 12));
		txtfldHeight.setBounds(194, 127, 167, 28);
		mainPanel.add(txtfldHeight);
		txtfldHeight.setColumns(10);
//---------------------------------------------------------------------------------------------------------		
		weightpanel = new JPanel();
		weightpanel.setBackground(Color.DARK_GRAY);
		weightpanel.setBounds(394, 127, 139, 28);
		mainPanel.add(weightpanel);
		
		lblWeight = new JLabel("Weight");
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight.setForeground(Color.WHITE);
		lblWeight.setFont(new Font("Meiryo", Font.PLAIN, 14));
		weightpanel.add(lblWeight);
		
		txtFldWeight = new JTextField();
		txtFldWeight.setFont(new Font("Meiryo", Font.PLAIN, 12));
		txtFldWeight.setBounds(593, 127, 244, 28);
		mainPanel.add(txtFldWeight);
		txtFldWeight.setColumns(10);
//---------------------------------------------------------------------------------------------------------
		pnlMedication = new JPanel();
		pnlMedication.setBackground(Color.DARK_GRAY);
		pnlMedication.setBounds(10, 165, 117, 28);
		mainPanel.add(pnlMedication);
		
		lblMedication = new JLabel("Medication");
		lblMedication.setHorizontalAlignment(SwingConstants.LEFT);
		lblMedication.setFont(new Font("Meiryo", Font.PLAIN, 14));
		lblMedication.setForeground(Color.WHITE);
		pnlMedication.add(lblMedication);
		
		txtFldMedication = new JTextField();
		txtFldMedication.setBounds(194, 166, 643, 27);
		mainPanel.add(txtFldMedication);
		txtFldMedication.setColumns(10);
//---------------------------------------------------------------------------------------------------------		
		pnlDr = new JPanel();
		pnlDr.setBackground(Color.DARK_GRAY);
		pnlDr.setBounds(10, 205, 117, 28);
		mainPanel.add(pnlDr);
		
		lblDoctor = new JLabel("Doctor");
		lblDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctor.setFont(new Font("Meiryo", Font.PLAIN, 14));
		lblDoctor.setForeground(Color.WHITE);
		pnlDr.add(lblDoctor);
		
		txtFldDr = new JTextField();
		txtFldDr.setFont(new Font("Meiryo", Font.PLAIN, 12));
		txtFldDr.setBounds(193, 204, 644, 29);
		mainPanel.add(txtFldDr);
		txtFldDr.setColumns(10);
//		txtFldDr.setEditable(false);
//---------------------------------------------------------------------------------------------------------
		pnlComment = new JPanel();
		pnlComment.setBackground(Color.DARK_GRAY);
		pnlComment.setBounds(10, 244, 184, 29);
		mainPanel.add(pnlComment);
		
		JLabel lblComments = new JLabel("Comments");
		lblComments.setForeground(Color.WHITE);
		lblComments.setFont(new Font("Meiryo", Font.PLAIN, 14));
		pnlComment.add(lblComments);
		
		txtAreaComments = new JTextArea();
		txtAreaComments.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtAreaComments.setBounds(10, 284, 827, 114);
		mainPanel.add(txtAreaComments);
//---------------------------------------------------------------------------------------------------------
		btnSubmit = new JButton("Submit");
		btnSubmit .setForeground(Color.WHITE);
		btnSubmit .setBackground(Color.DARK_GRAY);
		btnSubmit .setFont(new Font("Meiryo", Font.PLAIN, 14));
		btnSubmit .setBounds(10, 417, 150, 35);
		mainPanel.add(btnSubmit);
		btnSubmit.addActionListener(this);
		
		btnReset = new JButton("Reset");
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(Color.DARK_GRAY);
		btnReset.setFont(new Font("Meiryo", Font.PLAIN, 14));
		btnReset.setBounds(687, 417, 150, 35);
		mainPanel.add(btnReset);
//---------------------------------------------------------------------------------------------------------
		setVisible(true);
		Container c = getContentPane();
		c.add(mainPanel);
		getContentPane().setLayout(null);
		
	}
	/**
	 * This method performs either submit the form or remove all user's input 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String patientGender = null;
		
		if(e.getSource() == btnSubmit) {
			System.out.println("submit btn pressed");
			if(male) {
				patientGender = "male";
				female = false;
			}
			if(female) {
				patientGender = "female";
				male = false;
			}
			//Sabi - changed this bit to make it work with other windows
   		    patientDetails[5] = patientGender;
			patientDetails[6] = txtfldHeight.getText();
			patientDetails[7] = txtFldWeight.getText();
			patientDetails[8] = txtFldMedication.getText();
			patientDetails[9] = txtFldDr.getText();
			patientDetails[10] = txtAreaComments.getText();
		}
		if(e.getSource() == btnReset) {
			txtfldHeight.setText(""); 
			txtFldMedication.setText(""); 
			txtFldWeight.setText(""); 
			txtFldDr.setText("");
			txtAreaComments.setText("");
		}

		//send the details off to be written to the database
		new RunQuery(patientDetails);
		
	}
}
