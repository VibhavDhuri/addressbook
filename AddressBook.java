package addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	static ArrayList<Contacts> contactList = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	static void addContact() {
		System.out.println(" Enter your first name : ");
		String firstName = sc.nextLine();
		System.out.println(" Enter your last name : ");
		String lastName = sc.nextLine();
		System.out.println(" Enter your city name : ");
		String city = sc.nextLine();
		System.out.println("Enter your state  : ");
		String state = sc.nextLine();
		System.out.println(" Enter your zip code : ");
		long zip = sc.nextLong();
		System.out.println(" Enter your phone number : ");
		long phoneNumber = sc.nextLong();
		System.out.println(" Enter your email : ");
		String email = sc.next();

		Contacts addressBook = new Contacts(firstName, lastName, email, city, state, phoneNumber, zip);
		contactList.add(addressBook);
		System.out.println(addressBook);

	}

	static void editContact() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter the first name ");
		String fName = sc.nextLine();

		for (int index = 0; index < contactList.size(); index++) {

			if (contactList.get(index).getFirstName().equals(fName)) {
				contactList.remove(index);
				System.out.println("Contact Removed.");
				AddressBook addressBook = new AddressBook();
				addressBook.addContact();
				System.out.println("New contact created.");
			} else {
				System.out.println(" There is no contact ");
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program!");
		Scanner scanner = new Scanner(System.in);
		int exit = 1;
		while (exit == 1) {
			System.out.println("Choose your choice: 1.Add\n 2.Edit Contact \n 3. Exit");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addContact();
				break;
			case 2:
				editContact();
				break;
			case 3:
				exit = 0;
				break;
			default:
				System.out.println("Enter a valid choice");
				break;

			}

		}
		if (contactList.isEmpty() == true)
			System.out.println("The contact list is empty.");
		else
			System.out.println(contactList);
	}
}
