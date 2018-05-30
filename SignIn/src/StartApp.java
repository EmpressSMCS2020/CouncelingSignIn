//IMPORTS------------------------------------------------------------------------------------------------------------

import java.awt.Color;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.codoid.products.fillo.*;
import java.awt.event.ActionListener;


public class StartApp {
//FIELDS------------------------------------------------------------------------------------------------------------

//customizable variables																		//find a way to get these inputs without changing code
	public static String filepath = "D:/Documents/COUNSELING_SIGN_IN/phslogo.png";
	public static Color logocolor = Color.getHSBColor((float)0.12, (float)0.74, (float)1.0);
	public static String fileloc = "H:\\Downloads\\SaveInfoTo.xlsx";
	//import excel file
	//teacher names + emails list
	//student id+name+teacher+counselor list *
	//list of reasons - guiscreen class

//other
	public static GUIScreen g;
	
//data logging info
	public static String ID = "";
	private static String getname = GUIScreen.getnameclone;															//find a way to get name (not here)
	public static String REASON = "";
	public static String TEACHER = "";
	public static String COUNSELOR = "";
	public static String FIRST = getname.substring(0,getname.indexOf(' '));
	public static String LAST = getname.substring(getname.indexOf(' '),getname.length());
	public static String HOUSE = "";	
	public static String GRADE = "";
	public static Fillo fillo=new Fillo();
	public static Connection connection;
	

//MAIN----------------------------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) throws FilloException { 
		g = new GUIScreen(filepath, logocolor);													//add other textfile parameters
		listenForActions(g);
		g.setVisible(true);
		connection = fillo.getConnection(fileloc);
	}
	
//METHODS--------------------------------------------------------------------------------------------------------------------

	public static void listenForActions(GUIScreen g) {
		g.cont.addActionListener((ActionListener) g);
		g.inputID.addActionListener((ActionListener) g);
		g.inputReason.addActionListener((ActionListener) g);
		
		g.cancel.addActionListener((ActionListener) g);
		
		g.finish.addActionListener((ActionListener) g);
		g.enterTeacher.addActionListener((ActionListener) g);
		g.enterCounselor.addActionListener((ActionListener) g);
	}
	
	public static void addExcelEntry() throws FilloException {
		
		System.out.println("excel entry completed! " + ID + REASON);
		String insert = "INSERT INTO sheet1(First, Last, ID, Teacher, Councelor, Reason, House, Grade) VALUES(";
		String data = "'" + FIRST + "'" + "," +"'" + LAST+ "'" +  "," + "'" + ID + "'"+ ","+ "'" + TEACHER + "'"+ ","+ "'" + COUNSELOR + "'"+ ","+ "'" + REASON + "'"+ "," + "'" + HOUSE + "'"+ "," + "'" + GRADE + "'";
		String strQuery = insert + data + ")";
		connection.executeUpdate(strQuery);
		connection.close();
	}

	public static void sendEmail() {
		System.out.println("email sent! " + ID + REASON);
	}

}

