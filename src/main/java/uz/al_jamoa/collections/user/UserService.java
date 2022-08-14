package uz.al_jamoa.collections.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.al_jamoa.collections.user.dto.UserCreateDTO;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> create(UserCreateDTO createDTO){



        return ResponseEntity.ok("Muvaqiyatli yaratildi");
    }


}
