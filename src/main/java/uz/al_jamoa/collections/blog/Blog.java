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
    private Boolean isDeleted;
    private LocalDate deletedAt;
    private Integer likes = 0;
    private Integer disLikes = 0;
    private Integer views = 0;

    public Blog(File file, String title, LocalDate createdAt) {
        this.file = file;
        this.title = title;
        this.createdAt = createdAt;
    }
}
