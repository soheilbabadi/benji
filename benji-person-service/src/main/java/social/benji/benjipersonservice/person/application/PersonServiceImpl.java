package social.benji.benjipersonservice.person.application;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import social.benji.benjipersonservice.person.exceoption.PersonNotFoundException;
import social.benji.benjipersonservice.person.infra.PersonRepository;
import social.benji.benjipersonservice.person.model.Person;
import social.benji.benjipersonservice.person.model.dto.LocationSearchDto;
import social.benji.benjipersonservice.person.model.dto.PersonDto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public PersonDto getPerson(String id) {
        var person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person not found"));
        return PersonDto.builder()
                .id(person.getId())
                .username(person.getUsername())
                .email(person.getEmail())
                .phone(person.getPhone())
                .role(person.getRole().getName())
                .country(person.getCountry())
                .city(person.getCity())
                .latitude(person.getLatitude())
                .longitude(person.getLongitude())
                .build();
    }

    @Override
    public PersonDto getPersonPublic(String id) {
        var dto = getPerson(id);
        dto.setLatitude(0);
        dto.setLongitude(0);
        dto.setPhone("");
        dto.setEmail("");
        dto.setRole("");

        return dto;
    }

    @Override
    public PersonDto putPerson(PersonDto personDto) {
        var person = personRepository.findById(personDto.getId())
                .orElseThrow(() -> new PersonNotFoundException("Person not found"));
        BeanUtils.copyProperties(personDto, person);
        person.setId(UUID.randomUUID().toString());
        person.setLastLoginOn(LocalDateTime.now(ZoneId.of("UTC")));
        personRepository.save(person);
        BeanUtils.copyProperties(person, personDto);
        return personDto;

    }

    @Override
    public void deletePerson(String id) {

        personRepository.deleteById(id);

    }

    @Override
    public PersonDto getPersonByUsername(String username) {
        var person = personRepository.findByUsername(username)
                .orElseThrow(() -> new PersonNotFoundException("Person not found"));
        return getPersonPublic(person.getId());
    }

    @Override
    public PersonDto getPersonByEmail(String email) {
        var person = personRepository.findByEmail(email)
                .orElseThrow(() -> new PersonNotFoundException("Person not found"));
        return getPersonPublic(person.getId());
    }

    @Override
    public PersonDto getPersonByPhone(String phone) {
        var person = personRepository.findByPhone(phone)
                .orElseThrow(() -> new PersonNotFoundException("Person not found"));
        return getPersonPublic(person.getId());
    }

    @Override
    public List<PersonDto> getPersonByRole(String role) {
        var list = personRepository.findAllByRole(role);
        List<PersonDto> result = new ArrayList<>();
        for (Person person : list) {
            result.add(getPersonPublic(person.getId()));
        }

        return result;
    }

    @Override
    public List<PersonDto> getPersonByCity(LocationSearchDto dto) {
        var list = personRepository.findAllByCountryAndCity(dto.getCountry(),dto.getCity());
        List<PersonDto> result = new ArrayList<>();
        for (Person person : list) {
            result.add(getPersonPublic(person.getId()));
        }

        return result;
    }

    @Override
    public List<PersonDto> getPersonNearBy(LocationSearchDto dto) {
        return null;
    }
}
