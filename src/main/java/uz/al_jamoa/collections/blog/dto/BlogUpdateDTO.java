package uz.al_jamoa.collections.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlogUpdateDTO {
    private String ID;
    private String fileGeneratedName;
    private String title;
}
