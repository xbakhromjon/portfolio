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
}
