package social.benji.benjipersonservice.person.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PersonDto implements Serializable {


    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String role;

    private String username;

    private String phone;

    private String profileImage;

    private String city;

    private String country;

    private double latitude;

    private double longitude;

    private LocalDateTime registerOn;

    private LocalDateTime lastLoginOn;

    private boolean verified;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;


}
