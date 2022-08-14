package uz.al_jamoa.collections.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.al_jamoa.collections.file.File;
import uz.al_jamoa.collections.file.FileRepository;
import uz.al_jamoa.collections.user.dto.UserCreateDTO;
import uz.al_jamoa.collections.user.dto.UserUpdateDTO;
import uz.al_jamoa.exception.BadRequestException;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    private final FileRepository fileRepository;
    public UserService(UserRepository repository, FileRepository fileRepository) {
        this.repository = repository;
        this.fileRepository = fileRepository;
    }

    public ResponseEntity<?> create(UserCreateDTO createDTO){

        Users user=new Users(createDTO.getFirstName(), createDTO.getLastName(), createDTO.getOccupation(), createDTO.getShortDescription(),
                createDTO.getYoutubeLink(), createDTO.getGithubLink(), createDTO.getLinkedinLink(), createDTO.getTelegramLink(), createDTO.getChannelNameLink());


        Optional<File> optional = fileRepository.findById(createDTO.getFileID());
        if (optional.isEmpty()){
            throw new  BadRequestException("File Topilmadi");
        }
        File file = optional.get();
        user.setAboutMe(file);
        repository.save(user);

        return ResponseEntity.ok("Muvaqiyatli yaratildi");
    }

    public ResponseEntity<?> update(UserUpdateDTO updateDTO){
        Optional<Users> byId = repository.findById(updateDTO.getId());
        if (byId.isEmpty()){
            throw new BadRequestException("UserTopilmadi");
        }
        Users user=byId.get();
        user.setFirstName(updateDTO.getFirstName());
        user.setLastName(updateDTO.getLastName());
        user.setOccupation(updateDTO.getOccupation());
        user.setShortDescription(updateDTO.getShortDescription());
        user.setYoutubeLink(updateDTO.getYoutubeLink());
        user.setGithubLink(updateDTO.getGithubLink());
        user.setLinkedinLink(updateDTO.getLinkedinLink());
        user.setTelegramLink(updateDTO.getTelegramLink());
        user.setChannelNameLink(updateDTO.getChannelNameLink());
        Optional<File> optional = fileRepository.findById(updateDTO.getFileID());
        if (optional.isEmpty()){
            throw new  BadRequestException("File Topilmadi");
        }
        File file = optional.get();
        user.setAboutMe(file);
        repository.save(user);

        return ResponseEntity.ok(user);
    }



}
