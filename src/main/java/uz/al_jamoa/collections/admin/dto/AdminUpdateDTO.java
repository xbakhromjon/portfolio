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
public class AdminUpdateDTO {
    private UUID ID;
    private String firstName;
    private String lastName;
    private String occupation;
    private String shortDescription;
    private String youtubeLink;
    private String githubLink;
    private String linkedinLink;
    private String telegramLink;
    private String instagramLink;
    private String facebookLink;
    private String twitterLink;
    private String channelNameLink;
    private String aboutMe;
    private String image;
}
