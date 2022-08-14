package uz.al_jamoa.utils;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.al_jamoa.exception.UniversalException;

import java.util.UUID;

@Service
public class BaseUtilsService {
    public UUID parseUUID(String id) {
        try {
            return UUID.fromString(id);
        } catch (Exception e) {
            throw new UniversalException("ID UUID formatda bo'lishi kerak", HttpStatus.BAD_REQUEST);
        }
    }
}
