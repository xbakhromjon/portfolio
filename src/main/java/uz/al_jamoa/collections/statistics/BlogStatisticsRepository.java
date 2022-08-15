package uz.al_jamoa.collections.statistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.al_jamoa.collections.statistics.projections.BlogStatisticsProjection;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface BlogStatisticsRepository extends JpaRepository<BlogStatistics, UUID> {
    @Modifying
    @Query(nativeQuery = true, value = "update blog_statistics set is_liked = :reaction, liked_at = current_date where blogid = :blogID and ip = :ip")
    void like(UUID blogID, String ip, Boolean reaction);

    @Modifying
    @Query(nativeQuery = true, value = "update blog_statistics set is_dis_liked = :reaction, dis_liked_at = current_date where blogid = :blogID and ip = :ip;")
    void disLike(UUID blogID, String ip, Boolean reaction);

    @Query(nativeQuery = true, value = "select exists(select * from blog_statistics where blogid = :blogID and ip = :ip)")
    boolean existsBy(UUID blogID, String ip);

    @Query(nativeQuery = true, value = "select is_viewed    as isViewed,\n" +
            "       viewed_at    as viewedAt,\n" +
            "       is_liked     as isLiked,\n" +
            "       liked_at     as likedAt,\n" +
            "       is_dis_liked as isDisliked,\n" +
            "       dis_liked_at    disLikedAt\n" +
            "from blog_statistics\n" +
            "where extract(year from viewed_at) = :year")
    List<BlogStatisticsProjection> statistics(Integer year);
}


