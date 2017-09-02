package ArrayList;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static CellPhone cellPhone = new CellPhone("");
	public static void main(String[] args) {
	
	boolean quit= false;
	startPhone();
	printActions();
	while(!quit) {	
		System.out.println("\nEnter action: (6 to show available actions)");
		int action = scanner.nextInt();
		scanner.nextLine();
		
		switch (action) {
			case 0:
				System.out.println("\nShutting down ....");
				quit = true;
				break;
				
			case 1:
				cellPhone.printContacts();
				break;
			case 2:
				addNewContact();
				break;
			case 3:
				updateContact();
				break;
			case 4:
				removeContact();
				break;
			case 5:
				queryContact();
				break;
			case 6:
				printActions();
				break;
			}
		}
	}
	private static void addNewContact() {
		System.out.println("Enter new contact name: ");
		String name = scanner.nextLine();
		System.out.println("Enter phone number: ");
		String phone = scanner.nextLine();
		Contact newContact = Contact.createContact(name, phone);
		if (cellPhone.addNewContact(newContact)) {
			System.out.println("New contact added: " + name + " phone = " + phone);
		} else {
			System.out.println("Cannot add " + name + " already on file!");
		}
	}
	private static void updateContact() {
		System.out.println("Enter existing contact: ");
		String name = scanner.nextLine();
		Contact existingContactRecord = cellPhone.queryContact(name);
		if(existingContactRecord == null ) {
			System.out.println("No contact found");
			return;
		}
		System.out.print("Enter new contact: ");
		String newName = scanner.nextLine();
		System.out.print("Enter new contact cell number: ");
		String newNumber = scanner.nextLine();
		Contact newContact = Contact.createContact(newName, newNumber);
		if(cellPhone.updateContact(existingContactRecord, newContact)) {
			System.out.println("Record updated! ");	
		} else {
			System.out.println(" Error ");
		}
	}
	private static void removeContact() {
		System.out.println("Enter existing contact: ");
		String name = scanner.nextLine();
		Contact existingContactRecord = cellPhone.queryContact(name);
		if(existingContactRecord == null ) {
			System.out.println("No contact found");
			return;
		}
	
		if(cellPhone.removeContact(existingContactRecord)) {
			System.out.println("Deleted ");
		} else {
			System.out.println("Error Deleting ");
		}
	}
	private static void queryContact() {
		System.out.println("Enter existing contact: ");
		String name = scanner.nextLine();
		Contact existingContactRecord = cellPhone.queryContact(name);
		if (existingContactRecord == null ) {
			System.out.println("No contact found");
			return;
		}
		System.out.println("Name : " + existingContactRecord.getName() + "phone number is " + existingContactRecord.getCellNumber());
	}
	
	private static void startPhone() {
		System.out.println("starting phone...");
	}
	private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shutdown\n" +
                           "1  - to print contacts\n" +
                           "2  - to add a new contact\n" +
                           "3  - to update existing an existing contact\n" +
                           "4  - to remove an existing contact\n" +
                           "5  - query if an existing contact exists\n" +
                           "6  - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }
}
