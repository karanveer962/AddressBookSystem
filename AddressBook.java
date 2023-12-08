import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {

    public static List<Person> searchPersonsInCityAndState(String city, String state, AddressBookRecords system) {
        return system.getAddressBooks().values().stream()
        .flatMap(contactBook -> contactBook.searchPersonsInCityAndState(city, state).stream())
        .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Address Book program  in AddressBookMain class on Master Branch");
        Person person1 = new Person("Karanveer", "Singh", "address", "city", "state", "zip", "874865845", "email");
        Person person2 = new Person("Rajat", "Branwal", "address", "city", "state", "zip", "3435974584", "email");
        Person person3 = new Person("Priyanshu", "Yadav", "address", "city", "state", "zip", "8897453743", "email");
        AddressBookRecords system = new AddressBookRecords();
        system.addAddressBook("Friends");
        ContactBook cb = system.getAddressBook("Friends");
        cb.addContact(person1);
        cb.addContact(person2);
        cb.addContact(person3);
        // cb.editContact(person1.getFirstName());
        // cb.deleteContact(person2.getFirstName());
        // cb.getAllContacts();



        List<Person> personsInCityAndState = searchPersonsInCityAndState("city", "state", system);
        System.out.println("Persons with given city and state are : ");
        personsInCityAndState.forEach(person -> System.out.println(person.getFirstName() + " " + person.getLastName()));
    }
    }
