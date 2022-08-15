package uz.al_jamoa.collections.statistics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.al_jamoa.base.entity.BaseEntityID;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BlogStatistics extends BaseEntityID {
    private UUID blogID;
    @Column(nullable = false)
    private String ip;
    private Boolean isViewed = true;
    private LocalDate viewedAt = LocalDate.now();
    private Boolean isLiked;
    private LocalDate likedAt;
    private Boolean isDisLiked;
    private LocalDate disLikedAt;

    public BlogStatistics(UUID blogID, String ip) {
        this.blogID = blogID;
        this.ip = ip;
    }
}
