package uz.al_jamoa.collections.blog;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.al_jamoa.collections.blog.dto.BlogCreateDTO;
import uz.al_jamoa.collections.blog.dto.BlogDTO;
import uz.al_jamoa.collections.blog.dto.BlogUpdateDTO;
import uz.al_jamoa.collections.file.File;
import uz.al_jamoa.utils.BaseUtilsService;
import uz.al_jamoa.utils.EntityGetter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository repository;
    private final BlogValidator validator;
    private final EntityGetter entityGetter;
    private final BaseUtilsService baseUtilsService;
    private final BlogMapper mapper;

    public ResponseEntity<?> create(BlogCreateDTO createDTO) {
        validator.checkCreateDTO(createDTO);
        File file = entityGetter.getFile(createDTO.getFileGeneratedName());
        Blog blog = new Blog(file, createDTO.getTitle(), LocalDate.now());
        Blog saved = repository.save(blog);
        BlogDTO blogDTO = mapper.toDTO(saved);
        return ResponseEntity.ok(blogDTO);
    }

    public ResponseEntity<?> update(BlogUpdateDTO updateDTO) {
        validator.checkUpdateDTO(updateDTO);
        UUID ID = baseUtilsService.parseUUID(updateDTO.getID());
        Blog blog = entityGetter.getBlog(ID);
        File newFile = entityGetter.getFile(updateDTO.getFileGeneratedName());
        blog.setFile(newFile);
        blog.setTitle(updateDTO.getTitle());
        blog.setUpdatedAt(LocalDate.now());
        Blog updated = repository.save(blog);
        return ResponseEntity.ok(updated);
    }

    public ResponseEntity<?> get(String id) {
        UUID ID = baseUtilsService.parseUUID(id);
        Blog blog = entityGetter.getBlog(ID);
        BlogDTO blogDTO = mapper.toDTO(blog);
        return ResponseEntity.ok(blogDTO);
    }

    public ResponseEntity<?> list() {
        List<Blog> blogs = repository.findAllByIsDeleted();
        List<BlogDTO> blogDTOs = mapper.toDTO(blogs);
        return ResponseEntity.ok(blogDTOs);
    }
}
