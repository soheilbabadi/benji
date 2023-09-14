package social.benji.benjipersonservice.person.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class PersonImage implements Serializable {

    @Serial
    private static final long serialVersionUID = -46533896583032674L;

    @Id
    private String id;


    @Lob
    @Column(nullable = false)
    private byte[] fileContent;

    @Column(length = 50,nullable = false, columnDefinition = "varchar(50)")
    private String mimeType;

    @Column(nullable = false)
    private LocalDateTime registerOn;


    @Column(nullable = false)
    private LocalDateTime updateOn;

    @Column(length = 50,nullable = false, columnDefinition = "varchar(50)")
    private String filename;

    @Column(nullable = false)
    private long fileSize;

    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Person.class)
    private Person person;
}