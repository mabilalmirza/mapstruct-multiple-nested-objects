package demo.first;

import demo.first.source.Employee;
import demo.first.target.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface FirstMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "completeAddress.lineOne", source = "specialAddress.line1")
    @Mapping(target = "completeAddress.lineTwo", source = "specialAddress.line2")
    @Mapping(target = "completeAddress.city", source = "generalAddress.city")
    @Mapping(target = "completeAddress.country", source = "generalAddress.country")
    public Person mapPerson(Employee employee);

}
