package social.benji.benjipersonservice.person.presentation;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import social.benji.benjipersonservice.person.application.PersonService;
import social.benji.benjipersonservice.person.model.dto.LocationSearchDto;
import social.benji.benjipersonservice.person.model.dto.PersonDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private final PersonService personService;


    @GetMapping("/get-private/{id}")
    public ResponseEntity<PersonDto> getMyProfile(@PathVariable String id) {
        return new ResponseEntity<>(personService.getPerson(id), null, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> get(@PathVariable String id) {
        return new ResponseEntity<>(personService.getPersonPublic(id), null, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PersonDto> update(@RequestBody PersonDto dto) {
        return new ResponseEntity<>(personService.putPerson(dto), null, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find-by-username/{username}")
    public ResponseEntity<PersonDto> findByUsername(@PathVariable String username) {
        return new ResponseEntity<>(personService.getPersonByUsername(username), null, HttpStatus.OK);
    }

    @GetMapping("/find-by-email/{phone}")
    public ResponseEntity<PersonDto> findByEmail(@PathVariable String email) {
        return new ResponseEntity<>(personService.getPersonByEmail(email), null, HttpStatus.OK);
    }

    @GetMapping("/find-by-phone/{phone}")
    public ResponseEntity<PersonDto> findByPhone(@PathVariable String phone) {
        return new ResponseEntity<>(personService.getPersonByPhone(phone), null, HttpStatus.OK);
    }


    @GetMapping("/find-by-role/{role}")
    public ResponseEntity<List<PersonDto>> findByRole(@PathVariable String role) {
        return new ResponseEntity<>(personService.getPersonByRole(role), null, HttpStatus.OK);
    }


    @PostMapping("/find-by-city")
    public ResponseEntity<List<PersonDto>> findByCity(@RequestBody LocationSearchDto dto) {
        return new ResponseEntity<>(personService.getPersonByCity(dto), null, HttpStatus.OK);
    }

    @PostMapping("/find-by-nearby")
    public ResponseEntity<List<PersonDto>> findByNearby(@RequestBody LocationSearchDto dto) {
        return new ResponseEntity<>(personService.getPersonNearBy(dto), null, HttpStatus.OK);
    }

}
