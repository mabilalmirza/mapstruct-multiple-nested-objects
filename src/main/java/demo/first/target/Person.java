package demo.first.target;

import java.util.Objects;

public class Person {

    String name;
    private CompleteAddress completeAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompleteAddress getCompleteAddress() {
        return completeAddress;
    }

    public void setCompleteAddress(CompleteAddress completeAddress) {
        this.completeAddress = completeAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(completeAddress, person.completeAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, completeAddress);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", completeAddress=" + completeAddress +
                '}';
    }
}
