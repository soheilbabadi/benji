package social.benji.benjipersonservice.person.infra;

import social.benji.benjipersonservice.person.model.Person;
import social.benji.benjipersonservice.person.model.PersonImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonImageRepository extends JpaRepository<PersonImage,String> {


    Optional<PersonImage> findByPerson(Person person);

    void  deleteByPerson(Person person);
}
