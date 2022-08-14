package uz.al_jamoa.collections.blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BlogRepository extends JpaRepository<Blog, UUID> {
    @Query(nativeQuery = true, value = "select * from blog where not is_deleted order by created_at")
    List<Blog> findAllByIsDeleted();
}
