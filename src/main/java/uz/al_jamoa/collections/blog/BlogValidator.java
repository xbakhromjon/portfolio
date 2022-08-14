package uz.al_jamoa.collections.blog;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import uz.al_jamoa.collections.blog.dto.BlogCreateDTO;
import uz.al_jamoa.collections.blog.dto.BlogUpdateDTO;
import uz.al_jamoa.exception.UniversalException;

@Component
public class BlogValidator {
    public void checkCreateDTO(BlogCreateDTO createDTO) {
        if (createDTO == null) {
            throw new UniversalException("Blog yaratish uchun kelgan object null bo'lishi mumkun emas", HttpStatus.BAD_REQUEST);
        }
        if (createDTO.getTitle() == null || createDTO.getTitle().isEmpty() || createDTO.getTitle().isBlank()) {
            throw new UniversalException("Blog sarlavhasi null yoki bo'sh bo'lishi mumkun emas", HttpStatus.BAD_REQUEST);
        }
        if (createDTO.getFileGeneratedName() == null || createDTO.getTitle().isEmpty() || createDTO.getFileGeneratedName().isBlank()) {
            throw new UniversalException("Blog file null yoki bo'sh bo'lishi mumkun emas", HttpStatus.BAD_REQUEST);
        }
    }

    public void checkUpdateDTO(BlogUpdateDTO updateDTO) {
        if (updateDTO == null) {
            throw new UniversalException("Blog yaratish uchun kelgan object null bo'lishi mumkun emas", HttpStatus.BAD_REQUEST);
        }
        if (updateDTO.getID() == null) {
            throw new UniversalException("Blog yaratish uchun kelgan objectning IDsi null bo'lishi mumkun emas", HttpStatus.BAD_REQUEST);
        }
        if (updateDTO.getTitle() == null || updateDTO.getTitle().isEmpty() || updateDTO.getTitle().isBlank()) {
            throw new UniversalException("Blog sarlavhasi null yoki bo'sh bo'lishi mumkun emas", HttpStatus.BAD_REQUEST);
        }
        if (updateDTO.getFileGeneratedName() == null || updateDTO.getTitle().isEmpty() || updateDTO.getFileGeneratedName().isBlank()) {
            throw new UniversalException("Blog file null yoki bo'sh bo'lishi mumkun emas", HttpStatus.BAD_REQUEST);
        }
    }
}
