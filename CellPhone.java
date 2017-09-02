package ArrayList;

import java.util.ArrayList;

public class CellPhone {
	private String myNumber;
	private ArrayList<Contact> myContacts;
    //Created an array list to store the user input.
	public CellPhone(String myNumber) {
		this.myNumber = myNumber;
		this.myContacts = new ArrayList<Contact>();
	}	
	//when adding/updating, check to see if contact already exists:
	public boolean addNewContact(Contact contact) {
	//contact object
		if(findContact(contact.getName())>=0) {
			System.out.println("Contact is already on file");
			return false;
		}
		//add to list of records
		myContacts.add(contact);
		return true;
		
	}
	public boolean updateContact(Contact oldContact, Contact newContact) {
		int foundPosition = findContact(oldContact);
		if(foundPosition <0) {
			System.out.println(oldContact.getName() + ", cannot be found");
			return false;
		}
		this.myContacts.set(foundPosition, newContact);
		System.out.println(oldContact.getName() + " changed to " + newContact.getName());
		return true;
	}
	
	public boolean removeContact(Contact contact) {
		int foundPosition = findContact(contact);
		if(foundPosition <0) {
			System.out.println(contact.getName()+" wasn't found");
			return false;
		}
		this.myContacts.remove(foundPosition);
		System.out.println(contact.getName()+ " was deleted");
		return true;
	}
	//First, we find contact object and returns its 
	//index in the list parameters is contact....
	private int findContact(Contact contact) {
		return this.myContacts.indexOf(contact);
		//return an integer what the element is in the array
		//indexOf returns index of contact in the list
	}
	//overloading
	//checking the name to see whether its equal to the name
	private int findContact(String contactName) {
		for(int i=0; i <this.myContacts.size(); i++) {
			Contact contact = this.myContacts.get(i);
			if(contact.getName().equals(contactName)) {
				return i;
			}
		}
		return -1;
		//contact wasn't found
	}
	public String queryContact(Contact contact) {
		if(findContact(contact) >= 0) {
			return contact.getName();
		}
		return null;
	}
	
	public Contact queryContact(String name) {
		int position = findContact(name);
		if(position >= 0) {
			return this.myContacts.get(position);
		}
		return null;
	}
	
	public void printContacts() {
		System.out.println("Contact List");
		for(int i=0; i<this.myContacts.size(); i++) {
			System.out.println((i+1) + "." +
					this.myContacts.get(i).getName() + "->" +
					this.myContacts.get(i).getCellNumber());
		}
	}
}
