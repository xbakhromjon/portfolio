package uz.al_jamoa.collections.file;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {
    private final FileService service;

    @PostMapping("/upload")
    private ResponseEntity<String> upload(MultipartHttpServletRequest request) throws IOException {
        return service.upload(request);
    }

    @PostMapping("/upload/image")
    private ResponseEntity<String> uploadImage(MultipartHttpServletRequest request) throws IOException {
        return service.uploadImage(request);
    }

    @PostMapping("/upload/post/image")
    private ResponseEntity<String> uploadPostImage(MultipartHttpServletRequest request) throws IOException {
        return service.uploadPostImage(request);
    }

    @GetMapping("/view/{generatedName}")
    private ResponseEntity<InputStreamResource> viewFile(@PathVariable String generatedName) throws FileNotFoundException {
        return service.viewFile(generatedName);
    }

    @GetMapping("/view-blog/{generatedName}")
    private ResponseEntity<InputStreamResource> viewBlogFile(@PathVariable String generatedName, MultipartHttpServletRequest request) throws FileNotFoundException {
        return service.viewBlogFile(generatedName, request);
    }


    @GetMapping("/download/{generatedName}")
    private ResponseEntity<String> download(HttpServletResponse response, @PathVariable String generatedName) throws IOException {
        return service.download(response, generatedName);
    }
}
