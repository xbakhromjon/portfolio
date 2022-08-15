package uz.al_jamoa.collections.statistics.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReactionDTO {
    private String blogID;
    private Boolean reaction;
}
