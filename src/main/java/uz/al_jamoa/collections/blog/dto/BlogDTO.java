package uz.al_jamoa.collections.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlogDTO {
    private UUID ID;
    private String fileGeneratedName;
    private String title;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
