package uz.al_jamoa.collections.blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface BlogRepository extends JpaRepository<Blog, UUID> {
    @Query(nativeQuery = true, value = "select * from blog where not is_deleted order by created_at")
    List<Blog> findAllByIsDeleted();

    @Modifying
    @Query(nativeQuery = true, value = "update blog set views = views + 1 where file_id = (select id from file where generated_name = :generatedName)")
    void incViews(String generatedName);

    @Query(nativeQuery = true,value = "select cast (id as text) from blog where file_id = (select id from file where generated_name = :generatedName)")
    UUID getBlogIDByFileGeneratedName(String generatedName);
}
