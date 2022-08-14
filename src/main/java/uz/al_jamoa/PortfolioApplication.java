package uz.al_jamoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import javax.swing.*;
import java.util.Arrays;
import java.util.Properties;

@SpringBootApplication
public class PortfolioApplication {
    public static void main(String[] args) {
        boolean isStart = isStart();
        if (isStart) {
            SpringApplication.run(PortfolioApplication.class, args);
        } else {
            System.out.println("Iltimos application.properties ddl-auto ni update qiling aks holda baza o'chib ketishi mumkin!");
        }
    }

    @Configuration
    public static class CorsConfiguration extends org.springframework.web.cors.CorsConfiguration {
        @Bean
        public CorsWebFilter corsFilter() {
            org.springframework.web.cors.CorsConfiguration corsConfiguration = new org.springframework.web.cors.CorsConfiguration();
            corsConfiguration.setAllowCredentials(true);
            corsConfiguration.addAllowedOrigin("http://localhost:3000/");
            corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "PATCH"));
            corsConfiguration.addAllowedHeader("*");
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", corsConfiguration);
            return new CorsWebFilter(source);
        }
    }

    @Bean
    public static boolean isStart() {
        Properties props = new Properties();
        try {
            props.load(new ClassPathResource("/application.properties").getInputStream());
            if (props.getProperty("spring.jpa.hibernate.ddl-auto").equals("update")) {
                return true;
            } else {
                String confirm = JOptionPane.showInputDialog("Ma'lumotlarni o'chirib yuborish uchun tasdiqlash kodini kiriting");
                if (confirm != null && confirm.equals("al-jamoa")) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
