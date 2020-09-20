package tmcHosp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.UUID;

public class Doctor {
	
  //make sure the database has same order as follows
	private String 	DID;
	private String 	Name;
	private String 	Speciality;
	private int 	Age;
	private String 	Gender;
	private String 	Education;
	private int 	Availability;
	private String 	MobileNo;
	private double 	Salary;
	private String  uniqueID;
//database fields above
 
	
    String  doctorFileName = ".\\tmc_doctor_db.txt"	;
    
	Scanner strInput = new Scanner(System.in);
	
	public void DisplayDoctorMenu() throws IOException {
		
				String choice="";
			
				while(true) {
					System.out.println("--------------------------------------------------------------");
					System.out.println("-----------------TANJAVUR MEDICAL CENTER----------------------");
					System.out.println("-----------------------DOCTOR MENU--------------------------");
					System.out.println("\t 1........................Add Doctor record");
					System.out.println("\t 2........................View Doctor Record");
					System.out.println("\t 3........................Update Doctor Record");
					System.out.println("\t 4........................Delete Doctor Record");
					System.out.println("\t 5........................Search Records");
					System.out.println("\n\n \t\t Enter your choice: ");
					choice = strInput.nextLine();
					if(choice.equals("1")) {
						//go to doctor menu system
						addRecord();
					}
					else if (choice.equals("2")) {
						//go to View Doctor Records
						viewDoctorRecord();
					}
					else if (choice.equals("3")) {
						//Search doctor record with name
						searchDoctorRecord();
					}
					else break;
				}
				//exiting the main menu
				System.out.println("");
	}

	void addRecord() {
		//get the input record for new doctor
		//store the new doctor record into database (doctor file)
		InputDoctorRecord();
		AddDoctorRecordToDatabase();
	}
	void InputDoctorRecord() {
		UUID uuid = UUID.randomUUID();
		
		System.out.println("DOC_ID:\n\t"+uuid.toString());
		System.out.println("\n\n\t Enter Doctor Name:");
		uniqueID = uuid.toString();
		Name = strInput.nextLine();
		System.out.println("\n\t Enter Age:");
		String s = strInput.nextLine();
		Age = Integer.parseInt(s);
		
		System.out.println("\n\t Enter Sex:");
		Gender = strInput.nextLine();
		
		System.out.println("\n\t Enter Education:");
		Speciality = strInput.nextLine();
		
		System.out.println("\n\t Enter Availability:");
		Availability = Integer.parseInt(strInput.nextLine());
		
		System.out.println("\n\t Enter MobileNo:");
		MobileNo = strInput.nextLine();
		
		System.out.println("\n\t Enter Salary:");
		Salary = Double.parseDouble(strInput.nextLine());
	}
	
	public void AddDoctorRecordToDatabase()
	{
		FileWriter f;
		try {
			f = new FileWriter (doctorFileName,true);
			BufferedWriter bw = new BufferedWriter(f);
			bw.write(uniqueID + "," + Name +","+ Speciality + "," +Age + "," + Gender + ","
					+Education + "," +Availability + "," +MobileNo + "," +Salary + "," + uniqueID);
			bw.flush();
			bw.newLine();
			bw.close();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void viewDoctorRecord() {
		//read all records from the file and
		//display them
		FileReader fr;
		try {
			fr = new FileReader(doctorFileName);
			BufferedReader br = new BufferedReader(fr);
			System.out.println("-----------------------------------------------------------------------------------------------------\n");
			System.out.println("ID\t Name\t   Speciality\t  Age\t  Gender\t Education\t Availability\t  MobileNo\t  Salary\t");
			System.out.println("-------------------------------------------------------------------------------------------------------");
			String curRecord;
		
			String record = br.readLine();
			while (record != null) {
				StringTokenizer tokens = new StringTokenizer(record,",");
				uniqueID 	 		= 	tokens.nextToken();
				Name 		= 	tokens.nextToken();
				Age 		= 	Integer.parseInt(tokens.nextToken());
				Speciality	=	tokens.nextToken();
				Gender 		= 	tokens.nextToken();
				Education 	=	tokens.nextToken();
				Availability= 	Integer.parseInt(tokens.nextToken());
				MobileNo 	= 	tokens.nextToken();
				Salary 		= 	Double.parseDouble(tokens.nextToken());
				System.out.println(uniqueID + "\t" + Name +"\t" + Speciality + "\t" +Age + "\t" + Gender + "\t"
						+Education + "\t" +Availability + "\t" +MobileNo + "\t" +Salary);
				record = br.readLine();
			}
			System.out.println("|	                                            	          |");
	    	System.out.println(" ------------------------------------------------------------- ");
	    	br.close();  
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void searchDoctorRecord()  {
		// TODO Auto-generated method stub
		String record,doctorName;
		boolean present = false;
		FileReader fr;
		try {
			fr = new FileReader(doctorFileName);
			BufferedReader br = new BufferedReader(fr);
			System.out.println("Search Doctor Record\n");
			System.out.println("Enter the Doctor Name:");
			doctorName = strInput.nextLine();
			System.out.println("-------------------------------------------------------------------------------------------------------");
			System.out.println("ID\t Name\t   Speciality\t  Age\t  Gender\t Education\t Availability\t  MobileNo\t  Salary\t");
			System.out.println("-------------------------------------------------------------------------------------------------------");
			record = br.readLine();
			while(record !=null)
			{
				StringTokenizer st = new StringTokenizer(record,",");
				if(record.contains(doctorName))
				{
					present = true;
					uniqueID 	 		= 	st.nextToken();
					Name 		= 	st.nextToken();
					Age 		= 	Integer.parseInt(st.nextToken());
					Speciality	=	st.nextToken();
					Gender 		= 	st.nextToken();
					Education 	=	st.nextToken();
					Availability= 	Integer.parseInt(st.nextToken());
					MobileNo 	= 	st.nextToken();
					Salary 		= 	Double.parseDouble(st.nextToken());
					System.out.println(uniqueID + "\t" + Name +"\t" + Speciality + "\t" +Age + "\t" + Gender + "\t"
							+Education + "\t" +Availability + "\t" +MobileNo + "\t" +Salary);
					
				}
				record = br.readLine();
			}
			if(!present){
				System.out.println("Sorry.. there is no record found..");
			}
			System.out.println("|	                                            	          |");
		    System.out.println(" ------------------------------------------------------------- ");
			br.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	void updateDoctorRecord() {
			
		
	}
		
		
	private  void GetDoctorRecordByName(String name) {
			
		
	}
		
	private void GetDoctorRecordByID(String id) {
			
		
	}
	
		
}
