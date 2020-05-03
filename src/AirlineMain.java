import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Arrays;

public class AirlineMain {
	
	public static void displayArrayList( ArrayList<flightDetails> flightAL) {
		
		for ( int i = 0;i < flightAL.size(); i++) {
			System.out.println("\n" + flightAL.get(i));
		}
	}
	
	
	public static boolean compare(flightDetails fd, internationalFlightSelection ifs) {
		if (fd.local.equals(ifs.local) && fd.destination.equals(ifs.destination) && fd.time.equals(ifs.time) && fd.date.equals(ifs.date)) {
			return true;
		}
		return false;
	}
	
	public static boolean regexChecker( String theRegex, String data) {
		
		boolean flag =  Pattern.matches(theRegex, data);
		if ( flag ) {
			return flag;
		}
		
		else {
			return false;
		}
		
	}
	
	public static boolean valPhone ( String phone ) {
		return !(phone.charAt(0) == '0') && phone.length() == 11 && phone.matches("[0-9]+");
	}
	
	public static String reformatPhone(String phone) {
		
		String hypen ="-";
		String newPhone = phone.substring(0,3) + hypen + phone.substring(3, 7) + hypen + phone.substring(7, 11);
		return newPhone;
		
	}
	public static void main(String []args) throws IOException {
	    
		System.out.println("Welcome to TravelFirst Airline Booking System");
	    System.out.println("List of Flights");
	    FileReader fr = new FileReader("InternationalFlightDetails.txt");
	    BufferedReader br = new BufferedReader(fr); 
	    ArrayList<flightDetails> flightAL = new ArrayList<>();
        // display list of flights and store it to arraylist
        try {
        	br.readLine();
        	String line = "";
    		while ((line = br.readLine()) != null) {
    			// split line by space
                String[] lineArray = new String[4];
               lineArray = line.split("\\s+");
                String local = lineArray[0];
                String destination = lineArray[1];
                String time = lineArray[2];
                String date = lineArray[3];
                 // create a new customer details object
                flightDetails fd = new flightDetails(local, destination, time, date);
                // add it to arraylist
                flightAL.add(fd); 
              
    		}
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
        
        displayArrayList(flightAL);
        
    	
        
        
        String iDestination = null ,iLocal = null,iTime = null ,iDate = null;
        internationalFlightSelection ifs = new internationalFlightSelection(iDestination,iLocal,iTime,iDate);
        Scanner input = new Scanner(System.in);
        br.close();
		boolean flag = false;
		 while(flag == false) {
				System.out.print("\nSelect local country: ");
			    iLocal = input.next();
			    System.out.print("Select destination country: ");
			    iDestination = input.next();
			    System.out.print("Select a flight time: ");
			    iTime = input.next();
			    System.out.print("Select a flight date: ");
			    iDate = input.next();
        // user selects a flight
    
	   
	  ifs.setDate(iDate);
	  ifs.setDestination(iDestination);
	  ifs.setLocal(iLocal);
	  ifs.setTime(iTime);
	    for (flightDetails fd : flightAL) {
			if (compare(fd, ifs) == true) {
				flag = true;
				System.out.print("Match found!");
				break; // break if match is found
			}
		}
		if (flag == false) {
			System.out.println("Flight information invalid. Try Again!!");
		}
		 }
	System.out.println();
	 // user enters his/her detail
		String firstName = null , lastName = null , middleName = null , address = null , salutation = null, flightType = null , flightClass = null , phoneNumber = null;
		boolean validation = false;
		boolean overallCheck = false;
		
		while (!overallCheck) {
		while (!validation) {
			System.out.print("\nSalutation: ");
			salutation = input.next();
			validation = regexChecker("[dD](r)|[Mm](r|R|s|iss)",salutation);
			if ( !validation ) {
				System.out.println("Invalid input! Enter Dr/Mr/Miss/Ms/Mdm only!");
			}
			else {
				break;
			}
		}
		
		validation = false;
		
		while (!validation) {
			System.out.print("First Name: ");
			firstName= input.next();
			validation = regexChecker("[a-zA-Z]+",firstName);
			if (! validation ) {
				System.out.println("Invalid input! Enter letters only!");
			}
			else {
				break;
			}
		}
		
		validation = false;
		
		while (!validation) {
			System.out.print("Middle Name: ");
			middleName = input.next();
			validation = regexChecker("[a-zA-Z]+",middleName);
			if (! validation ) {
				System.out.println("Invalid input! Enter letters only!");
			}
			else {
				break;
			}
		}
		
validation = false;
		
		while (!validation) {
			System.out.print("Last Name: ");
			lastName = input.next();
			validation = regexChecker("[a-zA-Z]+",lastName);
			if (! validation ) {
				System.out.println("Invalid input! Enter letters only!");
			}
			else {
				break;
			}
		}

			validation = false;
			
			while (!validation) {
				System.out.print("Phone number: ");
				phoneNumber = input.next();
				validation = valPhone(phoneNumber);
				if (! validation ) {
					System.out.println("Invalid input! Enter letters only!");
				}
				else {
					String temp = reformatPhone(phoneNumber);
					phoneNumber = temp;
					break;
				}}
		
		System.out.print("Address: ");
		address = input.next();
		
		validation = false;
		
		
		while (!validation) {
			System.out.print("Flight Class: ");
			flightClass = input.next();
			validation = flightClass.equalsIgnoreCase("business") || flightClass.equalsIgnoreCase("economy") || flightClass.equalsIgnoreCase("first class");
			if (! validation ) {
				System.out.println("Invalid input! Enter business or economy or first classs only!");
			}
			else {
				break;
			}
		}
		
		validation = false;

		while (!validation) {
			System.out.print("Flight Type: ");
			flightType= input.next();
			validation = flightType.equalsIgnoreCase("international") || flightType.equalsIgnoreCase("Domestic");
			if (! validation ) {
				System.out.println("Invalid input! Enter international or only!");
			}
			else {
				break;
			}
		}
		
	
	
		
		customerDetails cd = new customerDetails( salutation, firstName,  middleName,  lastName, phoneNumber,  address
				, flightType, flightClass);
		
	
		
		String confirmation = null;
		
		
		String paymentMethod = null;
		String creditCardNumber = null, cvv = null, expiryDate = null;
		boolean match = false;
		flag = false;
		String paymentMethodSave = null;
		while (!flag ) {
		input.nextLine();
		System.out.print("Please select payment method: ");
		paymentMethod = input.nextLine();
		if ( paymentMethod.equalsIgnoreCase("Paypal")) {
			System.out.print("Enter email: ");
			String email = input.next();
			match = Pattern.matches("^[\\\\\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\\\\\.[\\\\\\\\w!#$%&’*+/=\"\r\n" + 
					"				+ \"?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\\\\\.)+[a-zA-Z]{2,6}$", email);
			flag = true;
			paymentMethodSave = "\nPayment method: Paypal" + 
								"\nEmail: " + email;
			break;
	}
		
		if ( paymentMethod.equalsIgnoreCase("Credit Card")) {
			
			
			validation = false; 
			
			while (!validation) {
				System.out.print("Enter credit card number: ");
				creditCardNumber = input.next();
				validation = regexChecker("^[0-9]{16}+$", creditCardNumber);
				if (! validation ) {
					System.out.println("Invalid input! Enter 16 digits!");
				}
				else {
					break;
				}
			}
			
			
			validation = false;
			
			while (!validation) {
				System.out.println("CVV: ");
				cvv = input.next();
				validation = regexChecker("^[0-9]{3}+$", cvv);
				if (! validation ) {
					System.out.println("Invalid input! Enter 3 digits!");
				}
				else {
					break;
				}
			}
		
			validation = false;
			
			while (!validation) {
				input.nextLine();
				System.out.println("Expiry date: ");
				expiryDate = input.nextLine();
				validation = regexChecker("^(1[0-2]|0[1-9])/2[0-9]$", expiryDate);
				if (! validation ) {
					System.out.println("Invalid input! Enter 3 digits!");
				}
				else {
					validation = true;
					break;
				}
			}

			
			
			flag = true;
			paymentMethodSave = "Payment method: Credit card" +
								"\nCredit card number: " + creditCardNumber + 
								"\nCvv: " + cvv +
								"\nExpiry Date: " + expiryDate;
			break;
		}
		
		else {
			System.out.println("Invalid payment method! Only enter Paypal or credit card!");
			flag = false;
		}
		
		}
		
		System.out.println("\nConfirm flight details and personal information\n" + cd + "\n" + ifs + paymentMethodSave );
		

		while ( flag ) {
			System.out.print("\nConfirm details Y/N: ");
			confirmation = input.next();
			if (confirmation.equalsIgnoreCase("y")) {
				System.out.println("Thank you for your business!");
				
				File file = new File("CustomerConfirmationDetails.txt");
				PrintWriter pw = new PrintWriter(file);
				pw.println(cd);
				pw.println(ifs);
				pw.println(paymentMethodSave);
				pw.close();
				flag = false;
				overallCheck = true;
				break;
			}
			
			if ( confirmation.equalsIgnoreCase("n")) {
			overallCheck = false;
				flag = false;
				}
			
			else {
				System.out.println("Enter Y or N only!");
				flag = true;
			}
			}
		
		
		
		
		
		
		
		
		
		
		
		}
		
		
		
		
		input.close();
	}
}
