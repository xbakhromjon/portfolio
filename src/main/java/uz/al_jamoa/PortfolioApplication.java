package uz.al_jamoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import javax.swing.*;
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
