
public class customerDetails {

	String firstName, lastName, middleName, address, salutation, flightType, flightClass, phoneNumber;
	
	// counstructor
	public customerDetails( String salutation, String firstName, String middleName, String lastName,String phoneNumber, String address
			,String flightType, String flightClass) {
		
		this.firstName=firstName;
		this.lastName= lastName;
		this.middleName= middleName;
		this.address= address;
		this.salutation= salutation;
		this.flightType= flightType;
		this.flightClass= flightClass;
		this.phoneNumber= phoneNumber;

	}
	
	public String getSalutation() {
		return salutation;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getFlightType() {
		return flightType;
	}
	
	public String getFlightClass() {
		return flightClass;
	}
	
	@Override
	public String toString() {
		return "First Name: " + this.firstName + 
				"\nMiddle Name: " + this.middleName +
				"\nLast Name: " + this.lastName +
				"\nAddress: " + this.address +
				"\nPhone Number: " + this.phoneNumber +
				"\nFlight Type: " + this.flightType +
				"\nFlight Class: " + this.flightClass;
		
	}
	
	
}
