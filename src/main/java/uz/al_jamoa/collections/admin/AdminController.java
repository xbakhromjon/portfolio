package uz.al_jamoa.collections.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.al_jamoa.collections.admin.dto.AdminCreateDTO;
import uz.al_jamoa.collections.admin.dto.AdminUpdateDTO;

import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @PostMapping("/update")
    private ResponseEntity<?> update(@RequestBody AdminUpdateDTO updateDTO) {
        return service.update(updateDTO);
    }

    @GetMapping("/information")
    private ResponseEntity<?> get() {
        return service.get();
    }
}
