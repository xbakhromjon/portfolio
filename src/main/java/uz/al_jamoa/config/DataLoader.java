package uz.al_jamoa.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.al_jamoa.collections.admin.Admin;
import uz.al_jamoa.collections.admin.AdminRepository;

@Configuration
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Admin admin = new Admin("Bakhromjon", "Khasanboyev", "bakhromjon.com", passwordEncoder.encode("bakhromjon123"));
        adminRepository.save(admin);
    }
}
