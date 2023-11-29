package org.example.helpercode;

import java.util.Objects;

public class Customer {
    private String name;
    private int ageInYears;

    public void setAgeInYears(int age) {
        this.ageInYears = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAgeInYears() {
        return ageInYears;
    }

    public Customer(String name, int ageInYears) {
        this.name = name;
        this.ageInYears = ageInYears;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", ageInYears=" + ageInYears +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;
        return ageInYears == customer.ageInYears &&
                Objects.equals(getName(), customer.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAgeInYears());
    }
}
