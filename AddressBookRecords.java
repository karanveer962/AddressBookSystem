import java.util.*;

class AddressBookRecords {
    private Map<String, ContactBook> addressBooks;
    private Map<String, List<Person>> cityDictionary;
    private Map<String, List<Person>> stateDictionary;


    public AddressBookRecords() {
        this.addressBooks = new HashMap<>();
        this.cityDictionary = new HashMap<>();
        this.stateDictionary = new HashMap<>();
    }

    public void addAddressBook(String addressBookName) {
        ContactBook newAddressBook = new ContactBook(this);
        addressBooks.put(addressBookName, newAddressBook);
    }

    public ContactBook getAddressBook(String addressBookName) {
        return addressBooks.get(addressBookName);
    }
    public Map<String, ContactBook> getAddressBooks() {
        return addressBooks;
    }

    public void addPersonToDictionaries(Person person) {
        cityDictionary.computeIfAbsent(person.getCity(), key -> new ArrayList<>()).add(person);
        stateDictionary.computeIfAbsent(person.getState(), key -> new ArrayList<>()).add(person);
    }

    public List<Person> viewPersonsByCity(String city) {
        if(cityDictionary.containsKey(city))
        return cityDictionary.get(city);
        else
        return new ArrayList<Person>();
    }

    public List<Person> viewPersonsByState(String state) {
        if(stateDictionary.containsKey(state))
        return stateDictionary.get(state);
        else
        return new ArrayList<Person>();
    }
}
