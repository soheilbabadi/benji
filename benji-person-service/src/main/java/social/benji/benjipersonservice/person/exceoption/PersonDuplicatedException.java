package social.benji.benjipersonservice.person.exceoption;

public class PersonDuplicatedException extends RuntimeException {
    public PersonDuplicatedException(String message) {
        super(message);
    }

    public PersonDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

}
