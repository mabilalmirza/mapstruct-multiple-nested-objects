package demo.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import demo.first.source.Employee;
import demo.first.source.GeneralAddress;
import demo.first.source.SpecialAddress;
import demo.first.target.CompleteAddress;
import demo.first.target.Person;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class FirstMapperTest {

    private FirstMapper mapper = Mappers.getMapper(FirstMapper.class);

    @Test
    void testMapAddress_generalAddress() {

        Employee employee = createEmployee("Mad King");
        employee.setSpecialAddress(createSpecialAddress("Building One", "Street Two"));
        employee.setGeneralAddress(createGeneralAddress("King's Landing", "Seven Kingdom"));

        Person person = createPerson("Mad King");
        person.setCompleteAddress(createCompleteAddress(
                "Building One",
                "Street Two",
                "King's Landing",
                "Seven Kingdom"));

        assertEquals(person, mapper.mapPerson(employee));

    }

    @Test
    void testMapAddressNull() {
        assertNull(mapper.mapPerson(null));
    }

    @Test
    void testMapAddress_generalAddressIsNull() {

        Employee employee = createEmployee("Mad King");
        employee.setSpecialAddress(createSpecialAddress("Building One", "Street Two"));

        Person person = createPerson("Mad King");
        person.setCompleteAddress(createCompleteAddress(
                "Building One",
                "Street Two",
                null,
                null));

        assertEquals(person, mapper.mapPerson(employee));
    }

    @Test
    void testMapAddress_specialAddressIsNull() {


        Employee employee = createEmployee("Mad King");
        employee.setGeneralAddress(createGeneralAddress("King's Landing", "Seven Kingdom"));

        Person person = createPerson("Mad King");
        person.setCompleteAddress(createCompleteAddress(
                null,
                null,
                "King's Landing",
                "Seven Kingdom"));

        assertEquals(person, mapper.mapPerson(employee));

    }

    private Employee createEmployee(String name) {
        Employee employee = new Employee();
        employee.setName(name);

        return employee;
    }

    private SpecialAddress createSpecialAddress(String line1, String line2) {

        SpecialAddress specialAddress = new SpecialAddress();
        specialAddress.setLine1(line1);
        specialAddress.setLine2(line2);

        return specialAddress;
    }

    private GeneralAddress createGeneralAddress(String city, String country) {

        GeneralAddress generalAddress = new GeneralAddress();
        generalAddress.setCity(city);
        generalAddress.setCountry(country);

        return generalAddress;
    }

    private Person createPerson(String name) {
        Person person = new Person();
        person.setName(name);

        return person;
    }

    private CompleteAddress createCompleteAddress(String line1, String line2, String city, String country) {
        CompleteAddress completeAddress = new CompleteAddress();
        completeAddress.setLineOne(line1);
        completeAddress.setLineTwo(line2);
        completeAddress.setCity(city);
        completeAddress.setCountry(country);

        return completeAddress;
    }

}
