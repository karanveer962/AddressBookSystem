import java.util.*;

class AddressBookRecords {
    private Map<String, ContactBook> addressBooks;

    public AddressBookRecords() {
        this.addressBooks = new HashMap<>();
    }

    public void addAddressBook(String addressBookName) {
        ContactBook newAddressBook = new ContactBook();
        addressBooks.put(addressBookName, newAddressBook);
    }

    public ContactBook getAddressBook(String addressBookName) {
        return addressBooks.get(addressBookName);
    }
}