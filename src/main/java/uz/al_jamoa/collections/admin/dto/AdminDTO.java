package uz.al_jamoa.collections.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.al_jamoa.collections.file.File;

import javax.persistence.OneToOne;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
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
    private String channelNameLink;
    private String aboutMeURL;
    private String imageURL;
    private String aboutMe;
    private String image;
}
