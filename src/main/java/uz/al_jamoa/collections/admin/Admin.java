package uz.al_jamoa.collections.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.al_jamoa.base.entity.BaseEntityID;
import uz.al_jamoa.collections.file.File;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Collection;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin extends BaseEntityID implements UserDetails {
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
    private String username;
    private String password;

    public Admin(String firstName, String lastName, String occupation, String shortDescription, String youtubeLink, String githubLink, String linkedinLink, String telegramLink, String channelNameLink) {

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

    public Admin(String firstName, String lastName, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = login;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
