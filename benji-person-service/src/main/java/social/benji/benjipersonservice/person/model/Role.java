package social.benji.benjipersonservice.person.model;

public enum Role  {

    ADMIN("ADMIN"),
    MODERATOR("MODERATOR"),
    TRUSTED("TRUSTED"),
    UNTRUSTED("UNTRUSTED")
    ;

    private  String name;
    public String getName() {
        return name;
    }
    Role(String name) {
        this.name = name;
    }

}
