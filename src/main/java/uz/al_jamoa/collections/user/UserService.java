package uz.al_jamoa.collections.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.al_jamoa.collections.file.File;
import uz.al_jamoa.collections.user.dto.UserCreateDTO;
import uz.al_jamoa.collections.user.dto.UserUpdateDTO;
import uz.al_jamoa.exception.BadRequestException;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> create(UserCreateDTO createDTO){

        User user=new User(createDTO.getFirstName(), createDTO.getLastName(), createDTO.getOccupation(), createDTO.getShortDescription(),
                createDTO.getYoutubeLink(), createDTO.getGithubLink(), createDTO.getLinkedinLink(), createDTO.getTelegramLink(), createDTO.getChannelNameLink());

        repository.save(user);

        return ResponseEntity.ok("Muvaqiyatli yaratildi");
    }

    public ResponseEntity<?> update(UserUpdateDTO updateDTO){
        Optional<User> byId = repository.findById(updateDTO.getId());
        if (byId.isEmpty()){
            throw new BadRequestException("UserTopilmadi");
        }
        User user=byId.get();
        user.setFirstName(updateDTO.getFirstName());
        user.setLastName(updateDTO.getLastName());
        user.setOccupation(updateDTO.getOccupation());
        user.setShortDescription(updateDTO.getShortDescription());
        user.setYoutubeLink(updateDTO.getYoutubeLink());
        user.setGithubLink(updateDTO.getGithubLink());
        user.setLinkedinLink(updateDTO.getLinkedinLink());
        user.setTelegramLink(updateDTO.getTelegramLink());
        user.setChannelNameLink(updateDTO.getChannelNameLink());
        repository.save(user);

        return ResponseEntity.ok(user);
    }


}
