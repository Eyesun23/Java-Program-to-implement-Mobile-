package ArrayList;

//Program that implements a simple cellphone with following capabilities:
//Store, modify, remove and query contacts.

public class Contact {
	private String name;
	private String cellNumber;
	public Contact(String name, String cellNumber) {
		this.name = name;
		this.cellNumber = cellNumber;
	}
	
	//print out information
	public String getName() {
		return name;
	}
	public String getCellNumber() {
		return cellNumber;
	}
	
	public static Contact createContact(String name, String cellNumber) {
		return new Contact(name, cellNumber);
		//returns a new object from the Contact class.
	}	
}
