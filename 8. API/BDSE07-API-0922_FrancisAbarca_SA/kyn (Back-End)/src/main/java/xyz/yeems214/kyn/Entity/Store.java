package xyz.yeems214.kyn.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public Store() {
    }

    public Store(Long id, String name, String address, String city, String state, String zip, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
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

    public String getPhone() {
        return phone;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setPhone(String phone) {
    	this.phone = phone;
    }

    @Override
    public String toString() {
    	return "Store [name=" + name + ", address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip + ", phone=" + phone + "]";
    }

    @Override
    public boolean equals(Object obj) {
    	if (obj == this) {
    		return true;
    	}

    	if (!(obj instanceof Store)) {
    		return false;
    	}

    	Store store = (Store) obj;

    	return store.name.equals(this.name) && store.address.equals(this.address) && store.city.equals(this.city) && store.state.equals(this.state) && store.zip.equals(this.zip) && store.phone.equals(this.phone);
    }

    @Override
    public int hashCode() {
    	int result = 17;
    	result = 31 * result + name.hashCode();
    	result = 31 * result + address.hashCode();
    	result = 31 * result + city.hashCode();
    	result = 31 * result + state.hashCode();
    	result = 31 * result + zip.hashCode();
    	result = 31 * result + phone.hashCode();
    	return result;
    }
}