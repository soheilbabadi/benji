package social.benji.benjipersonservice.person.application;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import social.benji.benjipersonservice.person.exceoption.PersonNotFoundException;
import social.benji.benjipersonservice.person.infra.PersonImageRepository;
import social.benji.benjipersonservice.person.infra.PersonRepository;
import social.benji.benjipersonservice.person.model.PersonImage;
import social.benji.benjipersonservice.person.model.dto.PersonImageDto;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static social.benji.benjipersonservice.person.application.ImageUtil.thumbnail;


@Service
@RequiredArgsConstructor
public class PersonImageServiceImpl implements PersonImageService {

    private final PersonImageRepository imageDao;

    private final PersonRepository personRepository;

    @Override
    public PersonImageDto getImage(String id)  {
        var dto = new PersonImageDto();
        var picture = imageDao.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Image not found"));

        BeanUtils.copyProperties(picture, dto);
        return dto;

    }

    @Override
    public PersonImageDto postImage(MultipartFile file, String personId) throws IOException {

        var person = personRepository.findByUsername(personId)
                .orElseThrow(() -> new PersonNotFoundException("person not found"));

        if (imageDao.existsById(personId))
            deleteImage(personId);
        var userImage = PersonImage.builder()
                .mimeType(file.getContentType())
                .person(person)
                .fileSize(file.getSize())
                .filename(file.getOriginalFilename())
                .registerOn(LocalDateTime.now(ZoneId.of("UTC")))
                .updateOn(LocalDateTime.now(ZoneId.of("UTC")))
                .fileContent(thumbnail(file))
                .build();
        imageDao.save(userImage);
        return PersonImageDto.builder()
                .personId(personId).mimeType(userImage.getMimeType())
                .fileSize(userImage.getFileSize())
                .fileName(userImage.getFilename())
                .fileContent(userImage.getFileContent()).build();
    }

    @Override
    public void deleteImage(String personId)  {
        var person = personRepository.findByUsername(personId)
                .orElseThrow(() -> new PersonNotFoundException("person not found"));

         imageDao.deleteByPerson(person);

    }

}
