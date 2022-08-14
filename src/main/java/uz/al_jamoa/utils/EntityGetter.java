package uz.al_jamoa.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import uz.al_jamoa.collections.blog.Blog;
import uz.al_jamoa.collections.blog.BlogRepository;
import uz.al_jamoa.collections.file.File;
import uz.al_jamoa.collections.file.FileRepository;
import uz.al_jamoa.exception.UniversalException;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EntityGetter {
    private final FileRepository fileRepository;
    private final BlogRepository blogRepository;

    public File getFile(String generateName) {
        Optional<File> optional = fileRepository.findByGeneratedName(generateName);
        return optional.orElseThrow(() -> {
            throw new UniversalException("File topilmadi", HttpStatus.NOT_FOUND);
        });
    }

    public Blog getBlog(UUID id) {
        Optional<Blog> optional = blogRepository.findById(id);
        return optional.orElseThrow(() -> {
            throw new UniversalException("Blog topilmadi", HttpStatus.NOT_FOUND);
        });
    }
}


