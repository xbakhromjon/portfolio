package uz.al_jamoa.collections.blog;

import org.springframework.stereotype.Component;
import uz.al_jamoa.collections.blog.dto.BlogDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class BlogMapper {
    BlogDTO toDTO(Blog blog) {
        if (blog == null) {
            return null;
        }
        return new BlogDTO(blog.getID(), blog.getFile().getGeneratedName(), blog.getTitle(), blog.getCreatedAt(), blog.getUpdatedAt());
    }

    List<BlogDTO> toDTO(List<Blog> blogs) {
        List<BlogDTO> blogDTOs = new ArrayList<>();
        blogs.forEach(item -> {
            BlogDTO blogDTO = toDTO(item);
            blogDTOs.add(blogDTO);
        });
        return blogDTOs;
    }
}
