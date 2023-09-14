package social.benji.benjipersonservice.person.model.dto;


import jakarta.validation.constraints.NotEmpty;
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

public class PersonImageDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 8214217696639650307L;
    private String personId;

    @NotEmpty
    private byte[] fileContent;

    @NotEmpty
    private String mimeType;

    private String fileName;

    private long fileSize;
}