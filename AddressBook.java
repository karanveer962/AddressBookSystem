import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {

    public static List<Person> searchPersonsInCityAndState(String city, String state, AddressBookRecords system) {
        return system.getAddressBooks().values().stream()
                .flatMap(contactBook -> contactBook.searchPersonsInCityAndState(city, state).stream())
                .collect(Collectors.toList());
    }

    public static List<Person> viewPersonsByCity(String city, AddressBookRecords system) {
        return system.viewPersonsByCity(city);
    }

    public static List<Person> viewPersonsByState(String state, AddressBookRecords system) {
        return system.viewPersonsByState(state);
    }

    public static List<Person> sortPersonsByName(AddressBookRecords system) {
        return system.getAddressBooks().values().stream()
                .flatMap(ContactBook::getContactsStream)
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());
    }

    public static void sortAddressBookByCity(AddressBookRecords system, String addressBookName) {
        system.getAddressBook(addressBookName).sortContactsByCity();
    }

    public static void sortAddressBookByState(AddressBookRecords system, String addressBookName) {
        system.getAddressBook(addressBookName).sortContactsByState();
    }

    public static void sortAddressBookByZip(AddressBookRecords system, String addressBookName) {
        system.getAddressBook(addressBookName).sortContactsByZip();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Address Book program  in AddressBookMain class on Master Branch");
        Person person1 = new Person("Karanveer", "Singh", "address", "kanpur", "up", "208006", "874865845", "email");
        Person person2 = new Person("Rajat", "Branwal", "address", "lucknow", "mp", "208001", "3435974584", "email");
        Person person3 = new Person("Priyanshu", "Yadav", "address", "agra", "ap", "208003", "8897453743", "email");
        AddressBookRecords system = new AddressBookRecords();
        system.addAddressBook("Friends");
        ContactBook cb = system.getAddressBook("Friends");
        cb.addContact(person1);
        cb.addContact(person2);
        cb.addContact(person3);

    
        System.out.println("\nSorted by City:"); //sorted by city
        sortAddressBookByCity(system, "Friends");
        system.getAddressBook("Friends").getAllContacts();
    
        System.out.println("\nSorted by State:"); //sorted by state
        sortAddressBookByState(system, "Friends");
        system.getAddressBook("Friends").getAllContacts();
    
        System.out.println("\nSorted by Zip:"); //sorted by zip
        sortAddressBookByZip(system, "Friends");
        system.getAddressBook("Friends").getAllContacts();
    }
}
