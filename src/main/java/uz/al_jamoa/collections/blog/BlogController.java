package uz.al_jamoa.collections.blog;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.al_jamoa.collections.blog.dto.BlogCreateDTO;
import uz.al_jamoa.collections.blog.dto.BlogUpdateDTO;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService service;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody BlogCreateDTO createDTO) {
        return service.create(createDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(String id) {
        return service.get(id);
    }

    @PatchMapping()
    public ResponseEntity<?> update(@RequestBody BlogUpdateDTO updateDTO) {
        return service.update(updateDTO);
    }

    @GetMapping()
    public ResponseEntity<?> list() {
        return service.list();
    }
}
