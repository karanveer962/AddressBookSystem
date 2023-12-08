
import java.util.*;

class Person {
    private String f_name, l_name, address, city, state, zip, phnum, email;

    public Person(String f_name, String l_name, String address, String city, String state, String zip, String phnum,
            String email) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phnum = phnum;
        this.email = email;
    }

    public void setLastName(String l_name) {
        this.l_name = l_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhnum(String phnum) {
        this.phnum = phnum;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return f_name;
    }

    public String getLastName() {
        return l_name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhoneNumber() {
        return phnum;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(f_name, person.f_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(f_name);
    }
}
