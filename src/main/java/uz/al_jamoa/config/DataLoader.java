package uz.al_jamoa.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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

    @Value(value = "${spring.jpa.hibernate.ddl-auto}")
    private String ddl;


    @Override
    public void run(String... args) throws Exception {
        if (ddl.equals("create") || ddl.equals("create-drop")) {
            Admin admin = new Admin("Bakhromjon", "Khasanboyev", "bakhromjon.com", passwordEncoder.encode("bakhromjon123"));
            admin.setOccupation("Backend Developer");
            admin.setGithubLink("https://github.com/xbakhromjon");
            admin.setLinkedinLink("https://github.com/xbakhromjon");
            admin.setTelegramLink("https://github.com/xbakhromjon");
            admin.setChannelNameLink("https://t.me/s/test_xolos");
            admin.setYoutubeLink("https://github.com/xbakhromjon");
            admin.setShortDescription("I write about non-technical stuff in the technical world.");
            adminRepository.save(admin);
        }
    }
}
