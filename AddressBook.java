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

        // cb.editContact(person1.getFirstName());
        // cb.deleteContact(person2.getFirstName());
        // cb.getAllContacts();

         System.out.println("\nOn the basis of City:");
         List<Person> personsByCity = viewPersonsByCity("city", system);
         personsByCity.forEach(person -> System.out.println(person.getFirstName() + " " + person.getLastName()));

         System.out.println("\nOn the basis of State: ");
         List<Person> personsByState = viewPersonsByState("state", system);
         personsByState.forEach(person -> System.out.println(person.getFirstName() + " " + person.getLastName()));
    }
 }
