package social.benji.benjipersonservice.person.application;


import social.benji.benjipersonservice.person.model.dto.LocationSearchDto;
import social.benji.benjipersonservice.person.model.dto.PersonDto;

import java.util.List;

public interface PersonService {
    
    PersonDto getPerson(String id)  ;
    PersonDto getPersonPublic(String id)  ;

    PersonDto putPerson(PersonDto personDto)  ;
    void deletePerson(String id)  ;
    PersonDto getPersonByUsername(String username)  ;
    PersonDto getPersonByEmail(String email)  ;
    PersonDto getPersonByPhone(String phone)  ;
    List<PersonDto> getPersonByRole(String role)  ;
    List<PersonDto> getPersonByCity(LocationSearchDto dto)  ;
    List<PersonDto> getPersonNearBy(LocationSearchDto dto)  ;
}
