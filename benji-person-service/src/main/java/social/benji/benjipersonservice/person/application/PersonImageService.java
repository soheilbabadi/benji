package social.benji.benjipersonservice.person.application;


import org.springframework.web.multipart.MultipartFile;
import social.benji.benjipersonservice.person.model.dto.PersonImageDto;

public interface PersonImageService {
    PersonImageDto getImage(String id) throws Exception;

    PersonImageDto postImage(MultipartFile file, String personId) throws Exception;

    void deleteImage(String personId);
}
