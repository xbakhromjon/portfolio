package uz.al_jamoa.collections.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.al_jamoa.collections.user.dto.UserCreateDTO;

import javax.xml.crypto.Data;

@RestController
@RequestMapping("user/")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("create")
    private ResponseEntity<?> create(@RequestBody UserCreateDTO createDTO){
        return service.create(createDTO);
    }
}
