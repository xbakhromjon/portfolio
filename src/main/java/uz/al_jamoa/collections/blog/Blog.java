package uz.al_jamoa.collections.blog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.al_jamoa.base.entity.BaseEntityID;
import uz.al_jamoa.collections.file.File;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Blog extends BaseEntityID {
    @OneToOne
    private File file;
    private String title;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
