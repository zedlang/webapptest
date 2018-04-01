package com.proquest.interview.phonebook;

import java.util.List;

import com.proquest.interview.util.DatabaseUtil;

public class PhoneBookImpl implements PhoneBook {
	public List people;
	
	@Override
	public void addPerson(Person newPerson) {
		this.people.add(newPerson);
	}
	
	@Override
	public Person findPerson(String firstName, String lastName) {
		for (Person aPerson : this.people ) {
			if (aPerson.name.equals(firstName + " " + lastName)) {
			System.out.print(aPerson.name + " " + aPerson.phoneNumber + " " + aPerson.address);
			System.out.println();
			}
		}
	}

	private void printPhonebook() {
		for (Person aPerson : this.people ) {
			System.out.print(aPerson.name + " " + aPerson.phoneNumber + " " + aPerson.address);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		DatabaseUtil.initDB();  //You should not remove this line, it creates the in-memory database

		/* TODO: create person objects and put them in the PhoneBook and database
		 * John Smith, (248) 123-4567, 1234 Sand Hill Dr, Royal Oak, MI
		 * Cynthia Smith, (824) 128-8758, 875 Main St, Ann Arbor, MI
		*/ 
		// TODO: print the phone book out to System.out
		// TODO: find Cynthia Smith and print out just her entry
		// TODO: insert the new person objects into the database

		Person firstPerson = new Person("John Smith", "(248) 123-4567", "1234 Sand Hill Dr, Royal Oak, MI");
		Person secondPerson = new Person("Cynthia Smith", "(824) 128-8758", "875 Main St, Ann Arbor, MI");

		PhoneBookImpl myPhoneBook = new PhoneBookImpl();
		myPhoneBook.addPerson(firstPerson);
		myPhoneBook.addPerson(secondPerson);

		//Print Phonebook contents
		myPhoneBook.printPhonebook();

		//Find Cynthis Smith
		myPhoneBook.findPerson("Cynthia", "Smith");

		//Insert new person objects into database
		DatabaseUtil.addPersonToDB(firstPerson.name, firstPerson.phoneNumber, firstPerson.address);
		DatabaseUtil.addPersonToDB(secondPerson.name, secondPerson.phoneNumber, secondPerson.address);

	}
}
