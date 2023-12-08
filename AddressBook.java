import java.util.*;

public class AddressBook {
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
        cb.addContact(person1);
        // cb.editContact(person1.getFirstName());
        // cb.deleteContact(person2.getFirstName());
        cb.getAllContacts();

    }
}