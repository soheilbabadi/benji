package social.benji.benjipersonservice.person.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationSearchDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 8105230460908342440L;

    private String city;
    private String country;

}
