package function;


import java.util.ArrayList;
import java.util.List;

import business.Contact;

public class ContactLambdaApp {


	public static void main(String[] args) {
			System.out.println("Welcome to the ContactApp (No Lambda version)!\n");
			
			// Create a list of contacts
			List<Contact> contacts = new ArrayList<>();
			contacts.add(new Contact("John Doe", "john.doe@foo.com", "513-222-3333"));
			contacts.add(new Contact("Bill Smith", "bill.smith@foo.com", null));
			contacts.add(new Contact("Harvey Boogenheimer", "harvey.boogenheimer@foo.com", "513-555-6666"));
			contacts.add(new Contact("Bob Marley", null, null));
			contacts.add(new Contact("Wonder Woman", "ggadot@ww.com", null));
			
			System.out.println("Contacts without email address:");
			List<Contact> noEmailContacts = filterContacts(contacts, c -> c.getEmail()==null);
			for (Contact c: noEmailContacts) {
				System.out.println(c);
			}
			System.out.println();
			
			System.out.println("Contacts without phoneNumbers:");
			List<Contact> noPhoneContacts = filterContacts(contacts, c -> c.getPhone()==null);
			for (Contact c: noPhoneContacts) {
				System.out.println(c);
			}
			System.out.println();
			System.out.println("bye!");

	}

	public static List<Contact> filterContacts(List<Contact> contacts,
			TestContact condition) {
		List<Contact> filteredContacts = new ArrayList<>();
		for (Contact c : contacts) {
			if (condition.testContact(c)) {
				filteredContacts.add(c);
			}
		}
		return filteredContacts;
}
}