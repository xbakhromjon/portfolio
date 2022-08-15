package uz.al_jamoa.collections.statistics;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.al_jamoa.collections.statistics.dto.BlogStatisticsDTO;
import uz.al_jamoa.collections.statistics.dto.ReactionDTO;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class BlogStatisticsController {
    private final BlogStatisticsService service;

    @PostMapping("/like")
    private ResponseEntity<Boolean> like(@RequestBody ReactionDTO reactionDTO, MultipartHttpServletRequest request) throws IOException {
        return service.like(reactionDTO, request);
    }



    @PostMapping("/disLike")
    private ResponseEntity<Boolean> disLike(@RequestBody ReactionDTO reactionDTO, MultipartHttpServletRequest request) throws IOException {
        return service.disLike(reactionDTO, request);
    }


    @GetMapping("/{year}")
    private ResponseEntity<List<BlogStatisticsDTO>> statistics(@PathVariable Integer year) throws IOException {
        return service.statistics(year);
    }
}



