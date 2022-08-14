package uz.al_jamoa.collections.file;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {
    private final FileService service;

    @PostMapping("/upload")
    private ResponseEntity<UUID> upload(MultipartHttpServletRequest request) throws IOException {
        return service.upload(request);
    }


//    @GetMapping("/view/{generatedName}")
//    private ResponseEntity<InputStreamResource> viewFile(@PathVariable String generatedName) throws FileNotFoundException {
//        return service.viewFile(generatedName);
//    }


//    @GetMapping("/download/{generatedName}")
//    private ResponseEntity<String> download(HttpServletResponse response, @PathVariable String generatedName) throws IOException {
//        return service.download(response, generatedName);
//    }
}
