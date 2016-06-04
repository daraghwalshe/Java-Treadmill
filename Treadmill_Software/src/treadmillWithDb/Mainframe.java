
package treadmillWithDb;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.Border;

/**The main GUI which will hold all the JInternal Frames for the application.
 * @author Daragh Walshe	Student# B00064428
 * Group: Group 1			Date:  March 2014
 * Treadmill Project	Year 2
 * COMP H2027 - Software Engineering and Testing
 */

class Mainframe extends JFrame {

	/**
	 * This is the main Frame which will hold all of the JInternal Frames
	 * for the different aspects of the treadmill application GUI
	 */
	private static final long serialVersionUID = 1L;
	
	//global variables
	JMenuItem mouseItem, gameItem, exitItem;
	//JMenuBar myMenuBar;//   <<<------------------------add in when log-in good
	static JDesktopPane desktop;
	JInternalFrame welcome;
	static LoginWindow aLoginWindow;
	static WelcomeWindow aWelcomeWindow;
	static NewProfileWindow aNewProfileWindow;
	static NewProfile2Window aNewProfile2Window;
	static LoadProfileWindow aLoadProfileWindow;
	static ControllerWindow aControllerWindow;
	static GUIFrontEnd aGUIFrontEnd;
	Border blankBorder;
	

	//-----------------------------------------------------------------------
	public static void main(String args[]){

		//set the look and feel to 'Nimbus'
		try{
			for(LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
				if("Nimbus".equals(info.getName())){
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch(Exception e){
			}

		new Mainframe();

		}//end main
	//-----------------------------------------------------------------------

	//-----------------------------------------------------------------------
	/**
	 * Constructor for the Master GUI Frame.
	 * All other GUI windows in the application are children of this Frame,
	 * and are implemented as JInternal Frames.
	 */
	public Mainframe(){
			//set size, location and title of window
			super("Assignment 2");
			setSize(900,600);
			setLocation(150,50);

			//create a new menu-bar
			//setJMenuBar(makeMenuBar());//   <<<------------------------add in when log-in good

			//a many layered container - necessary for JInternalFrames
			desktop = new JDesktopPane();

			//makes a login window
			aLoginWindow = new LoginWindow();
			desktop.add(aLoginWindow);
			desktop.repaint();

			setContentPane(desktop);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
		}//end public mouseWords
	//-----------------------------------------------------------------------

	//-----------------------------------------------------------------------
	/**
	 * 
	 * @return a JMenuBar for the main application
	 * This menuBar will only be added to the GUI
	 * after a user has logged in successfully.
	 * A different menu bar will be loaded depending on
	 * the type of user who logs into the system
	 */
	public JMenuBar makeMenuBar(){

		//create a new menu-bar
		JMenuBar aMenuBar = new JMenuBar();

		return aMenuBar;
		}//end makeMenuBar
	//-----------------------------------------------------------------------
	/**
	 * Wipe out the log in screen and load a new window
	 * depending on who logged in
	 * 
	 */
	public static void youreIn(String typeOfUser){
		final String USERTYPE1 = "srv";
		final String USERTYPE2 = "med";
		
		if(typeOfUser.equals(USERTYPE1)){
			//makes a service window
			System.out.println(typeOfUser);
			ServiceLogInWindow aServiceLogInWindow = new ServiceLogInWindow();
			desktop.add(aServiceLogInWindow);
			desktop.remove(aLoginWindow);
			desktop.repaint();
		}
		else if(typeOfUser.equals(USERTYPE2)){
			//makes a welcome window
			System.out.println(typeOfUser);
			aWelcomeWindow = new WelcomeWindow();
			desktop.add(aWelcomeWindow);
			desktop.remove(aLoginWindow);
			desktop.repaint();
		}

	}//end youreIn
	//-----------------------------------------------------------------------

	//-----------------------------------------------------------------------
	/**
	 * Wipe out the welcome screen and load a new profile window
	 * to start collecting the patients details
	 * 
	 */
	public static void displayNewProfileWindow(){
		
		//makes a NewProfileWindow window
		aNewProfileWindow = new NewProfileWindow();
		desktop.add(aNewProfileWindow);
		desktop.remove(aWelcomeWindow);
		desktop.repaint();
		
	}//end displayNewProfileWindow
	//-----------------------------------------------------------------------
	/**
	 * Wipe out the first new profile window and load the second
	 * to finish collecting the patients details
	 * 
	 */
	public static void displayNewProfile2Window(String[] detailsIn){
		
		//makes a NewProfileWindow window
		aNewProfile2Window = new NewProfile2Window(detailsIn);
		desktop.add(aNewProfile2Window);
		desktop.remove(aNewProfileWindow);
		desktop.repaint();
		
	}//end displayNewProfile2Window
	//-----------------------------------------------------------------------
	/**
	 * Wipe out the welcome window and load the LoadProfileWindow
	 * to get the userId of the session to be loaded
	 * 
	 */
	public static void displayLoadProfileWindow(){
		
		//makes a new Patient Details Window
		aGUIFrontEnd = new GUIFrontEnd("Patient Details");
		desktop.add(aGUIFrontEnd);

		//makes a new Profile Window window
		aLoadProfileWindow = new LoadProfileWindow();
		desktop.add(aLoadProfileWindow);
		desktop.remove(aWelcomeWindow);
		desktop.repaint();
		
	}//end displayLoadProfileWindow
	//-----------------------------------------------------------------------	
	//-----------------------------------------------------------------------
	/**
	 * Erase the Load profile window and the patient details table
	 * load the Controller Window.
	 * pass the patient name and session data to the controller
	 */
	public static void displayControllerWindow(int[] sessionData, String nameIn){
		
		//makes a new Controller Window
		aControllerWindow = new ControllerWindow(sessionData, nameIn);
		desktop.add(aControllerWindow);
		desktop.remove(aLoadProfileWindow);
		desktop.remove(aGUIFrontEnd);
		desktop.repaint();
		
	}//end displayLoadProfileWindow
	//-----------------------------------------------------------------------	

	}//end class MainFrame
