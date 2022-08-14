package uz.al_jamoa.collections.file;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.al_jamoa.exception.UniversalException;

import java.io.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepository repository;

    @Value("${file.path}")
    String FILE_PATH;

    @Value("${base.url}:${server.port}${server.servlet.context-path}")
    String BASE_URL;

    public ResponseEntity<String> upload(MultipartHttpServletRequest request) throws IOException {
        java.io.File file2 = new java.io.File(FILE_PATH);
        if (!file2.isDirectory()) {
            file2.mkdirs();
        }
        MultipartFile file = request.getFile("file");
        if (file != null) {
            if (file.getSize() > 100 * 1024 * 1024) {
                throw new UniversalException("File hajmi 100 mb dan kichik bo'lishi kerak", HttpStatus.BAD_REQUEST);
            }
            String contentType = file.getContentType();
            String originalFilename = file.getOriginalFilename();
            long size = file.getSize();
            String extention = ".md";
            if (contentType != null && !contentType.contains("markdown")) {
                throw new UniversalException("File formati .md bo'lishi kerak", HttpStatus.BAD_REQUEST);
            }
            String generatedName = UUID.randomUUID() + extention;
            String url = FILE_PATH + "/" + generatedName;
            FileOutputStream fileOutputStream = new FileOutputStream(new File(url));
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();
            fileOutputStream.flush();
            uz.al_jamoa.collections.file.File fileEntity = new uz.al_jamoa.collections.file.File(url, originalFilename, extention, generatedName, size);
            uz.al_jamoa.collections.file.File saved = repository.save(fileEntity);
            return ResponseEntity.ok(saved.getGeneratedName());
        } else {
            throw new UniversalException("File null bo'lishi mumkin emas", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> uploadImage(MultipartHttpServletRequest request) throws IOException {
        java.io.File file2 = new java.io.File(FILE_PATH);
        if (!file2.isDirectory()) {
            file2.mkdirs();
        }
        MultipartFile file = request.getFile("file");
        if (file != null) {
            if (file.getSize() > 100 * 1024 * 1024) {
                throw new UniversalException("File hajmi 100 mb dan kichik bo'lishi kerak", HttpStatus.BAD_REQUEST);
            }
            String contentType = file.getContentType();
            String originalFilename = file.getOriginalFilename();
            long size = file.getSize();
            String extention = "";
            if (contentType != null && !contentType.contains("png") && !contentType.contains("jpg") && !contentType.contains("jpeg")) {
                throw new UniversalException("Rasm formati png/jpg/jpeg bo'lishi kerak", HttpStatus.BAD_REQUEST);
            }
            if (contentType.contains("png")) {
                extention = ".png";
            } else if (contentType.contains("jpg")) {
                extention = ".jpg";
            } else if (contentType.contains("jpeg")) {
                extention = ".jpeg";
            }
            String generatedName = UUID.randomUUID() + extention;
            String url = FILE_PATH + "/" + generatedName;
            FileOutputStream fileOutputStream = new FileOutputStream(new File(url));
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();
            fileOutputStream.flush();
            uz.al_jamoa.collections.file.File fileEntity = new uz.al_jamoa.collections.file.File(url, originalFilename, extention, generatedName, size);
            uz.al_jamoa.collections.file.File saved = repository.save(fileEntity);
            String response = BASE_URL + "/file/view/" + generatedName;
            return ResponseEntity.ok(response);
        } else {
            throw new UniversalException("File null bo'lishi mumkin emas", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<InputStreamResource> viewFile(String generatedName) throws FileNotFoundException {
        uz.al_jamoa.collections.file.File fileEntity = findFile(generatedName);
        File send = new File(fileEntity.getFilePath());
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-disposition", "inline;filename=" + fileEntity.getOriginalName());
        InputStreamResource resource = new InputStreamResource(new FileInputStream(send));
        return ResponseEntity.ok().headers(headers).contentLength(send.length()).contentType(MediaType.parseMediaType(fileEntity.())).body(resource);
    }

    private uz.al_jamoa.collections.file.File findFile(String generatedName) {
        Optional<uz.al_jamoa.collections.file.File> fileOptional = repository.findByGeneratedName(generatedName);
        if (fileOptional.isEmpty()) {
            throw new UniversalException("File topilmadi", HttpStatus.NOT_FOUND);
        }
        return fileOptional.get();
    }
}
