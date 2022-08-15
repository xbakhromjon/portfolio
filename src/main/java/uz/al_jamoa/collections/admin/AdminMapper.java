package uz.al_jamoa.collections.admin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import uz.al_jamoa.collections.admin.dto.AdminDTO;

@Component
public class AdminMapper {

    @Value("${base.url}:${server.port}${server.servlet.context-path}")
    String BASE_URL;

    public AdminDTO toDTO(Admin admin) {
        if (admin == null) {
            return null;
        }
        String aboutMeURL = null;
        String aboutMe = null;
        if (admin.getAboutMe() != null) {
            aboutMeURL = BASE_URL + "/file/view-blog/" + admin.getAboutMe().getGeneratedName();
            aboutMe = admin.getAboutMe().getGeneratedName();
        }
        String imageURL = null;
        String image = null;
        if (admin.getImage() != null) {
            imageURL =  BASE_URL + "/file/view/" + admin.getImage().getGeneratedName();
            image = admin.getImage().getGeneratedName();
        }
        return new AdminDTO(admin
                .getID(), admin.getFirstName(), admin.getLastName(), admin.getOccupation(), admin.getShortDescription(), admin.getYoutubeLink(), admin.getGithubLink(),
                admin.getLinkedinLink(), admin.getTelegramLink(), admin.getInstagramLink(), admin.getFacebookLink(), admin.getChannelNameLink(), aboutMeURL, imageURL, aboutMe, image);
    }
}
