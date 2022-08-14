package uz.al_jamoa.collections.admin.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminCreateDTO {
    private String firstName;
    private String lastName;
    private String occupation;
    private String shortDescription;
    private String youtubeLink;
    private String githubLink;
    private String linkedinLink;
    private String telegramLink;
    private String channelNameLink;
    private UUID fileID;
}
