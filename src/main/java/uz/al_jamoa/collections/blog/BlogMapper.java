package uz.al_jamoa.collections.blog;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import uz.al_jamoa.collections.blog.dto.BlogDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class BlogMapper {
    @Value("${base.url}:${server.port}${server.servlet.context-path}")
    String BASE_URL;

    BlogDTO toDTO(Blog blog) {
        if (blog == null) {
            return null;
        }
        String fileURL = BASE_URL + "/file/view-blog/" + blog.getFile().getGeneratedName();
        return new BlogDTO(blog.getID(), fileURL, blog.getTitle(), blog.getCreatedAt(), blog.getUpdatedAt());
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
