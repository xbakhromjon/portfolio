package uz.al_jamoa.collections.statistics;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.al_jamoa.collections.statistics.dto.BlogStatisticsDTO;
import uz.al_jamoa.collections.statistics.dto.ReactionDTO;
import uz.al_jamoa.collections.statistics.dto.StatisticsCountDTO;
import uz.al_jamoa.collections.statistics.projections.BlogStatisticsProjection;
import uz.al_jamoa.utils.BaseUtilsService;

import java.util.*;

@Service
@RequiredArgsConstructor
public class BlogStatisticsService {
    private final BlogStatisticsRepository repository;
    private final BaseUtilsService baseUtilsService;

    public ResponseEntity<Boolean> like(ReactionDTO reactionDTO, MultipartHttpServletRequest request) {
        UUID blogID = baseUtilsService.parseUUID(reactionDTO.getBlogID());
        String ip = baseUtilsService.getClientIpAddress(request);
        repository.like(blogID, ip, reactionDTO.getReaction());
        return ResponseEntity.ok(true);
    }

    public ResponseEntity<Boolean> disLike(ReactionDTO reactionDTO, MultipartHttpServletRequest request) {
        UUID blogID = baseUtilsService.parseUUID(reactionDTO.getBlogID());
        String ip = baseUtilsService.getClientIpAddress(request);
        repository.disLike(blogID, ip, reactionDTO.getReaction());
        return ResponseEntity.ok(true);
    }

    public ResponseEntity<List<BlogStatisticsDTO>> statistics(Integer year) {
        List<BlogStatisticsProjection> blogStatisticsProjections = repository.statistics(year);
        HashMap<Integer, StatisticsCountDTO> map = new HashMap<>();
        map.put(1, new StatisticsCountDTO(10, 11, 12));
        map.put(2, new StatisticsCountDTO(10, 11, 12));
        map.put(3, new StatisticsCountDTO(10, 11, 12));
        map.put(4, new StatisticsCountDTO(10, 11, 12));
        map.put(5, new StatisticsCountDTO(10, 11, 12));
        map.put(6, new StatisticsCountDTO(10, 11, 12));
        map.put(7, new StatisticsCountDTO(10, 11, 12));
        map.put(8, new StatisticsCountDTO(10, 11, 12));
        map.put(9, new StatisticsCountDTO(10, 11, 12));
        map.put(10, new StatisticsCountDTO(10, 11, 12));
        map.put(11, new StatisticsCountDTO(10, 11, 12));
        map.put(12, new StatisticsCountDTO(10, 11, 12));
        for (BlogStatisticsProjection blogStatisticsProjection : blogStatisticsProjections) {
            StatisticsCountDTO statisticsCountDTO1 = map.get(blogStatisticsProjection.getViewedAt().getMonthValue());
            statisticsCountDTO1.setViews(statisticsCountDTO1.getViews() + 1);
            StatisticsCountDTO statisticsCountDTO2 = map.get(blogStatisticsProjection.getLikedAt().getMonthValue());
            if (blogStatisticsProjection.getIsLiked()) {
                statisticsCountDTO2.setLikes(statisticsCountDTO2.getLikes() + 1);
            }
            StatisticsCountDTO statisticsCountDTO3 = map.get(blogStatisticsProjection.getViewedAt().getMonthValue());
            if (blogStatisticsProjection.getIsDisLiked()) {
                statisticsCountDTO3.setDisLikes(statisticsCountDTO3.getDisLikes() + 1);
            }
        }
        List<BlogStatisticsDTO> blogStatisticsDTOs = makeBlogStatisticsDTO(map);
        return ResponseEntity.ok(blogStatisticsDTOs);
    }

    private List<BlogStatisticsDTO> makeBlogStatisticsDTO(HashMap<Integer, StatisticsCountDTO> map) {
        List<BlogStatisticsDTO> blogStatisticsDTOs = new ArrayList<>();
        for (Map.Entry<Integer, StatisticsCountDTO> entry : map.entrySet()) {
            StatisticsCountDTO value = entry.getValue();
            BlogStatisticsDTO blogStatisticsDTO = new BlogStatisticsDTO(entry.getKey(), value.getViews(), value.getLikes(), value.getDisLikes());
            blogStatisticsDTOs.add(blogStatisticsDTO);
        }
        return blogStatisticsDTOs;
    }
}
