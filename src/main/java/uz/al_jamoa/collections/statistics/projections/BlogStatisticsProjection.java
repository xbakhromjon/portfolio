package uz.al_jamoa.collections.statistics.projections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


public interface BlogStatisticsProjection {
    Boolean getIsViewed();
    LocalDate getViewedAt();
    Boolean getIsLiked();
    LocalDate getLikedAt();
    Boolean getIsDisLiked();
    LocalDate getDisLikedAt();
}
