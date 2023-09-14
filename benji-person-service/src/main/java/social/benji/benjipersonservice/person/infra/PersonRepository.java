package social.benji.benjipersonservice.person.infra;

import social.benji.benjipersonservice.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

    Optional<Person> findByUsername(String username);
    Optional<Person> findByEmail(String email);
    Optional<Person> findByPhone(String phone);

    Optional<Person> findByEmailAndPassword(String email, String password);

    List<Person> findAllByCountryAndCity(String country, String City);

    List<Person> findAllByRole(String role);
}
