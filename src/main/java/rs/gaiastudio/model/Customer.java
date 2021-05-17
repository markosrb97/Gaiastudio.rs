package rs.gaiastudio.model;

public class Customer {
	
	private String firstName;
	private String lastName;
	private String telNumber;
	private String address;
	private String city;
	private String zipCode;
        private String note;
        
        public String getNote(){
            return note;
        }
        
        public void setNote(String note){
            this.note = note;
        }
	
	public Customer() {};
	
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String toString() {
		return firstName + " " + lastName + "\n" + telNumber + "\n" + address + "\n" + city + " " + zipCode;
	}
	
}
