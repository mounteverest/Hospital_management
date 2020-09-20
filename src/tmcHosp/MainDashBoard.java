package tmcHosp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainDashBoard {

	public static void main(String[] args) throws IOException {

		//list of properties
		//HospitalName = "THANJAVUR MEDICAL CENTER"
		//doctor_db_name = "tmc-doctor-db.txt"
		//nurse_db_name  = "tmc-nurse-db.txt"
		

//		Properties prop = new Properties();
//		String fileName = "C:\\Kalyani\\work\\Java_Hospital\\TMC\\resources";
//		InputStream is = null;
//		try {
//		    is = new FileInputStream(fileName);
//		} 
//		catch (FileNotFoundException ex) {
//		  System.out.println("exception occured");
//		}
//		try {
//		    prop.load(is);
//		} catch (IOException ex) {
//		   System.out.println("");
//		}
//		System.out.println(prop.getProperty("TMC_DOCTOR_DB_NAME"));
//		System.out.println(prop.getProperty("TMC_DOCTOR_ID_LASTCOUNT"));
//		
		
		
		DisplayMainMenu();

	}
	

	
	
	public static void DisplayMainMenu() throws IOException {
		Scanner strInput = new Scanner(System.in);
		String cont="y", choice;
		
		//lets print the main menu here as long as cont="y"
		while(true) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("-----------------TANJAVUR MEDICAL CENTER----------------------");
			System.out.println("--------------------------------------------------------------");
			System.out.println("\t 1........................DOCTOR  MENU");
			System.out.println("\t 2........................PATIENT MENU");
			System.out.println("\t 3........................NURSE MENU");
			System.out.println("\t 4........................EXIT MENU");
			System.out.println("\n\n \t\t Enter your choice: ");
			choice = strInput.nextLine();
			if(choice.equals("1")) {
				//go to doctor menu system
				Doctor doc = new Doctor();
				doc.DisplayDoctorMenu();
			}
			else if (choice.equals("2")) {
				//go to patient system
				
			}
			else if (choice.equals("3")) {
				//got to nurse
			}
			else break;
		}
		//exiting the main menu
		System.out.println("THANK YOU. DO NOT COME AGAIN...");
		
	}
}


 