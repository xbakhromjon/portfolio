package uz.al_jamoa.collections.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.al_jamoa.exception.UniversalException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class FileService {

    @Value("${file.path}")
    String FILE_PATH;

    public ResponseEntity<UUID> upload(MultipartHttpServletRequest request) {
//        Path path = Path.of(FILE_PATH);
//        java.io.File file2 = new java.io.File(FILE_PATH);
//        if (!file2.isDirectory()) {
//            file2.mkdirs();
//        }
//        MultipartFile file = request.getFile("file");
//        if (file != null) {
//            if (file.getSize() > 100 * 1024 * 1024) {
//                throw new UniversalException("File hajmi 100 mb dan kichik bo'lishi kerak", HttpStatus.BAD_REQUEST);
//            }
//            String contentType = file.getContentType();
//            String originalFilename = file.getOriginalFilename();
//            long size = file.getSize();
//            String extention = "";
//            if (contentType.contains("pdf")) {
//                extention = ".pdf";
//            } else if (contentType.contains("png")) {
//                extention = ".png";
//            } else if (contentType.contains("jpg")) {
//                extention = ".jpg";
//            } else if (contentType.contains("jpeg")) {
//                extention = ".jpeg";
//            } else if (contentType.contains("word")) {
//                extention = ".docx";
//            }
//            String generatedName = UUID.randomUUID() + extention;
////            String url = folder + "/" + generatedName;
//            String url = folder + "\\" + generatedName;
//            FileOutputStream fileOutputStream = new FileOutputStream(new File(url));
//            fileOutputStream.write(file.getBytes());
//            fileOutputStream.close();
//            fileOutputStream.flush();
//            uz.ddoc.collections.file.File fileEntity = new uz.ddoc.collections.file.File();
//            fileEntity.setFilePath(url);
//            fileEntity.setExtention(contentType);
//            fileEntity.setSize(size);
//            fileEntity.setOriginalName(originalFilename);
//            fileEntity.setGeneratedName(generatedName);
//            fileEntity.setCreatedBy(sessionUser.getId());
//            fileEntity.setCreatedBy(-1L);
//            uz.ddoc.collections.file.File save = repository.save(fileEntity);
//            return ResponseEntity.ok(new Data<>(save.getId()));
//        } else {
//            throw new BadRequestException("File null bo'lishi mumkin emas");
//        }
        return null;
    }
}
