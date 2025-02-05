package org.example.javaconcepts.immutableex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Employee {
    private final String empName;
    private final int age;
    private final Address address; //See how you may want to implement clone for custom objects
    private final List<String> phoneNumbers;
    private final Map<String, String> metadata;

    public Employee(String name, int age, Address address, List<String> phoneNumbers, Map<String, String> metadata) {
        super();
        this.empName = name;
        this.age = age;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
        this.metadata = metadata;
    }

    public String getEmpName() {
        return empName;
    }

    public int getAge() {
        return age;
    }

    // clone the address object
    public Address getAddress() throws CloneNotSupportedException {
        return (Address) address.clone();
    }

    // copy the list of phone numbers
    public List<String> getPhoneNumbers() {
        return new ArrayList<>(phoneNumbers);
    }

    // copy the map of metadata
    public Map<String, String> getMetadata() {
        return new HashMap<>(metadata);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("street 1", "city X");
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("123456");
        phoneNumbers.add("456789");
        Map<String, String> metadata = new HashMap<>();
        metadata.put("hobby", "Watching Movies");

// Declare the employee
        Employee e = new Employee("John", 23, address, phoneNumbers, metadata);

// Update details
        List<String> ph = e.getPhoneNumbers();    ph.add("345123");
        e.getMetadata().put("skill", "Java");
        e.getMetadata().put("designation", "HR");

// change address details
        e.getAddress().setCity("c3");
        e.getAddress().setStreet("s3");

        System.out.println(e.getPhoneNumbers());
        System.out.println(e.getMetadata());
        System.out.println(e.getAddress());
    }
}
