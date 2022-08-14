package uz.al_jamoa.collections.blog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.al_jamoa.base.entity.BaseEntityID;
import uz.al_jamoa.collections.file.File;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Blog extends BaseEntityID {
    private File file;
    private String title;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
