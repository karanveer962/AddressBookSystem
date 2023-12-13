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

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Address Book program  in AddressBookMain class on Master Branch");
        Person person1 = new Person("Karanveer", "Singh", "address", "city", "state", "zip", "874865845", "email");
        Person person2 = new Person("Rajat", "Branwal", "address", "city", "state", "zip", "3435974584", "email");
        Person person3 = new Person("Priyanshu", "Yadav", "address", "city1", "state", "zip", "8897453743", "email");
        AddressBookRecords system = new AddressBookRecords();
        system.addAddressBook("Friends");
        ContactBook cb = system.getAddressBook("Friends");
        cb.addContact(person1);
        cb.addContact(person2);
        cb.addContact(person3);


          // Sorting entries by name
        System.out.println("\nSorted Entries by Name:");
        List<Person> sortedPersons = sortPersonsByName(system);
        sortedPersons.forEach(System.out::println);
    }
 }
