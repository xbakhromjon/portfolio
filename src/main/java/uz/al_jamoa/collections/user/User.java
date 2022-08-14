package uz.al_jamoa.collections.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.al_jamoa.base.entity.BaseEntityID;
import uz.al_jamoa.collections.file.File;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseEntityID {
    private String firstName;
    private String lastName;
    private String occupation;
    private String shortDescription;
    private String youtubeLink;
    private String githubLink;
    private String linkedinLink;
    private String telegramLink;
    private String channelNameLink;
    @OneToOne
    private File aboutMe;

    public User(String firstName, String lastName, String occupation, String shortDescription, String youtubeLink, String githubLink, String linkedinLink, String telegramLink, String channelNameLink) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = occupation;
        this.shortDescription = shortDescription;
        this.youtubeLink = youtubeLink;
        this.githubLink = githubLink;
        this.linkedinLink = linkedinLink;
        this.telegramLink = telegramLink;
        this.channelNameLink = channelNameLink;
    }
}
