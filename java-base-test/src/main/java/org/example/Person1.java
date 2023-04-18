package org.example;

public class Person1 implements Cloneable {
    private String name;
    private Address address;

    public Person1(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public Person1 clone() throws CloneNotSupportedException {
        Person1 clone = (Person1) super.clone();

        return clone;
    }
}

class Address {
    private String city;

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

}

class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 深克隆
        Address address = new Address("Shanghai");
        Person1 person1 = new Person1("Tom", address);
        Person1 person2 = person1.clone();

        // person1和person2的Address对象不同
        System.out.println(person1.getAddress() == person2.getAddress()); // false
    }
}
