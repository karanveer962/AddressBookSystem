import java.util.*;
import java.util.stream.Collectors;
import java.io.*;


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
    
      //writing to a file
    public static void writeAddressBookToFile(AddressBookRecords system, String addressBookName, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            ContactBook contactBook = system.getAddressBook(addressBookName);
            List<Person> contacts = contactBook.getContacts();
            for (Person person : contacts) {
                writer.write(person.toString());
                writer.newLine();  
            }
            System.out.println("Address book written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    //reading from a file
    public static List<Person> readAddressBookFromFile(String fileName) {
        List<Person> persons = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Person person = stringToPerson(line);
                persons.add(person);
            }
            System.out.println("\nAddress book read from " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }
    private static Person stringToPerson(String line) {
       
        String[] keyValuePairs = line.split(", ");
        Map<String, String> attributes = new HashMap<>();
    
        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2) {
                attributes.put(keyValue[0], keyValue[1].replace("'", ""));
            }
        }
        return new Person(
                attributes.get("{f_name"),
                attributes.get("l_name"),
                attributes.get("address"),
                attributes.get("city"),
                attributes.get("state"),
                attributes.get("zip"),
                attributes.get("phnum"),
                attributes.get("email")
        );
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

    
        writeAddressBookToFile(system, "Friends", "output.txt");
         List<Person> persons=readAddressBookFromFile("output.txt");
         persons.forEach(System.out::println);
    }
}
