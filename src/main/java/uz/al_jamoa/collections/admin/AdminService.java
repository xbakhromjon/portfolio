package uz.al_jamoa.collections.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.al_jamoa.collections.admin.dto.AdminDTO;
import uz.al_jamoa.collections.file.File;
import uz.al_jamoa.collections.file.FileRepository;
import uz.al_jamoa.collections.admin.dto.AdminCreateDTO;
import uz.al_jamoa.collections.admin.dto.AdminUpdateDTO;
import uz.al_jamoa.exception.BadRequestException;
import uz.al_jamoa.exception.UniversalException;
import uz.al_jamoa.utils.EntityGetter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository repository;

    private final FileRepository fileRepository;
    private final AdminMapper adminMapper;
    private final EntityGetter entityGetter;



    public ResponseEntity<?> update(AdminUpdateDTO updateDTO) {
        List<Admin> admins = repository.findAll();
        if (admins.size() == 0) {
            throw new BadRequestException("UserTopilmadi");
        }
        Admin user = admins.get(0);
        user.setFirstName(updateDTO.getFirstName());
        user.setLastName(updateDTO.getLastName());
        user.setOccupation(updateDTO.getOccupation());
        user.setShortDescription(updateDTO.getShortDescription());
        user.setYoutubeLink(updateDTO.getYoutubeLink());
        user.setGithubLink(updateDTO.getGithubLink());
        user.setLinkedinLink(updateDTO.getLinkedinLink());
        user.setTwitterLink(updateDTO.getTwitterLink());
        user.setFacebookLink(updateDTO.getFacebookLink());
        user.setInstagramLink(updateDTO.getInstagramLink());
        user.setTelegramLink(updateDTO.getTelegramLink());
        user.setChannelNameLink(updateDTO.getChannelNameLink());
        File aboutMe = null;
        if (updateDTO.getAboutMe() != null) {
            aboutMe = entityGetter.getFile(updateDTO.getAboutMe());
        }
        File image = null;
        if (updateDTO.getImage() != null) {
            image = entityGetter.getFile(updateDTO.getImage());
        }
        user.setAboutMe(aboutMe);
        user.setImage(image);
        Admin saved = repository.save(user);
        AdminDTO adminDTO = adminMapper.toDTO(saved);
        return ResponseEntity.ok(adminDTO);
    }

    public ResponseEntity<?> get() {
        List<Admin> admins = repository.findAll();
        if (admins.size() == 0) {
            throw new UniversalException("Admin mavjud emas", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        AdminDTO adminDTO = adminMapper.toDTO(admins.get(0));
        return ResponseEntity.ok(adminDTO);
    }
}
