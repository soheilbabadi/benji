package social.benji.benjipersonservice.person.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = -2007995403629014635L;

    @Id
    private String id;

    @Column(length = 50, nullable = false, columnDefinition = "varchar(50)")
    private String firstName;

    @Column(length = 50, nullable = false, columnDefinition = "varchar(50)")
    private String lastName;

    @Column(length = 50, nullable = false, columnDefinition = "varchar(50)", unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false, columnDefinition = "varchar(50)")
    private Role role;

    @Column(length = 500, nullable = false, columnDefinition = "varchar(500)")
    private String password;

    @Column(length = 50, nullable = false, columnDefinition = "varchar(50)", unique = true)
    private String username;

    @Column(length = 50, nullable = false, columnDefinition = "varchar(50)")
    private String phone;

    @Column(length = 50, nullable = false, columnDefinition = "varchar(50)")
    private String profileImage;

    @Column(length = 50, nullable = false, columnDefinition = "varchar(50)")
    private String city;

    @Column(length = 50, nullable = false, columnDefinition = "varchar(50)")
    private String country;

    private double latitude;
    private double longitude;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime registerOn;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime lastLoginOn;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean verified;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean accountNonExpired;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean accountNonLocked;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean credentialsNonExpired;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean enabled;

    @OneToMany(targetEntity = PersonImage.class, cascade = CascadeType.ALL, mappedBy = "person", fetch = FetchType.EAGER)
    private List<PersonImage> personImages;

}
