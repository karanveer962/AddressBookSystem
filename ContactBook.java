import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ContactBook {
    private List<Person> contacts;
    private Map<String, Person> contactsByName;
    private AddressBookRecords addressBookRecords;

    public ContactBook(AddressBookRecords addressBookRecords) {
        this.contacts = new ArrayList<>();
        this.contactsByName = new HashMap<>();
        this.addressBookRecords = addressBookRecords;
    }
    
    public Stream<Person> getContactsStream() {
        return contacts.stream();
    }

    public void sortContactsByCity() {
        contacts.sort(Comparator.comparing(Person::getCity));
    }

    public void sortContactsByState() {
        contacts.sort(Comparator.comparing(Person::getState));
    }

    public void sortContactsByZip() {
        contacts.sort(Comparator.comparing(Person::getZip));
    }
    
    public void addContact(Person person) {
        if (contacts.stream().anyMatch(p -> p.equals(person))) {
            System.out.println("Duplicate entry! Person with the same name already exists.");
        } else {
        contacts.add(person);
        contactsByName.put(person.getFirstName(), person);
        addressBookRecords.addPersonToDictionaries(person);
        System.out.println("Contact added successfully.");
        }
    }

    public void editContact(String firstName) {
        if (!contactsByName.containsKey(firstName)) {
            System.out.println("Contact with the given first name not found.");
            return;
        }

        Person person = contactsByName.get(firstName);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter which field to update for contact "+firstName+": ");
        String fieldToUpdate=sc.nextLine();
        System.out.println("Enter new value for " + fieldToUpdate + ":");
        String newValue = sc.nextLine();

        switch (fieldToUpdate.toLowerCase()) {
            case "lastname":
                person.setLastName(newValue);
                break;
            case "address":
                person.setAddress(newValue);
                break;
            case "email":
                person.setEmail(newValue);
                break;
            case "phonenumber":
                person.setPhnum(newValue);
                break;
            case "city":
                person.setCity(newValue);
                break;
            case "state":
                person.setState(newValue);
                break;
            case "zip":
                person.setZip(newValue);
                break;
            default:
                System.out.println("Invalid field name. No changes made.");
                return;
        }

        System.out.println("Contact edited successfully.");
    }
    public void deleteContact(String firstName){
        if(!contactsByName.containsKey(firstName)){
            System.out.println("Contact with the given first name not found.");
            return;
        }
        contacts.remove(contactsByName.get(firstName));
        contactsByName.remove(firstName);
        System.out.println("Contact deleted Successfully");
    }
    public void getAllContacts(){
        System.out.println("All Contacts: ");
        for(Person it:contacts){
            System.out.println(it.getFirstName()+" "+it.getLastName()+" "+it.getPhoneNumber());
        }
    }

    public List<Person> searchPersonsInCityAndState(String city, String state) {
        return contacts.stream()
                .filter(person -> ( person.getCity().equalsIgnoreCase(city))
                        || ( person.getState().equalsIgnoreCase(state)))
                .collect(Collectors.toList());
    }
}