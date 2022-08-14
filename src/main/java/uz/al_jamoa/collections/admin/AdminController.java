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

    @PostMapping("/create")
    private ResponseEntity<?> create(@RequestBody AdminCreateDTO createDTO){
        return service.create(createDTO);
    }

    @PostMapping("/update")
    private ResponseEntity<?> update(@RequestBody AdminUpdateDTO updateDTO){
        return service.update(updateDTO);
    }

    @GetMapping("/get")
    private ResponseEntity<?> get(@PathVariable UUID uuid){
        return service.get(uuid);
    }
}
