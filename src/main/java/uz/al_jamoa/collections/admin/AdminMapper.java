package uz.al_jamoa.collections.admin;

import org.springframework.stereotype.Component;
import uz.al_jamoa.collections.admin.dto.AdminDTO;

@Component
public class AdminMapper {

    public AdminDTO toDTO(Admin admin) {
        if (admin == null) {
            return null;
        }
        String aboutMe = null;
        if (admin.getAboutMe() != null) {
            aboutMe = admin.getAboutMe().getGeneratedName();
        }
        return new AdminDTO(admin
                .getID(), admin.getFirstName(), admin.getLastName(), admin.getOccupation(), admin.getShortDescription(), admin.getYoutubeLink(), admin.getGithubLink(),
                admin.getLinkedinLink(), admin.getTelegramLink(), admin.getChannelNameLink(), aboutMe);
    }
}
