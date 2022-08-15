package uz.al_jamoa.collections.statistics.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsCountDTO {
    private Integer views = 0;
    private Integer likes = 0;
    private Integer disLikes = 0;
}
